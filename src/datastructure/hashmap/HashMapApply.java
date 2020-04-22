package datastructure.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * 优势：查询   劣势：占用内存比较大
 * hash表的应用：大数据查重/去重（时间复杂度O(1)）HashSet
 *       统计重复次数 HashMap 
 * @author LCX
 *
 */
public class HashMapApply {
	public static void main(String[] args) {
		/*
		 *list里面有10000万个数据
		 *输出代码求出第一个重复的数据或者哪些数据重复了，或者第k个重复的数据 
		 */
		Random rd = new Random();
		ArrayList<Integer> list = new ArrayList<Integer>(100);
		
		for (int i = 0; i < 100; i++) {
			list.add(rd.nextInt(60));
		}
		
		/*
		 * 解决方法：
		 * 遍历原始数据，在hash表中进行查询，如果不存在，表示该数据第一次出现
		 * 如果该数据在hash表中找到了，说明该数据重复了
		 */
//		HashSet<Integer> set = new HashSet<Integer>();
//		for (Integer val : list) {
//			if (set.contains(val)) {
//				System.out.println(val+"：是第一个重复的数字！");
//				return;
//			} else {
//				set.add(val);
//			}//end if...else
//		}//end for
		
		
		
		/*
		 *list里面有10万个整数，有的数字是重复的，把重复的数字过滤掉只剩下一个==》去重操作
		 *利用hashset本身不允许重复元素的特征 
		 */
//		HashSet<Integer> set = new HashSet<Integer>();
//		set.clear();
//		for (Integer integer : list) {
//			set.add(integer);
//		}
//		System.out.println(set.size());
		
		
		/*
		 *list里面有10万个整数，统计重复数字，以及它们出现的次数
		 */
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (Integer key : list) {
			Integer cnt = map.get(key);
			if (cnt == null) {
				map.put(key, 1);
				
			}else {
				map.put(key, cnt+1);
			}
		}//end for
		
		//获取迭代器
		Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Integer> entry = it.next();
			//entry.getValue() > 1 表示数字重复了
			if (entry.getValue() > 1) {
				System.out.println("key:"+entry.getKey() + "value:"+entry.getValue());
			}//end if
		}//end while
		
		
	}//end main()
}









