package datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private ArrayList<String> vertexList; //存储顶点集合
    private int[][] edges; //存储图对应的邻接矩阵
    private int numOfEdges; //表示边的数目
    private boolean[] isVisted;

    public static void main(String[] args) {
        String vertexValue[] = {"A","B","C","D","E"};
        //创建图对象
        Graph graph = new Graph(vertexValue.length);
        //循环添加顶点
        for (int i = 0; i < vertexValue.length; i++) {
            graph.insertVertex(vertexValue[i]);
        }

        //添加边 A-B A-C B-C B-D B-E
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        graph.showGraph(vertexValue);

//        System.out.println("深度优先遍历！");
//        graph.dfs();

        System.out.println("\n广度优先遍历！");
        graph.bfs();

    }

    public Graph(int n) {
        //初始化
        this.edges = new int[n][n];
        this.vertexList = new ArrayList<>(n);
        this.numOfEdges = 0;
        isVisted = new boolean[n];
    }

    /**
     *
     * @param index
     * @return 如果存在就返回对应的下标，否则返回 -1
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    } //end getFirstNeighbor()

    /**
     * 根据前一个节点的下标来获取下一个邻接节点
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1,int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先算法
     * @param isVisted
     * @param i
     */
    public void dfs(boolean[] isVisted,int i) {
        //首先访问第一个节点
        System.out.print(getValueByIndex(i) + "->");
        //将访问过的节点置为 已访问
        isVisted[i] = true;

        //查找节点 i 的第一个邻接节点
        int w = getFirstNeighbor(i);

        while (w != -1) {
            if (!isVisted[w]) {
                dfs(isVisted,w);
            }
            //如果 w 节点已经被访问过
            w = getNextNeighbor(i,w);
        } //end while()
    }

    public void dfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisted[i]) {
                dfs(isVisted,i);
            }
        } //end for
    } //end dfs()

    /**
     * 对一个节点进行广度优先搜索
     * @param isVisted
     * @param i
     */
    public void bfs(boolean[] isVisted, int i) {
        int u; // 表示队列的头节点对应下标
        int w; //邻接节点
        //队列，记录节点访问顺序
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i) + "=>");
        //标记为以访问
        isVisted[i] = true;
        //将节点加入队列
        queue.addLast(i);

        while (! queue.isEmpty() ) {
            //取出队列的头节点下标
            u = (Integer) queue.removeFirst();
            w = getFirstNeighbor(u);
            while ( w != -1) {
                //是否访问过
                if (!isVisted[w]) {
                    System.out.print(getValueByIndex(w) + "=>");
                    //标记已经访问
                    isVisted[w] = true;
                    //入队
                    queue.addLast(w);
                }
                //以 u 为前驱节点，找 w 后面的下一个节点
                w = getNextNeighbor(u,w);

            } //end while
        } //end while

    } //end bfs()

    /**
     * 遍历所有节点，都进行广度优先搜索
     */
    public void bfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisted[i]) {
                bfs(isVisted,i);
            }
        } //end for
    } //end bfs()


    /**
     * 返回节点个数
     * @return
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 得到边的数目
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 返回节点 index 对应的数据
     * @param index
     * @return
     */
    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }

    /**
     * 返回 v1 和 v2 对应的权值
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 显示图
     */
    public void showGraph(String vertexValue[]) {
        int i = 0;
        System.err.println(Arrays.toString(vertexValue));
        for (int[] edge : edges) {
            System.err.print(vertexValue[i++]+" ");
            System.err.println(Arrays.toString(edge));
        }

    } //end showGraph()

    /**
     * 插入节点
     * @param vertex
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     * @param v1 表示点的下标
     * @param v2
     * @param weight
     */
    public void insertEdge(int v1,int v2,int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    } //end insertEdge()


}

