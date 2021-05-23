package practice.lanqiao.javaB2018;

/*
 * 方格计数
 */
public class _02_方格计数 {
	public static void main(String[] args) {
		int r = 0;
		for (int i = 1; i <= 1000; i++) {
			for (int j = 1; j <= 1000; j++) {
				if (i*i + j*j <= 1000*1000) {
					r ++;
				}
			}
		}
		System.out.println(r*4);
	}
}
