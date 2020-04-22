package algorithm.horsechessboard;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 马踏棋盘问题（骑士周游）
 */
public class HorseChessBoard {
    private static int X; //棋盘的列数
    private static int Y; //棋盘的行数
    private static boolean[] visited; //标记是否被访问过
    private static boolean finished; //如果为 true 表示成功




    public static void main(String[] args) {
        System.out.println("骑士周游算法开始。。。");
        X = 8;
        Y = 8;
        int row = 1;
        int column = 1;

        int[][] chessboard = new int[X][Y];
        visited = new boolean[X * Y]; //初始值默认都是 false

        long start = System.currentTimeMillis();
        traversalChessBoard(chessboard,row - 1, column - 1,1);
        long end = System.currentTimeMillis();
        System.out.println("共耗时" + (end - start) + "毫秒");
        //输出棋盘的最后情况
        for (int[] rows : chessboard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            } //end for
            System.out.println();
        } //end for


    }


    /**
     *
     * @param chessboard 棋盘
     * @param row 行， 默认从 0 开始
     * @param column 列， 默认从 0 开始
     * @param step 走到第几步，初始位置就是第 1 步
     */
    public static void traversalChessBoard(int[][] chessboard, int row, int column, int step) {
        chessboard[row][column] = step;
        visited[row * X + column] = true; //标记该位置为已经访问
        //获取当前位置可以走的下一个位置的集合
        ArrayList<Point> ps = next(new Point(column, row));
        //对 ps 进行排序，排序的规则就是对 ps 的所有的 point 对象的下一步的位置的数目，进行非递减排序
        sort(ps);
        //遍历 ps
        while (!ps.isEmpty()) {
            Point p = ps.remove(0); //取出下一个可以走的位置
            //判断该点是否已经访问过
            if (!visited[p.y * X + p.x]) {
                traversalChessBoard(chessboard,p.y,p.x, step + 1);
            }
        } //end while
        // 判断马儿是否完成了任务，使用 step 和应该走的步数比较
        if (step < X * Y && !finished) {
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            finished = true;
        }

    } //end traversalChessBoard()
    /**
     *
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> next(Point curPoint) {
        ArrayList<Point> ps = new ArrayList<>();
        Point p1 = new Point();
        //判断马儿是否可以走 西北偏下 位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿是否可以走 西北偏上 位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿是否可以走 东北偏上 位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿是否可以走 东北偏下 位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿是否可以走 东南偏上 位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿是否可以走 东南偏下 位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿是否可以走 西南偏下 位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿是否可以走 西南偏上 位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    } //end next()

    /**
     *
     * @param ps
     */
    public static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                //获取 o1 下一步的所有位置个数
                int count1 = next(o1).size();
                //获取 o2 下一步的所有位置个数
                int count2 = next(o2).size();
                if (count1 < count2) {
                    return -1;
                } else if (count1 == count2) {
                    return 0;
                } else {
                    return 1;
                }
            } //end compare()
        });
    } //end sort()
}
