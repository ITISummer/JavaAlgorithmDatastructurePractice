package practice.lanqiao.javaB2018;
/*
 * 测试次数
 */
public class _04_测试次数 {
	static final int N = 1000;
	// 记录手机数为 1,2,3 时
	static int[] f1 = new int[N + 1];
	static int[] f2 = new int[N + 1];
	static int[] f3 = new int[N + 1];
	
	public static void main(String[] args) {
		// 1 部手机的情况
		for (int i = 1; i <= N; i++) {
			f1[i] = i;
		}
		// 2 部手机的情况
		for (int i = 1; i <= N; i++) {
			int ans = Integer.MAX_VALUE;
			// 尝试 1~i 若干种方案，最终记录所有方案中次数最小的
			// 在 j 层仍第一个手机
			for (int j = 1; j <= i; j++) {
				// 1 好的 2 坏了
				int _max = 1 + Math.max(f2[i-j], f1[j-1]);
				ans = Math.min(ans, _max);
			}
			f2[i] = ans;
		}
		// 3 部手机的情况
		for (int i = 1; i <= N; i++) {
			int ans = Integer.MAX_VALUE;
			// 尝试 1~i 若干种方案，最终记录所有方案中次数最小的
			for (int j = 1; j <= i; j++) {
				int _max = 1 + Math.max(f3[i-j], f2[j-1]);
				ans = Math.min(ans, _max);
			}
			f3[i] = ans;
		}
		System.out.println(f3[N]);
	}
}
