package algorithm.kruskal;

import java.util.Arrays;

/**
 * 克鲁斯卡尔算法
 */
public class KruskalAlgorithm {
    private int edgeNum; //边的个数
    private char[] vertexs; //顶点数组
    private int[][] matrix; //邻接矩阵
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A','B','C','D','E','F','G'};
        int[][] matrix = {
                {0,12,INF,INF,INF,16,14},
                {12,0,10,INF,INF,7,INF},
                {INF,10,0,3,5,6,INF},
                {INF,INF,3,0,4,INF,INF},
                {INF,INF,5,4,0,2,8},
                {16,7,6,INF,2,0,9},
                {14,INF,INF,INF,8,9,0},
        };
        //创建对象
        KruskalAlgorithm kruskal = new KruskalAlgorithm(vertexs,matrix);
        //输出
        kruskal.print();

        System.out.println("排序前：");
        EData[] edges = kruskal.getEdges();
        System.out.println(Arrays.toString(edges));
        System.out.println("排序后：");
        kruskal.sortEdges(edges);
        System.out.println(Arrays.toString(edges));

        kruskal.kruscal();
    } //end main()

    public KruskalAlgorithm(char[] vertexs, int[][] matrix) {
        this.vertexs = new char[vertexs.length];
        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        } //end for

        //初始化边
        this.matrix = new int[vertexs.length][vertexs.length];
        for (int i = 0; i < matrix.length; i++) {
           this.matrix[i] = Arrays.copyOf(matrix[i],matrix[i].length);
        } //end for

        //统计边
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                } //end if
            } //end for
        } //end for
    } //end KruskalAlgorithm()

    /**
     * 克鲁斯卡尔算法实现核心部分
     */
    public void kruscal() {
        int index = 0; //表示最后结果数组的索引
        int[] ends = new int[edgeNum]; //用于保存"已有最小生成树"中的每个顶点在最小生成树中的终点
        //创建结果数组，保存最后的最小生成树
        EData[] res = new EData[edgeNum];

        //获取图中所有边的集合，一共 12 条边
        EData[] edges = getEdges();
        System.out.println("图的边的集合："+Arrays.toString(edges)+"共"+edges.length);

        //按照边的权值大小进行排序（从小到大）
        sortEdges(edges);

        //遍历 edges 数组，将边添加到最小生成树中，判断是否准备加入的边形成了回路，如果没有，加入 res 否则不能加入
        for (int i = 0; i < edgeNum; i++) {
            //获取到第 i 条边的第一个顶点（起点）
            int p1 = getPosition(edges[i].start);
            //获取到第 i 条边的第二个顶点
            int p2 = getPosition(edges[i].end);

            //求 p1 这个顶点在已有最小生成树中的终点
            int m = getEnd(ends,p1);
            //求 p2 这个顶点在已有最小生成树中的终点
            int n = getEnd(ends,p2);

            //是否构成回路
            if (m != n) {
                //没有构成回路
                ends[m] = n;
                res[index++] = edges[i];
            }
        } //end for
        //统计并打印最小生成树-打印 res
        System.out.println("最小生成树为："+Arrays.toString(res));
    }

    public void print() {
        System.out.println("邻接矩阵为：");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    /**
     * 对边进行排序处理，冒泡排序
     * @param edges
     */
    private void sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - i - 1; j++) {
                if (edges[j].weight > edges[j+1].weight) {
                    EData tmp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = tmp;
                } //end if
            } //end for
        } //end for
    } //end sortEdges()

    /**
     *
     * @param ch
     * @return
     */
    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    } //end getPosition()

    /**
     *
     * @return
     */
    private EData[] getEdges() {
       int index = 0;
       EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        } //end for
        return edges;
    }

    /**
     * 获取下标为 i 的顶点的终点，用于判断后面两个顶点的终点是否相同
     * @param ends
     * @param i
     * @return
     */
    private int getEnd(int[] ends,int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    } //end getEnd()


    /**
     * 对象实例表示一条边
     */
    class EData {
        char start; //边的一个点
        char end; //边的另外一个点
        int weight; //边的权值

        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "EData{" +
                    "<" + start +
                    "," + end +
                    ">," + weight +
                    '}';
        }
    } //end EData


}
