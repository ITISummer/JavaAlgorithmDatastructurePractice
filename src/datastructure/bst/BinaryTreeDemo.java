package datastructure.bst;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        //创建需要的节点
        HeroNode root = new HeroNode(1,"宋江");
        HeroNode node2 = new HeroNode(2,"吴用");
        HeroNode node3 = new HeroNode(3,"卢俊义");
        HeroNode node4 = new HeroNode(4,"林冲");
        HeroNode node5 = new HeroNode(5,"关胜");

        //先手动创建一颗树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);
        //测试遍历
        /*System.out.println("前序遍历---------");
        binaryTree.preOrder(root);
        System.out.println("中序遍历---------");
        binaryTree.inOrder(root);
        System.out.println("后序遍历---------");
        binaryTree.postOrder(root);*/


        //测试查找
       /* HeroNode resNode = null;
        resNode = binaryTree.preOrderSearch(root,1);
        System.out.println("-------------前序查找！");
        if (resNode != null) {
            System.out.println("找到了！");
        } else {
            System.out.println("没找到！");
        }
        System.out.println("-------------中序查找！");
        resNode = binaryTree.inOrderSearch(root,4);
        if (resNode != null) {
            System.out.println("找到了！");
        } else {
            System.out.println("没找到！");
        }
        System.out.println("-------------后序查找！");
        resNode = binaryTree.postOrderSearch(root,5);
        if (resNode != null) {
            System.out.println("找到了！");
        } else {
            System.out.println("没找到！");
        }
        */


       /*
       //测试删除
        binaryTree.preOrder(root);
        binaryTree.delNode(root,5);
        binaryTree.preOrder(root);
        */

       //顺序存储二叉树的前序遍历
       /*int[] arr = {1,2,3,4,5,6,7};
       binaryTree.preOrder(arr,0);
        */

    } //end main()

}


