package datastructure.sparsearray;

/**
 * 数组转稀疏数组
 */
public class SparstArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组，11*11
        //0表示空 1 表示黑棋 2 表示白棋
        int originArr[][] = initlizeArr(11,11);

        //输出原始的二维数组
        System.out.println("原始的二维数组~");
        printArr(originArr);

        //将二维数组转稀疏数组
        //先遍历二维数组，得到非0数的个数
        int[][] sparseArr = toSparseArr(originArr);

        //输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组为~~");
        printArr(sparseArr);

        //由稀疏数组恢复成原始数组
       int[][] newArr =  toOriginArr(sparseArr);
       //输出转换成功后的数组
        printArr(newArr);
    } //end main()

    /**
     * 将稀疏数组转换成原始数组
     * @param sparseArr
     * @return
     */
    private static int[][] toOriginArr(int[][] sparseArr) {
        //先创建一个和原始数组一样大小的数组
        int[][] originArr = new int[sparseArr[0][0]][sparseArr[0][1]];

        //for循环给赋值
        for (int i = 1; i < sparseArr.length;i ++) {
            originArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        } //end for
        return originArr;
    } //end toOriginArr()

    /**
     * 将原始数组转为稀疏数组
     * @param originArr
     * @return
     */
    private static int[][] toSparseArr(int[][] originArr) {
        int sum = 0;//用于统计非0个数
        for (int[] row : originArr) {
            for (int col : row) {
                if (col != 0) {
                    sum++;
                } //end if
            } //end for
        } //end for

        //创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        //原始数组的行数
        sparseArr[0][0] = originArr.length;
        //原始数组的列数
        sparseArr[0][1] = originArr[0].length;
        //原始数组的非0个数
        sparseArr[0][2] = sum;

        //给稀疏数组中存储原始数组中非零数位置
        int count = 0; //作为记录下标
        for (int i = 0; i < originArr.length; i++) {
            for (int j = 0; j < originArr[i].length; j++) {
                if (originArr[i][j] != 0) {
                    sparseArr[++count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = originArr[i][j];
                } //end if
            } //end for
        } //end for
        return sparseArr;
    } //end toSpqrseArr()

    /**
     * 输出二维数组
     * @param originArr
     */
    private static void printArr(int[][] originArr) {
        for (int[] row : originArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            } //end for
            System.out.println();
        } //end for
    } //end printArr()


    /**
     * 返回初始化的数组
     * @param row
     * @param col
     * @return
     */
    public static int[][] initlizeArr(int row, int col) {
        //创建一个原始的二维数组，11*11
        //0表示空 1 表示黑棋 2 表示白棋
        int originArr[][] = new int[row][col];
        //初始化
        originArr[1][2] = 1;
        originArr[2][3] = 2;
        return originArr;
    } //end initlize()


}
