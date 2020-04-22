package algorithm.dijkstra;

import java.util.Arrays;

/**
 * 迪杰斯特拉算法-求最短路径
 * 底层基于 BFS
 */
public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertex = {'A','B','C','D','E','F','G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535; //表示不可以连接
        matrix[0] = new int[]{N,5,7,N,N,N,2};
        matrix[1] = new int[]{5,N,N,9,N,N,3};
        matrix[2] = new int[]{7,N,N,N,8,N,N};
        matrix[3] = new int[]{N,9,N,N,N,4,N};
        matrix[4] = new int[]{N,N,8,N,N,5,4};
        matrix[5] = new int[]{N,N,N,4,5,N,6};
        matrix[6] = new int[]{2,3,N,N,4,6,N};
        //创建 Graph 对象
        Graph graph = new Graph(vertex,matrix);
        graph.showGraph(matrix);

        graph.dsj(6);
        graph.showDijkstra();

    }

    /**
     * 图
     */
    static class Graph {
        private char[] vertex;//顶点数组
        private int[][] matrix;//邻接矩阵
        private VisitedVertex visitedVertex; //已经访问的顶点集合
        public Graph(char[] vertex, int[][] matrix) {
            this.vertex = vertex;
            this.matrix = matrix;
        }

        /**
         *
         */
        public void showDijkstra() {
            visitedVertex.show();
        }

        /**
         * 显示图
         * @param matrix
         */
        public void showGraph(int[][] matrix) {
            for (int[] link : matrix) {
                System.out.println(Arrays.toString(link));
            }
        } //end showGraph()

        /**
         * 迪杰斯特拉算法实现
         * @param index 表示出发顶点对应的下标
         */
        public void dsj(int index) {
            visitedVertex = new VisitedVertex(vertex.length,index);
            update(index); //更新 index 顶点到周围顶点的距离和前驱节点

            for (int i = 0; i < vertex.length; i++) {
                //选择并返回新的访问节点
                index = visitedVertex.updateArr();
                //更新 index 节点到周围顶点的距离和前驱节点
                update(index);
            }
        }

        /**
         * 更新 index 下标顶点到周围顶点的距离和周围顶点的前驱顶点
         * @param index
         */
        private void update(int index) {
            int len = 0;
            //遍历 matrix 的 index 行
            for (int i = 0; i < matrix[index].length; i++) {
                //len 表示出发顶点到 index 顶点的距离 + 从 index 顶点到 i 顶点的距离的和
                len = visitedVertex.getDis(index) + matrix[index][i];
                if (! visitedVertex.isVisited(i) && len < visitedVertex.getDis(i)) {
                    visitedVertex.updatePre(i,index);
                    visitedVertex.updateDis(i,len);
                }
            } //end for

        } //end update()

    } //end Graph



    /**
     * 已访问过顶点集合
     */
    static class VisitedVertex {
        //记录各个顶点是否被访问过，1表示访问过，0表示未访问，会动态更新
        public int[] already_arr;
        //每个下标对应的值为前一个顶点下标
        public int[] pre_visited;
        //记录出发顶点到所有顶点的距离
        public int[] dis;


        /**
         *
         * @param length 表示顶点个数
         * @param index 表示出发顶点
         */
        public VisitedVertex(int length, int index) {
            this.already_arr = new int[length];
            this.pre_visited = new int[length];
            this.dis = new int[length];
            //初始化 dis 数组
            Arrays.fill(dis,65535);
            //设置出发顶点被访问过
            this.already_arr[index] = 1;
            //设置出发顶点的访问距离为 0
            this.dis[index] = 0;
        }

        /**
         * 判断 index 顶点是否被访问过
         * @param index
         * @return 访问过返回 true
         */
        public boolean isVisited(int index) {
            return this.already_arr[index] == 1;
        } //end isVisited()

        /**
         * 功能：更新出发顶点到 index 顶点的距离
         * @param index
         * @param len
         */
        public void updateDis(int index, int len) {
            dis[index] = len;
        } //end updateDis()

        /**
         * 更新 pre节点的前驱节点为 index 节点
         * @param pre
         * @param index
         */
        public void updatePre(int pre, int index) {
            pre_visited[pre] = index;
        } //end updatePre()

        /**
         * 返回出发顶点到 index 顶点的距离
         * @param index
         * @return
         */
        public int getDis(int index) {
            return dis[index];
        } //end getDis()

        /**
         * 继续选择并返回新的访问节点
         * @return
         */
        public int updateArr() {
            int min = 65535;
            int index = 0;
            for (int i = 0; i < already_arr.length; i++) {
                if (already_arr[i] == 0 && dis[i] < min) {
                    min = dis[i];
                    index = i;
                }
            }
            //更新 index 节点被访问过
            already_arr[index] = 1;
            return index;
        } //end updateArr()

        /**
         * 显示最后的结果
         * 即将三个数组的结果输出
         */
        public void show() {
            System.out.println("=================");
            for (int i : already_arr) {
                System.out.print(i+" ");
            }
            System.out.println();
            for (int i : pre_visited) {
                System.out.print(i+" ");
            }
            System.out.println();
            for (int i : dis) {
                System.out.print(i+" ");
            }
            System.out.println();
            char[] vertex = {'A','B','C','D','E','F','G'};
            int count = 0;
            for (int i : dis) {
                if (i != 65535) {
                    System.out.print(vertex[count] +"("+i+")");
                } else {
                    System.out.print("N ");
                }
                count++;
            } //end for
            System.out.println();
        }
    } //end VisitedVertex
}
