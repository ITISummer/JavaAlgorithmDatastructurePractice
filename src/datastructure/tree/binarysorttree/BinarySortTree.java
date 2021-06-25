package datastructure.tree.binarysorttree;

/**
 * 二叉排序树
 */
public class BinarySortTree {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 0};
        BinarySortTree binarySortTree = new BinarySortTree();

        //循环添加
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        } //end for

        //中序遍历二叉排序树
        //结果：1 3 5 7 9 10 12
        System.out.println("中序遍历二叉排序树~");
        binarySortTree.infixOrder();

        // 测试删除节点
        binarySortTree.delNode(10);
        System.out.println("\n删除节点后的中序遍历~");
        binarySortTree.infixOrder();


    }

    private Node root;

    /**
     * 查找要删除的节点
     *
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
        }
    }

    /**
     * 返回以 node 为根节点的的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }

        //这时候 target 指向了最小节点
        delNode(target.value);
        return target.value;

    } //end delRightTreeMin()

    /**
     * @param value
     */
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            // 1. 先找到要删除的节点
            Node targetNode = search(value);
            // 如果没有找到要删除的节点
            if (targetNode == null) {
                return;
            }

            //如果发现当前这颗二叉树只有一个节点
            if (root.left == null && root.right == null) {
                root = null;
                return;
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
                    }
                }
            }
        }
    }


    /**
     * 添加节点的方法
     *
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
         * 查找希望删除的节点
         *
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
                    return null;
                }
                return this.right.search(value);
            } //end if...else
        } //end search()


        /**
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
         *
         * @param node
         */
        public void add(Node node) {
            if (node == null) {
                return;
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
        } //end add()

        /**
         * 中序遍历
         */
        public void infixOrder() {
            if (this.left != null) {
                this.left.infixOrder();
            }
            System.out.print(this.value + " ");
            if (this.right != null) {
                this.right.infixOrder();
            }
        } //end infixOrder()
    } //end Node
}
