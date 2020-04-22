package datastructure.linearlist;

import java.util.Arrays;
import java.util.Random;


/**
 * 线性表顺序存储方式-数组
 * 
 * @author LCX
 *
 */
public class LinearList {

	public static int idx = 0;

	public static void main(String[] args) {
//-----------------------数组的增加和删除--------------------
		// 定义一个20个元素的数组
//		int[] arr = new int[20];
//		// 以系统时间作为随机数种子
//		Random rd = new Random();
//		// 随机生成一个数组
//		for (int i = 0; i < 10; i++) {
//			arr[idx++] = rd.nextInt(100);
//		} // end for
//		printArr(arr, idx);

		// 往数组第5个位置插入一个元素
//		LinearList.addArrElement(arr, idx, 5, 50);
//		printArr(arr, idx);

		// 删除数组第2个元素
//		LinearList.deleteArrElement(arr, idx, 2);
//		printArr(arr, idx);

//-----------------------数组的普通查找--------------------
		// 创建一个指定时间种子的数组
//		Random rd = new Random(50);
//
//		int[] arr = new int[20];
//
//		for (int i = 0; i < 10; i++) {
//			arr[i] = rd.nextInt(100);
//		}
//		printArr(arr, 10);
//		System.out.println();
//		System.out.println(LinearList.findArrElement(arr, 88));
//-----------------------数组的二分查找--------------------		
		// 创建一个指定时间种子的数组
		Random rd = new Random(50);

		int[] arr = new int[20];

		for (int i = 0; i < 10; i++) {
			arr[i] = rd.nextInt(100);
		}
		printArr(arr, 10);
		System.out.println();
		System.out.println(LinearList.binarySearch(arr, 88));
	}// end main()

	/**
	 * 打印数组元素
	 * 
	 * @param idx
	 */
	public static void printArr(int[] arr, int idx) {
		// 打印数组
		System.out.println();
		for (int i = 0; i < idx; i++) {
			System.out.print(arr[i] + " ");
		}
	}// end printArr()

	/**
	 * 删除数组中某一位置元素
	 * 
	 * @param arr
	 * @param idx
	 * @param position
	 */
	public static void deleteArrElement(int[] arr, int idx, int position) {
		// 删除第3个位置的数组元素 arr[2]
		for (int i = position; i < idx; i++) {
			arr[i] = arr[i + 1];
		}
		LinearList.idx--;

	}// end deleteArrElement()

	/**
	 * 给数组中添加一个元素
	 * 
	 * @param arr
	 * @param idx
	 * @param position
	 * @param element
	 */
	public static void addArrElement(int[] arr, int idx, int position, int element) {
		for (int i = idx; i >= position; i--) {
			arr[i] = arr[i - 1];
		}
		LinearList.idx++;
		arr[position - 1] = element;
	}// end addArrElement()

	/**
	 * 在数组中查找指定元素，返回数组中元素位置
	 * 
	 * @param element
	 * @return
	 */
	public static int findArrElement(int[] arr, int element) {
		int flag = -1;
		for (int i = 0; i < 10; i++) {
			if (arr[i] == element) {
				flag = i;
				break;
			}
		} // end for
		return flag;

	}// end findArrElement()

	/**
	 * 
	 * 二分法查找
	 * 
	 * @param arr
	 * @param element
	 */
	public static int binarySearch(int[] arr, int element) {
		int low = 0;
		int high = arr.length - 1;
		int mid = (low + high) / 2;
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		while (low <= high) {
			mid = (low + high) / 2;
			if (element == arr[mid]) {
				return mid;
			} else if (element > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		} // end while()
		return -1;
	}// end binarySearch()
}
