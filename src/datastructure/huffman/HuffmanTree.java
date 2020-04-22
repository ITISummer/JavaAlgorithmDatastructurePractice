package datastructure.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树，权值最小的树
 * 创建赫夫曼树前序遍历的正确结果：67 29 38 15 7 8 23 10 4 1 3 6 13
 *
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node huffmanTreeRoot = createHuffmanTree(arr);
        preOrder(huffmanTreeRoot);
    }

    /**
     * 输出赫夫曼树-前序遍历
     * @param root
     */
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder(root);
        }else {
            System.out.println("空树，不能遍历！");
        }
    } //end preOrder()

    /**
     * 创建赫夫曼树的方法
     *
     * @param arr
     * @return
     */
    public static Node createHuffmanTree(int[] arr) {
        //第一步：遍历 arr 数组，将其中的每一个元素构建成一个 node 然后将 Node 放入 ArrayList 中
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            //第二步：排序 从小到大，使用操纵集合的工具类 Collections；和操纵数组的工具类 Arrays 类相同思想
            Collections.sort(nodes);

            //第三步：取出权值最小的两个节点
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //构建一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value, leftNode, rightNode);

            //从 ArrayList 中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            //将 parent 加入到 nodes 中
            nodes.add(parent);

        } //end while

        //返回赫夫曼树的根节点就行
        return nodes.get(0);

    } //end createHuffmanTree()
}

/**
 * 节点类
 */
class Node implements Comparable<Node> {
    int value; //节点值
    Node left; //指向左子节点
    Node right; //指向右子节点

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }


    @Override
    public int compareTo(Node o) {
        //表示根据 value 从小到大排序
        return this.value - o.value;
    } //end compareTo()

    /**
     * 对树进行前序遍历
     */
    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value+" ");
        preOrder(root.left);
        preOrder(root.right);
    } //end preOrder()
}
