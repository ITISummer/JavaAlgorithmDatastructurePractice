package practice.lanqiao.javaB2014;

import java.util.Scanner;

/*
标题：地宫取宝
X国王有一个地宫宝库。是nxn个格子的矩阵。每个格子放一件宝贝。每个宝贝贴着价值标签
地宫的入口在左上角，出口在右下角。
小明被带到地宫的入口，国王要求他只能向右或向下行走
走过某个格子时，如果那个格子中的宝贝价值比小明手中任意宝贝价值都大，小明就可以拿起它（当然，也可以不拿）。
当小明走到出口时，如果他手中的宝贝恰好是k件，则这些宝贝就可以送给小明。
请你帮小明算一算，在给定的局面下，他有多少种不同的行动方案能获得这k件宝贝。
【数据格式】
输入一行3个整数，用空格分开：n m k（1<=n,m<=50,1<=k<=12）
接下来有n行数据，每行有m个整数Ci（0<=Ci<=12）代表这个格子上的宝物的价值
要求输出一个整数，表示正好取k个宝贝的行动方案数。该数字可能很大，输出它对10000007取模的结果。
例如，输入：
2 2 2
1 2
2 1
程序应该输出：
2
再例如，输入：
2 3 2
1 2 3
2 1 5
程序应该输出：
14
 */
public class _09_地宫取宝 {
    private static final long MOD = 10000007;
    //    public static long ans = 0;
    private static int n;
    private static int m;
    private static int k;
    private static long[][][][] cache = new long[51][51][14][14];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        int[][] pla = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pla[i][j] = in.nextInt();
            }
        }
        in.close();
        //initialize the array cache
        memset(cache, -1);
        long ans = dfs2(pla, 0, 0, -1, 0);
        System.out.println(ans);
    }


    /**
     * @param pla
     * @param x
     * @param y
     * @param max
     * @param cnt
     */
    private static long dfs2(int[][] pla, int x, int y, int max, int cnt) {
        if (cache[x][y][max + 1][cnt] != -1)
            return cache[x][y][max + 1][cnt];
        long ans = 0;
        if (x == n || y == m || cnt > k)
            return 0;
        int cur = pla[x][y];
        if (x == n - 1 && y == m - 1) {
            if (cnt == k || (cnt == k - 1 && cur > max)) {
                ans++;
                if (ans > MOD)
                    ans %= MOD;
            }
            return ans;
        }
        //take current item
        if (cur > max) {
            ans += dfs2(pla, x, y + 1, cur, cnt + 1);
            ans += dfs2(pla, x + 1, y, cur, cnt + 1);
        }
        //do not take current item
        ans += dfs2(pla, x, y + 1, max, cnt);
        ans += dfs2(pla, x + 1, y, max, cnt);

        cache[x][y][max + 1][cnt] = ans % MOD;
        return cache[x][y][max + 1][cnt];
    }

    /**
     * fill the 4 dimension with -1
     *
     * @param cache
     */
    private static void memset(long[][][][] cache, int val) {
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                for (int m = 0; m < cache[i][j].length; m++) {
                    for (int n = 0; n < cache[i][j][m].length; n++) {
                        cache[i][j][m][n] = val;
                    }
                }
            }
        }
    }
}
//    /**
//     * @param x   x-coordinate
//     * @param y   y-coordinate
//     * @param max current maximum value in hands
//     * @param cnt current count in hands
//     */
//    private static void dfs(int[][] pla, int x, int y, int max, int cnt) {
//        if (x == n || y == m || cnt > k)
//            return;
//        int cur = pla[x][y];
//        if (x == n - 1 && y == m - 1) {
//            if (cnt == k || (cnt == k - 1 && cur > max)) {
//                ans++;
//                if (ans > MOD)
//                    ans %= MOD;
//            }
//        }
//        //take current item
//        if (cur > max) {
//            dfs(pla, x, y + 1, cur, cnt + 1);
//            dfs(pla, x + 1, y, cur, cnt + 1);
//        }
//        //do not take current item
//        dfs(pla, x, y + 1, max, cnt);
//        dfs(pla, x + 1, y, max, cnt);

