package datastructure.tree.AVLtree;


public class AVLTree {
    public static void main(String[] args) {
//        int[] arr = {4,3,6,5,7,8}; // 创建出来的树需要左旋转
//        int[] arr = {10,12,8,9,7,6}; // 创建出来的树需要右旋转
        int[] arr = {10,11,7,6,8,9}; // 创建出来的树需要双旋转

        //创建一颗 AVL 树
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }

        //中序遍历二叉排序树
        //结果：
        System.out.println("中序遍历二叉排序树~");
        avlTree.infixOrder();

        System.out.println("\n没有平衡处理前，树的高度~ " + avlTree.root.height());
        System.out.println("\n没有平衡处理前，左子树的高度~ " + avlTree.root.leftHeight());
        System.out.println("\n没有平衡处理前，右子树的高度~ " + avlTree.root.rightHeight());
    }

    private Node root;

    /**
     * 查找要删除的节点
     * @param value
     * @return
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        } //end if..else
    } //end search()

    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        } //end if...else
    } //end searchParent()

    /**
     * 返回以 node 为根节点的的二叉排序树的最小节点的值
     * @param node
     * @return
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        while(target.left != null) {
            target = target.left;
        }

        //这时候 target 指向了最小节点
        delNode(target.value);
        return target.value;

    } //end delRightTreeMin()

    /**
     *
     * @param value
     */
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            // 1. 先找到要删除的节点
            Node targetNode  = search(value);
            // 如果没有找到要删除的节点
            if (targetNode == null) {
                return ;
            }

            //如果发现当前这颗二叉树只有一个节点
            if (root.left == null && root.right == null) {
                root = null;
                return ;
            }

            //找到 targetNode 的父节点
            Node parent = searchParent(value);
            //如果要删除的节点是叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                // 删除有两颗子树的节点
                //从右边找最小的
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;

            } else {
                //删除只有一颗子树的节点
                //如果要删除的节点有左子节点
                if (targetNode.left != null) {
                    if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            // targetNode 是 parent 的右子节点
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    } //end if...else
                } else {
                    if (parent != null) {
                        //如果要删除的节点有右子节点
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {
                            //如果 targetNode 是 parent 的右子节点
                            parent.left = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    } //end if...else
                } //end if...else
            } //end if...else
        } //end if...else
    } //end delNode()



    /**
     * 添加节点的方法
     * @param node
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        } //end if...else
    } //end add()

    /**
     * 中序遍历二叉排序树
     */
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空，不能遍历！");
        } //end if...else
    } //end infixOrder()


    /**
     * 节点类
     */
    static class Node {
        int value;
        Node left;
        Node right;

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

        /**
         * 返回以 该节点 为根节点的树的高度
         * @return
         */
        public int height() {
            return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
        }

        /**
         * 右旋转方法
         */
        private void rightRotate() {
            Node newNode = new Node(this.value);
            newNode.right = this.right;
            newNode.left = this.left.right;
            newNode.value = this.left.value;

            this.left = this.left.left;
            this.right = newNode;

        } //end rightRotate()

        /**
         * 左旋转方法
         */
        private void leftRotate() {
            //创建新的节点，以当前节点的值
            Node newNode = new Node(this.value);
            //把新节点的左子树设置成当前节点的左子树
            newNode.left = this.left;
            //把新节点的右子树设置成当前节点的右子树的左子树
            newNode.right = this.right.left;
            //把当前节点的值替换成右子节点的值
            newNode.value = this.right.value;
            //把当前节点的右子树设置成右子树的右子树
            this.right = this.right.right;
            //把当前节点的左子树设置成新的节点
            this.left = newNode;
        } //end leftRotate()

        /**
         * 返回左子树的高度
         * @return
         */
        public int leftHeight() {
            return left == null ? 0 : left.height();
        }

        /**
         * 返回右子树的高度
         * @return
         */
        public int rightHeight() {
            return right == null ? 0 : right.height();
        }

        /**
         * 查找希望删除的节点
         * @param value 希望删除的节点的值
         * @return
         */
        public Node search(int value) {
            if (value == this.value) { //找到该节点
                return this;
            } else if (value < this.value) {
                if (this.left == null) {
                    return null;
                }
                return this.left.search(value);
            } else {
                // 往右查找
                if (this.right == null) {
                    return  null;
                }
                return this.right.search(value);
            } //end if...else
        } //end search()


        /**
         *
         * @param value
         * @return
         */
        public Node searchParent(int value) {
            if ((this.left != null && this.left.value == value)
                    || (this.right != null && this.right.value == value)) {
                return this; //父节点
            } else {
                // 往左查找
                if (value < this.value && this.left != null) {
                    return this.left.searchParent(value);
                } else if (value >= this.value && this.right != null) {
                    return this.right.searchParent(value);
                } else {
                    return null; //没有找到父节点
                } //end if...else
            } //end if...else
        } //end searchParent()
        /**
         * 按照二叉排序树的要求来添加
         * @param node
         */
        public void add(Node node) {
            if (node == null) {
                return ;
            }
            //判断传入的结点的值，和当前子树的根节点的值的关系
            //将比父节点小的值放在父节点左边
            if (node.value < this.value) {
                //如果当前节点的的左子节点为空
                if (this.left == null) {
                    this.left = node;
                } else {
                    //递归向左子树添加
                    this.left.add(node);
                } //end if...else
            } else {
                //将比父节点大的值放在父节点右边
                if (this.right == null) {
                    this.right = node;
                } else {
                    //递归向左子树添加
                    this.right.add(node);
                } //end if...else
            } //end if...else

            //当添加完一个节点后，如果（左子树的高度-右子树的高度）> 1，右旋转
            if (leftHeight() - rightHeight() > 1) {
                //如果左子树的右子树高度大于它的左子树高度
                if (this.left != null && this.left.rightHeight() > this.left.leftHeight()) {
                    //先对当前节点的左节点进行左旋转
                    this.left.leftRotate();

                    //再对当前节点进行右旋转
                    this.rightRotate();
                } else {
                    rightRotate();
                } //end if...else
                return ; //必须要！！！
            } //end if
            //当添加完一个节点后，如果（右子树的高度-左子树的高度）> 1，左旋转
            if (rightHeight() - leftHeight() > 1) {
                if (this.right != null && this.right.leftHeight() > this.right.rightHeight()) {
                    this.right.rightRotate();
                    leftRotate();
                } else {
                    leftRotate();
                } //end if...else
            } //end if
        } //end add()

        /**
         * 中序遍历
         */
        public void infixOrder() {
            if (this.left != null) {
                this.left.infixOrder();
            }
            System.out.print(this.value+" ");
            if (this.right != null) {
                this.right.infixOrder();
            }
        } //end infixOrder()
    } //end Node

}
