package datastructure.recursion;

/**
 * 递归解决迷宫回溯问题
 */
public class MiGong {
    public static void main(String[] args) {
        //定义8行7列的地图，默认初始化为0
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下置为1
        for (int i = 0; i < map[i].length; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        } //end for
        //左右置为1
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        } //end for

        //打印二维数组
        System.out.println("初始化的地图~");
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        } //end for

        //使用递归回溯给小球找路
        System.out.println("小球走过并标识过的地图~");
        setway(map, 1, 1);
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        } //end for
    }//end main()

    //使用递归回溯来给小球找路
    // 说明
    // 1.map表示地图
    // 2.i,j表示从地图的哪个位置开始出发(1,1)
    //3·如果小球能到map[6][5]位置，则说明通路找到
    // 4.约定：当map[i][j]为0表示该点没有走过当为1表示墙；2表示通路可以走；3表示该点已经走过，但是走不通
    // 5·在走迷宫时，需要确定一个策略（方法）下->右->上-》左，如果该点走不通，再回溯
    public static boolean setway(int map[][], int i, int j) {
        if (map[6][5] == 2) { //通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) { //当前点还没走过
                //按照策略 下->右->上-》左
                map[i][j] = 2;//假定该点可以走通
                if (setway(map, i + 1, j) == true) { //向下走
                    return true;
                } else if (setway(map, i, j + 1) == true) { //向右走
                    return true;
                } else if (setway(map, i - 1, j) == true) { //向上走
                    return true;
                } else if (setway(map, i, j - 1) == true) { //向左走
                    return true;
                } else {
                    map[i][j] = 3; //该点已经走过
                    return false;
                } //end if...else
            } else { // 如果map[i][j] != 0,可能是1，2，3
                return false;
            } //end if...else
        } //end setway()

    }
}
