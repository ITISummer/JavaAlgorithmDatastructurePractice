package datastructure.hashmap;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 描述：布隆过滤器 大数查重 查询指定的数据是否存在 优点：集中了hash表和位图的优势 ：查询快O(1) 不需要知道数列中的元素最大值 占用内存小
 * 缺点：错误率 只支持添加和查询操作，不支持删除操作
 * 
 * @author LCX
 *
 */
public class BloemFilter {
	// 位数组
	private byte[] bits;
	//位数的大小
	private int bitSize;

	/**
	 * 初始化
	 * 
	 * @param size
	 */
	public BloemFilter(int size) {
		this.bitSize = size; 
		this.bits = new byte[this.bitSize/8+1]; // size*8个bit位
		
	}

	/**
	 * 添加元素
	 * @param url
	 */
	public void put(String url) {
		int h1 = hash1(url);
		int h2 = hash2(url);
		int h3 = hash3(url);

		int index, offset;
		index = h1 / 8;
		offset = h1 % 8;
		bits[index] |= (1 << offset);

		index = h2 / 8;
		offset = h2 % 8;
		bits[index] |= (1 << offset);

		index = h3 / 8;
		offset = h3 % 8;
		bits[index] |= (1 << offset);
	}
	
	/**
	 * 查询元素
	 * @param url
	 * @return
	 */
	public boolean get(String url) {
		int h1 = hash1(url);
		int h2 = hash2(url);
		int h3 = hash3(url);

		int index, offset;
		index = h1 / 8;
		offset = h1 % 8;
		if((bits[index] & (1 << offset)) == 0) {
			return false; //表示不存在
		}

		index = h2 / 8;
		offset = h2 % 8;
		if((bits[index] & (1 << offset)) == 0) {
			return false; //表示不存在
		}

		index = h3 / 8;
		offset = h3 % 8;
		if((bits[index] & (1 << offset)) == 0) {
			return false; //表示不存在
		}
		return true;
	}
	/**
	 * 除留余数法
	 * 
	 * @param url
	 * @return
	 */
	private int hash1(String url) {
		return Math.abs(url.hashCode() % this.bitSize);
	}

	/**
	 * md5结果
	 * @param url
	 * @return
	 */
	private int hash2(String url) {
		byte[] digest = DigestUtils.md5(url);
		/*
		 * 每4个字节构成一个32位的整数，
		 * 将四个32位整数相加得到instr的hash值 （可能溢出）
		 */
		int hash = 0;
		for (int i = 0; i < 4; i++) {
			hash += ((long) (digest[i * 4 + 3] & 0xFF) << 24) | ((long) (digest[i * 4 + 2] & 0xFF) << 16)
					| ((long) (digest[i * 4 + 1] & 0xFF) << 8) | ((long) (digest[i * 4 + 0] & 0xFF));
		}//end for
		return Math.abs(hash) % this.bitSize;
	}
	
	/**
	 * sha结果
	 * @param url
	 * @return
	 */
	private int hash3(String url) {
		byte[] digest = DigestUtils.sha1(url);
		int hash = 0;
		for (int i = 0; i < 4; i++) {
			hash += ((long) (digest[i * 4 + 3] & 0xFF) << 24) | ((long) (digest[i * 4 + 2] & 0xFF) << 16)
					| ((long) (digest[i * 4 + 1] & 0xFF) << 8) | ((long) (digest[i * 4 + 0] & 0xFF));
		}//end for
		return Math.abs(hash) % this.bitSize;
	}

	public static void main(String[] args) {
		BloemFilter bf = new BloemFilter(121);
		
		//添加黑名单
		bf.put("http://www.baidu.com");
		bf.put("http://www.sina.com");
		bf.put("http://www.csdn.com");
		bf.put("http://www.google.com");
		bf.put("http://www.wangyi.com");
		
		//过滤url
		System.out.println(bf.get("http://www.sina.com"));
		System.out.println(bf.get("http://www.csdn.com"));
		System.out.println(bf.get("http://www.baid.com"));
	}

}
