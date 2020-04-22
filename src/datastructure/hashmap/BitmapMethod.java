package datastructure.hashmap;

import java.util.ArrayList;
import java.util.Random;

/**
 * 大数据查重复-位图法
 * 位图法只能查重，不能统计次数，区别于hash表大的特点，位图法占用内存空间小很多
 * 使用位图法一定要知道数据序列中的最大值是多少*
 * 位图法是将原始值映射到某个位，使用一个bit来表示某个位置的数是否存在
 * 需要申明的一个byte类型的数组 （十亿个数）：byte[] arr = new byte[10亿/8+1]
 * @author LCX
 *
 */
public class BitmapMethod {
	public static void main(String[] args) {
		/*
		 *list里面有10000万个数据
		 *输出代码求出第一个重复的数据或者哪些数据重复了，或者第k个重复的数据 
		 */
		Random rd = new Random();
		ArrayList<Integer> list = new ArrayList<Integer>(100);
		
		for (int i = 0; i < 100; i++) {
			list.add(rd.nextInt(60));
		}//end for
		
		
		
		/**
		 * 用位图法 ，找出第一个重复的数字，或者是所有重复的数字
		 * 缺点：
		 * 1.不知道数据里面的最大值，无法定义位图数组的大小
		 * 2. 1 2 3 1000000 这样的数组，容易浪费空间
		 * 对于数据数量和最大数接近的情况比较好
		 */
		int max = 0;
		for (Integer val : list) {
			if (val>max) {
				max = val;
			}
		}//end for
		
		//定义位图数组
		byte[] arr = new byte[max/8+1];
		for (Integer val : list) {
			//求出val在位图的哪个位置
			int index = val/8;
			//求出val在index号位置的哪一个位上
			int offset = val % 8;
			//找到offset位置的bit，判断是 0 还是 1
			int state = arr[index] & (1 << offset);
			//表示相应的位是0，该数字没有出现过
			if (state == 0) {
				 arr[index] = (byte) (arr[index] | (1<<offset));
			} else {
				System.out.println("第一个重复的元素是："+val);
				return;
			}//end if...else
		}//end for
	}//end main()
	
	
	
}
