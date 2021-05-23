package practice.lanqiao.javaB2018;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 
 */
public class _07_全球变暖 {
	//四个方向矩阵
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	//数据规模
	private static int N;
	//地图数据
	private static char[][] g;
//	标记每个格子是否被访问
	private static int[][] mark;
	//答案
	private static int ans;
	
	/**
	 * 自定义节点
	 * @author LCX
	 *
	 */
	private static class Point {
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();//读取换行符
		//初始化地图数据和标记数组
		g = new char[N][N];
		mark = new int[N][N];
		//读取地图数据
		for (int i = 0; i < N; i++) {
			g[i] = sc.nextLine().toCharArray();
		}
		//双重循环检测地图上各个格子，以未被访问的 # 为起点，做 BFS
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (g[i][j] == '#' && mark[i][j] == 0) {
					bfs(i,j);
				}
			}
		} //for
		System.out.println(ans);
	}

	/**
	 * bfs()
	 * @param i
	 * @param j
	 */
	public static void bfs(int x, int y) {
		mark[x][y] = 1;
		int cntOfBlock = 0; //记录陆地的数量
		int cntOfSwed = 0; //记录将被淹没的陆地的数量
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x,y));
		while (!queue.isEmpty()) {
			Point first = queue.poll(); //弹出头部
			cntOfBlock ++;
			boolean swed = false;
			//遍历 4 个方向
			for (int d = 0; d < 4; d++) {
				int nx = first.x + dx[d];
				int ny = first.y + dy[d];
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (g[nx][ny] == '.') {
						swed = true; //周边有一个 . 这块陆地就会被淹没，避免重复计数
					}
					if (g[nx][ny] == '#' && mark[nx][ny] == 0) {
						queue.add(new Point(nx,ny));
						mark[nx][ny] = 1;
					}
				}
			} //for
			if (swed) cntOfSwed++;
		}
		if (cntOfBlock == cntOfSwed) ans ++;
	} //bfs()
}
