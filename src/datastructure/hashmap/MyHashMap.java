package datastructure.hashmap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 链式hash表的实现
 * @author LCX
 *
 */
public class MyHashMap<K,V> {
	/**
	 * 打包键值对类型
	 * @author LCX
	 *
	 */
	static class Entry<K,V>{
		K key;
		V value;
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	//素数表
	private static int[] primeTable = {3, 7, 23, 47, 97, 251, 443, 911, 1471, 42773};
	//hash表的定义
	private ArrayList<LinkedList<Entry<K, V>>> bucketsList ;
	
	//加载因子 已占用桶的个数 / 桶的总数量  <= loadFactor
	private double loadFactor = 0.75;
	
	//记录已经使用的桶的个数
	private int usedBuckets = 0;
	
	//素数表的索引
	private int primeIndex = 0;
	
	public MyHashMap() {
		this(0.75);
	}
	
	public MyHashMap(double loadFactor) {
		//默认给的是素数表的第一个元素，初始化hash表的大小为3
		this.bucketsList = new ArrayList<LinkedList<Entry<K,V>>>(primeTable[primeIndex]);
		for (int i = 0; i < primeTable[primeIndex]; i++) {
			this.bucketsList.add(new LinkedList<Entry<K,V>>());
		}
		this.loadFactor = loadFactor;
	}
	
	/**
	 * 增加一个key、value
	 * 不允许插入key=null的元素
	 * 不允许key重复
	 * key存在，那么覆盖value
	 * key不存在，增加一对新的key、value
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {
		double lf = this.usedBuckets * 1.0 / this.bucketsList.size();
		System.out.println("lf:"+lf+" "+this.bucketsList.size());
		if (lf > this.loadFactor) {
			resize();
		}
		//计算数组下标值
		int index = key.hashCode() % this.bucketsList.size();
		LinkedList<Entry<K, V>> list = this.bucketsList.get(index);
		if (list.isEmpty()) {
			//index号位置桶是空的
			list.add(new Entry<K, V>(key,value));
			this.usedBuckets ++;
		} else {
			for (Entry<K, V> entry : list) {
				if (entry.key.equals(key)) {
					entry.value = value;
					return;
				}//end if
			}//end for
			list.add(new Entry<K, V>(key, value));//key不存在，增加一对可以，value
		}//end if...else
	}//end put()
	
	
	/**
	 * hash表的扩容操作
	 */
	public void resize() {
		//用oldBucketList指向原来的hash表
		ArrayList<LinkedList<Entry<K, V>>> oldBucketList = bucketsList;
		this.usedBuckets = 0;
		//hash表已经是最后一个大小了
		if (this.primeIndex == primeTable.length) {
			return; 
		}
		//hash表扩容，开辟下一个素数指定的hash表大小
		this.bucketsList = new ArrayList<LinkedList<Entry<K,V>>>(++primeTable[primeIndex]);
		for (int i = 0; i < primeTable[primeIndex]; i++) {
			this.bucketsList.add(new LinkedList<Entry<K,V>>());
		}
		
		//遍历原来哈希表中的所有桶中的链表数据，插入到新的hash表中
		for (LinkedList<Entry<K, V>> linkedList : oldBucketList) {
			//当前桶中有元素
			if (linkedList.size() > 0) {
				for (Entry<K, V> entry : linkedList) {
					//计算数组下标值
					int index = entry.key.hashCode() % this.bucketsList.size();
					LinkedList<Entry<K, V>> list = this.bucketsList.get(index);
					if (list.isEmpty()) {
						//index号位置桶是空的
						this.usedBuckets ++;
					}
					list.add(new Entry<K, V>(entry.key,entry.value));
				}//end for
			}//end if
		}//end for
		
		
	}

	/**
	 * 哈希表的删除操作
	 * key不存在，返回null
	 * key存在，返回value值，并做删除value的操作
	 * @param key
	 * @return
	 */
	public V remove(K key) {
		//先计算key的散列码
		int index = key.hashCode() % this.bucketsList.size();
		LinkedList<Entry<K, V>> list = this.bucketsList.get(index);
		if (list.isEmpty()) {
			return null; // 不存在，返回null
		} 
		
		Iterator<Entry<K, V>> iterator = list.iterator();
		while (iterator.hasNext()) {
			Entry<K, V> entry = iterator.next();
			if (entry.key.equals(key)) {
				V val = entry.value;//存在，返回值
				iterator.remove();//用迭代器直接删除元素
				return val;// 不存在，返回null
			}//end if
		}//end while
		return null;
	}//end remove()
	
	/**
	 * hash表的查询操作
	 * @param key
	 * @return
	 */
	public V get(K key) {
		// 先计算key的散列码
		int index = key.hashCode() % this.bucketsList.size();
		LinkedList<Entry<K, V>> list = this.bucketsList.get(index);
		if (list.isEmpty()) {
			return null; // 不存在，返回null
		}
		Iterator<Entry<K, V>> iterator = list.iterator();
		while (iterator.hasNext()) {
			Entry<K, V> entry = iterator.next();
			if (entry.key.equals(key)) {
				return entry.value;// 不存在，返回null
			} // end if
		} // end while
		return null;
	}
	
	
	public static void main(String[] args) {
		MyHashMap<Integer, String> map = new MyHashMap<Integer, String>();
		map.put(1, "lv");
		map.put(2, "chang");
		map.put(3, "chang");
		System.out.println(map.get(1));
		System.out.println(map.get(2));
		System.out.println(map.get(4));
		map.put(1, "hah");
		System.out.println(map.get(1));
		map.remove(2);
		System.out.println(map.get(2));
		
	}//end main()
}
