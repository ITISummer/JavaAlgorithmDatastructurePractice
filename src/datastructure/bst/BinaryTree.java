package datastructure.bst;

/**
 * 二叉树的一些常规操作
 */
public class BinaryTree {
    private HeroNode root;

    /**
     * 设置二叉树的根节点
     * @param root
     */
    public void setRoot(HeroNode root) {
        this.root = root;
    }
    /**
     * 前序遍历-递归
     */
    public void preOrder(HeroNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        //遍历打印左子树
        if (root.getLeft() != null) {
            preOrder(root.getLeft());
        }
        //遍历打印右子树
        if (root.getRight() != null) {
            preOrder(root.getRight());
        }
    } //end preOrder()

    /**
     * 中序遍历
     * @param root
     */
    public void inOrder(HeroNode root) {
        if (root == null) {
            return;
        }

        if (root.getLeft() != null) {
            inOrder(root.getLeft());
        }
        System.out.println(root);
        if (root.getRight() != null) {
            inOrder(root.getRight());
        }
    } //end inOrder()

    /**
     * 后序遍历
     * @param root
     */
    public void postOrder(HeroNode root) {
        if (root == null) {
            return;
        }

        if (root.getLeft() != null) {
            postOrder(root.getLeft());
        }
        if (root.getRight() != null) {
            postOrder(root.getRight());
        }
        System.out.println(root);
    } //end inOrder()

    /**
     * 前序遍历查找
     * @param id
     * @return
     */
    public HeroNode preOrderSearch(HeroNode root,int id) {
        if (root.getNo() == id) {
            return root;
        }
        //左边节点查找是否为空
        HeroNode node = null;
        if (root.getLeft() != null) {
            node = preOrderSearch(root.getLeft(),id);
        }
        //找到就返回，不需要往后找
        if (node != null) {
            return node;
        }
        //右边边节点查找是否为空
        if (root.getRight() != null) {
            node = preOrderSearch(root.getRight(),id);
        }
        return node;
    } //end preOrderSearch()

    /**
     * 中序遍历查找
     * @param id
     * @return
     */
    public HeroNode inOrderSearch(HeroNode root,int id) {
        HeroNode node = null;
        if (root.getLeft() != null) {
            node = inOrderSearch(root.getLeft(),id);
        }
        if (node != null) {
            return node;
        }
        //返回
        if (root.getNo() == id) {
            return root;
        }
        //进行右递归查找
        if (root.getRight() != null) {
            node = inOrderSearch(root.getRight(),id);
        }
        return node;
    } //end inOrderSearch()

    /**
     * 后序遍历查找
     * @param root
     * @param id
     * @return
     */
    public HeroNode postOrderSearch(HeroNode root,int id) {
        HeroNode node = null;
        //向左递归
        if (root.getLeft() != null) {
            node = postOrderSearch(root.getLeft(),id);
        }
        if (node != null) {
            return node;
        }
        //向右递归
        if (root.getRight() != null) {
            node = postOrderSearch(root.getRight(),id);
        }
        if (node != null) {
            return node;
        }
        //左右子树都没找到
        if (root.getNo() == id) {
            return root;
        }
        return node;
    } //end postOrderSearch()

    /**
     * 删除节点操作
     * 如果删除的是叶子节点，则删除该节点
     * 如果删除的是非叶子节点，则删除该树
     * @param root
     * @param value
     * @return
     */
    public void delNode(HeroNode root,int value) {
        if (root != null && root.getNo() == value) {
            root = null;
            return ;
        }
        //如果左子节点不为空，并且左子节点就是要删除节点，则删除
        if (root.getLeft() != null && root.getLeft().getNo() == value) {
            root.setLeft(null);
            return ;
        }
        //如果右子节点不为空，并且右子节点就是要删除节点，则删除
        if (root.getRight() != null && root.getRight().getNo() == value) {
            root.setRight(null);
            return ;
        }
        //向左子树递归
        if (root.getLeft() != null) {
            delNode(root.getLeft(),value);
        }
        //向右子树递归
        if (root.getRight() != null) {
            delNode(root.getRight(),value);
        }
        return ;
    } //end delNode()

    /**
     * 顺序存储二叉树的前序遍历
     * 根据特征：
     * 有序数组：[1,2,3,4,5,6,7]
     * index:    0,1,2,3,4,5,6
     * 在二叉树中：一个节点的左节点为该节点下标的 index*2+1
     * 在二叉树中：一个节点的右节点为该节点下标的 index*2+2
     * 输出序列应该为：[1,2,4,5,3,6,7]
     * @param arr
     * @param index
     */
    public void preOrder(int[] arr,int index) {
        //先判断数组是否为空或者数组是否没有元素
        if (arr == null || arr.length == 0) {
            return ;
        }
        //输出当前元素
        System.out.print(arr[index]+" ");
        //遍历左子树
        if (index * 2 + 1 < arr.length) {
            preOrder(arr,index * 2 + 1);
        }
        //遍历右子树
        if (index * 2 + 2 < arr.length) {
            preOrder(arr,index * 2 + 2);
        }
    }

}
