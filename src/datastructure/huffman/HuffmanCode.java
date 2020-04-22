package datastructure.huffman;


import java.util.*;

/**
 * 赫夫曼压缩算法实现-赫夫曼编码
 */
public class HuffmanCode {

    //将 HuffmanCodes 表存放在 Map<Byte,String> 形式的 map 中
    static Map<Byte,String> huffmanCodes = new HashMap<>();
    //在生成赫夫曼编码时，需要不断的拼接路径，使用 StringBuilder 来拼接
    static StringBuilder stringBuilder = new StringBuilder();


    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
//        System.out.println(contentBytes.length); // 40

        /*//得到每一个节点
        List<Node> nodes = getNodes(contentBytes);
//        System.out.println(nodes);

        //生成 Huffman 树
        Node huffmanTreeRoot = createHuffmanTree(nodes);
//        preOrder(huffmanTreeRoot);

        //测试生成 HuffmanCodes 的结果
        getCodes(huffmanTreeRoot);
//        System.out.println(huffmanCodes);

        byte[] huffmanCodeBytes = zip(contentBytes,huffmanCodes);
        System.out.println(Arrays.toString(huffmanCodeBytes));*/
        byte[] huffmanCodeBytes = huffmanZip(contentBytes);
        System.out.println(Arrays.toString(huffmanCodeBytes));
    }

    /**
     * 将得到 huffmanCode 的过程封装成一个方法
     * @param bytes
     * @return
     */
    public static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        //根据 nodes 创建的赫夫曼树
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        //对应的赫夫曼编码（根据 赫夫曼树）
        Map<Byte,String> huffmanCodes = getCodes(huffmanTreeRoot);
        //根据生成的赫夫曼编码，压缩得到压缩后的赫夫曼编码字节数组
        byte[] huffmanCodeBytes = zip(bytes,huffmanCodes);
        return huffmanCodeBytes;
    }

    /**
     *
     * @param bytes 原始的字符串对应的 byte[]
     * @param huffmanCodes 生成的 huffmanCodes 编码 map
     * [-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
     * @return
     */
    public static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes) {
        //用于拼接 huffmanCodes 中的编码
        StringBuilder stringBuilder = new StringBuilder();
//        for (Map.Entry<Byte,String> entry:huffmanCodes.entrySet()) {
//            stringBuilder.append(entry.getValue());
//        } //end for
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
//        System.out.println(stringBuilder.toString());

        //下面写法也可如下 int len = (stringBuilder.length() + 7) / 8
        int len;
        if (stringBuilder.length() % 8 ==0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //创建 存储压缩后的 byte 数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;// 记录是第几个 byte
        for (int i = 0; i < stringBuilder.length(); i+=8) {
            //因为每 8 位对应一个 byte，所以步长 +8
            String strByte;
            if (i+8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i,i + 8);
            } //end if...else

            //将 strByte 转成一个 byte ，放入到 huffmanCodesBytes 中
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte,2);
            index ++;
        } //end for
        return huffmanCodeBytes;
    } //end zip()

    /**
     *
     * @param root
     * @return
     */
    public static Map<Byte,String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        //处理 root 的左子树
        getCodes(root.left,"0",stringBuilder);

        //处理 root 的右子树
        getCodes(root.right,"1",stringBuilder);

        return huffmanCodes;

    } //end getCodes()
    /**
     * 功能：将传入的 node 节点的所有叶子节点的赫夫曼编码得到，并放入到 huffmanCodes 中
     * @param node 传入的节点
     * @param code 路径：左子节点是 0，右子节点是 1
     * @param stringBuilder 用于拼接路径
     *  32->01 97->100 100->11000 等等
     * {32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011}
     */
    public static void getCodes(Node node,String code,StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (node != null) {
            //判断当前 node 是叶子节点还是非叶子节点
            if (node.data == null) {
                //非叶子节点
                //递归向左处理
                getCodes(node.left,"0",stringBuilder1);
                //递归向右处理
                getCodes(node.right,"1",stringBuilder1);
            } else {
                //说明是一个叶子节点
                huffmanCodes.put(node.data,stringBuilder1.toString());
//                stringBuilder.delete(stringBuilder.length() - 1,stringBuilder.length());
            } //end if...else
        } //end if
    } //end getCodes()

    /**
     * 前序遍历
     * @param root
     */
    public static void preOrder(Node root) {
        if (root == null) {
            System.out.println("树不存在！");
            return;
        } else {
            root.preOrder(root);
        }
    }

    /**
     * 获取统计好字符出现次数并创建好树
     * @param bytes
     * @return
     */
    public static List<Node> getNodes(byte[] bytes) {
        // 创建一个 ArrayList
        List<Node> nodes = new ArrayList<>();

        // 统计字符出现次数
        Map<Byte,Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            } //end if...else
        } //end for

        //把每一个键值对转换成一个 Node 对象，并加入到 nodes 集合中
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }

        return nodes;
    } //end getNodes()


    public static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            //排序，从小到大
            Collections.sort(nodes);

            //取最小和次小，将权值相加并合成一棵二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //创建一颗树的根节点，没有 data ，只有 weight
            Node parent = new Node(null,leftNode.weight+rightNode.weight,leftNode,rightNode);
            //将新节点添加到集合中
            nodes.add(parent);
            //将集合中已经处理过的两个节点给移除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
        } //end while

        return nodes.get(0);
    }
    /**
     * 节点值-存放数据和权值
     */
    static class Node implements Comparable<Node>{
        Byte data; //存放数据，字符的 ASCII 编码
        int weight; //权值
        Node left;
        Node right;

        public Node(Byte data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        public Node(Byte data, int weight, Node left, Node right) {
            this.data = data;
            this.weight = weight;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

        /**
         * 结点的前序遍历
         * @param root
         */
        public void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.println(root);
            preOrder(root.left);
            preOrder(root.right);
        } //end preOrder()
    } //end Node

}
