package datastructure.bst;

import java.net.Inet4Address;
import java.util.LinkedList;

/**
 * 实现BST树(二叉搜索树) 因为涉及元素之间比较，所有继承Comparable类
 *
 * @author LCX
 */
public class BST<T extends Comparable<T>> {
    // 指向树的根节点
    private Entry<T> root;

    /**
     * BST树初始化
     */
    public BST() {
        this.root = null;
    }

    /**
     * BST树的非递归插入操作
     *
     * @param val
     */
    public void insert(T val) {
        if (this.root == null) {
            this.root = new Entry<T>(val, null, null);
            return;
        } // end if

        /*
         * 树不为空，那么从root节点开始寻找节点后插入
         */
        Entry<T> cur = this.root;
        Entry<T> parent = null;
        while (cur != null) {
            parent = cur;
            if (cur.data.compareTo(val) > 0) {
                cur = cur.left;
            } else if (cur.data.compareTo(val) < 0) {
                cur = cur.right;
            } else {
                return;// 元素已有，不插入重复的元素
            } // end if...else
        } // end while
        cur = new Entry<T>(val, null, null);
        if (parent.data.compareTo(val) > 0) {
            parent.left = cur;
        } else {
            parent.right = cur;
        }
    }// end insert()


    /**
     * 递归插入BST
     *
     * @param val
     */
    public void insertRecursion(T val) {
        this.root = insert(this.root, val);
    }//end insertRecursion();

    /**
     * 递归实现BST插入操作
     * 从root指向的结点开始，找合适的位置插入
     *
     * @param root
     * @param val
     */
    public Entry<T> insert(Entry<T> root, T val) {
//		如果开始节点为空
        if (root == null) {
            return new Entry<>(val, null, null);
        }
        if (root.data.compareTo(val) > 0) {
            root.left = insert(root.left, val);
        } else if (root.data.compareTo(val) < 0) {
            root.left = insert(root.right, val);
        } else {
            ; //值相同，不插入
        }
        return root;
    }//end insert()

    /**
     * 递归实现BST查询操作
     *
     * @param val
     * @return
     */
    public boolean queryRecursion(T val) {
        return query(this.root, val) != null;
    }//end queryRecursion()

    /**
     * 从root结点开始，找到值为val的值后返回
     *
     * @param root
     * @param val
     * @return
     */
    public Entry<T> query(Entry<T> root, T val) {
        if (root == null) {
            return null;
        }
        if (root.data.compareTo(val) > 0) {
            return query(root.left, val);
        } else if (root.data.compareTo(val) < 0) {
            return query(root.right, val);
        } else {
            return root;
        }//end query()
    }//end query()

    /**
     * 非递归实现BST树的查询操作
     *
     * @return
     */
    public boolean query(T val) {
        if (this.root == null) {
            return false;
        }

        Entry<T> cur = this.root;
        while (cur != null) {
            if (cur.data.compareTo(val) == 0) {
                return true;
            } else if (cur.data.compareTo(val) > 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            } // end if...else
        } // end while
        return false;
    }// end query()

    /**
     * 递归实现BST删除操作
     *
     * @param val
     */
    public void deleteRecursion(T val) {
        this.root = delete(this.root, val);
    }//end deleteRecursion()

    /**
     * 以root节点为起始点，找值为val的节点进行删除，删除完成后，把新的子树的根节点返回
     *
     * @param root
     * @param val
     * @return
     */
    public Entry<T> delete(Entry<T> root, T val) {
        if (root == null) {
            return null;
        }
        if (root.data.compareTo(val) > 0) {
            root.left = delete(root.left, val);
        } else if (root.data.compareTo(val) < 0) {
            root.right = delete(root.right, val);
        } else {
            //找到了，分三种情况来删除节点
            if (root.left != null && root.right != null) {
                //找前驱节点（左子树中最大值）替换，然后删除前驱节点
                Entry<T> pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //遍历完成后，pre指向了前驱节点
                //使用前驱结点的值覆盖要删除的结点的值
                root.data = pre.data;
                //然后删除前驱节点
                root.left = delete(root.left, pre.data);
            } else {
                if (root.left != null) { //待删除结点的左孩子不为空
                    return root.left;
                } else if (root.right != null) { //待删除结点的右孩子不为空
                    return root.right;
                } else {
                    return null;
                } //end if...else
            } //end if...else
        }
        return root;
    }//end delete()

    /**
     * 实现BST树非递归的删除操作
     */
    public void delete(T val) {
        if (this.root == null) {
            return;
        }

        Entry<T> cur = this.root;
        Entry<T> parent = null;
        while (cur != null) {

            if (cur.data.compareTo(val) > 0) {
                parent = cur;
                cur = cur.left;
            } else if (cur.data.compareTo(val) < 0) {
                parent = cur;
                cur = cur.right;
            } else {
                break;
            } // end if...else
        } // end while

        // 跳出while循环有两种情况-break，或者cur == null
        if (cur == null) {//没找到的情况
            return;
        }

        // 找到后，删除，分三种情况
        // 先处理有两个孩子节点的情况
        if (cur.left != null && cur.right != null) {
            // 找前驱节点(左子树最大值)代替删除节点元素的值，然后直接删除前驱节点并且把前驱节点的值覆盖父节点，就可以了
            Entry<T> old = cur;
            parent = cur;
            cur = cur.right;
            while (cur.right != null) {
                parent = cur;
                cur = cur.right;
            } // end while

            // 覆盖
            old.data = cur.data;
        } // end if

        // 统一删除cur指向的节点
        Entry<T> child = cur.left;
        if (child == null) {
            child = cur.right;
        } // end if

        if (parent == null) {// 删除的是root根节点
            this.root = child;// 重置root
        } else if (parent.left == cur) {
            parent.left = child;
        } else {
            parent.right = child;
        }//end if...else
        if (parent.left == cur) {
            parent.left = child;
        } else {
            parent.right = child;
        } // end if...else
    }// end delete()


    /**
     * 前序遍历
     */
    public void preOrder(Entry<T> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        // 递归
        preOrder(root.left);
        preOrder(root.right);
    }// end preOrder()

    /**
     * 中序遍历
     *
     * @param root
     */
    public void inOrder(Entry<T> root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }// end inOrger()

    /**
     * 中序遍历
     *
     * @param root
     */
    public void subOrder(Entry<T> root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        inOrder(root.right);
        System.out.print(root.data + " ");

    }// end inOrger()

    /**
     * 计算二叉树节点的数量
     *
     * @param root
     * @return
     */
    public int number(Entry<T> root) {
        if (root == null) {
            return 0;
        }
        return number(root.left) + number(root.right) + 1;
    }//end number()

    /**
     * 返回层数
     *
     * @param root
     * @return
     */
    public int level(Entry<T> root) {
        if (root == null) {
            return 0;
        } else {
            int left = level(root.left);
            int right = level(root.right);
            return left > right ? left + 1 : right + 1;
        }

    }// end level()

    /**
     * 层序遍历
     *
     * @param root
     * @param i
     */
    public void levelOrder(Entry<T> root, int i) {
        if (root == null) {
            return;
        }

        if (i == 0) {
            System.out.print(root.data + " ");
            return;
        }

        levelOrder(root.left, i - 1);
        levelOrder(root.right, i - 1);

    }//end levelOrder()

    /**
     * BST树的镜像
     */
    public void mirror() {
        mirror(this.root);
    }

    /**
     * 以root为起始节点遍历二叉树，将根节点的左右子节点进行交换
     *
     * @param root
     */
    public void mirror(Entry<T> root) {
        if (root == null) {
            return;
        }

        Entry<T> tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        mirror(root.left);
        mirror(root.right);
    } //end mirror()

    /**
     * 把BST树中在[v1,v2]区间的所有元素打印出来
     * 利用BST中序遍历的特性
     *
     * @param v1
     * @param v2
     */
    public void printSectionDatas(T v1, T v2) {
        printSectionDatas(this.root, v1, v2);
    } //end printSectionDatas()

    /**
     * 以root节点为起始节点，找满足[v1,v2]区间的元素
     *
     * @param root
     * @param v1
     * @param v2
     */
    public void printSectionDatas(Entry<T> root, T v1, T v2) {
        if (root == null) {
            return;
        }
        if (root.data.compareTo(v1) > 0) {
            printSectionDatas(root.left, v1, v2);
        }
        //root.data
        if (v1.compareTo(root.data) <= 0 && v2.compareTo(root.data) >= 0) {
            System.out.println(root.data + " ");
        }//end if
        if (root.data.compareTo(v2) < 0) {
            printSectionDatas(root.right, v1, v2);
        }
    } //end printSectionDatas()

    /**
     * 判断一颗树是不是BST树
     * 首先是 二叉树，然后满足，left<father<right
     *
     * @return
     */
    public boolean isBSTree() {
        boolean ret = isBSTree(this.root);
        lastInorderVal = null;
        return ret;
    }

    /**
     * 以root为起始节点，判断二叉树中的每一个节和其左右孩子是否满足left<father<right
     * 方法：判断是否满足中序遍历的特点
     *
     * @param root
     * @return
     */
    T lastInorderVal = null;

    public boolean isBSTree(Entry<T> root) {
        if (root == null) {
            return true;
        }

        if (!isBSTree(root.left)) { //左子树判断已经不是BST树，则不用再往下判断了
            return false;
        }
        //处理当前节点，拿当前root节点和中序遍历的上一个节点进行数值比较
        if (lastInorderVal != null && root.data.compareTo(lastInorderVal) <= 0) {
            return false;
        }
        lastInorderVal = root.data; //更新当前中序遍历，遍历到的元素的值

        return isBSTree(root.right);
    }//end isBSTree()

    /**
     * 判断传入的参数tree是不是当前bst的一颗子树
     *
     * @param tree
     * @return
     */
    public boolean isChildTree(BST<T> tree) {
        //现在当前BST树中，查找子树tree的根节点是否存在
        if (tree.root == null) {
            return true;
        }

        Entry<T> cur = this.root;
        while (cur != null) {
            if (cur.data.compareTo(tree.root.data) > 0) {
                cur = cur.left;
            } else if (cur.data.compareTo(tree.root.data) < 0) {
                cur = cur.right;
            } else {
                break;
            } //end if...else
            //tree的根节点在当前BST树中没找到
            if (cur == null) {
                return false;
            }
        }//end while
        return isChildTree(cur, tree.root);
    } //end isChildTree()

    /**
     * 比较father和child为起始节点的子树
     *
     * @param father
     * @param child
     * @return
     */
    public boolean isChildTree(Entry<T> father, Entry<T> child) {
        if (father == null && child == null) { //递归结束的条件
            return true;
        }
        if (father == null) {
            return false;
        }
        if (child == null) {
            return true;
        }
        //判断错误的子树
        if (father.data.compareTo(child.data) != 0) {
            return false;
        }
        return isChildTree(father.left, child.left) && isChildTree(father.right, child.right);
    }//end isChildTree()

    /**
     * 获取两个节点的最近公共祖先节点的值，并返回
     *
     * @param v1
     * @param v2
     * @return
     */
    public T getLCA(T v1, T v2) {
        //省略了判断v1,v2是否在树中
        return getLCA(this.root, v1, v2);
    }//end getLCA()

    /**
     * 以root节点指向的节点为起始节点，找一个节点，其值在v1,和v2之间
     *
     * @param root
     * @param v1
     * @param v2
     * @return
     */
    public T getLCA(Entry<T> root, T v1, T v2) {
        if (root == null) {
            return null;
        }
        if (root.data.compareTo(v1) > 0 && root.data.compareTo(v2) > 0) {
            return getLCA(root.left, v1, v2);
        } else if (root.data.compareTo(v1) < 0 && root.data.compareTo(v2) < 0) {
            return getLCA(root.right, v1, v2);
        } else {
            //root.data在区间之内
            return root.data;
        } //end if...else
    } //end getLCA()

    /**
     * 判断一棵树是否是平衡二叉树
     * 任意节点左右子树高度差不超过1
     *
     * @return
     */
    public boolean isBanlance() {
        return isBanlance(this.root);
    } //end isBanlance()

    /**
     * 以root指向的节点为根节点，判断节点左右子树是否平衡
     *
     * @param root
     * @return
     */
    public boolean isBanlance(Entry<T> root) {
        if (root == null) {
            return true;
        }
        int left = level(root.left); // 计算了左子树的高度
        int right = level(root.right); // 计算了右子树的高度

        if (Math.abs(left - right) > 1) {
            // 节点左右子树高度大于1，不平衡
            return false;
        } //end if
        return isBanlance(root.left) && isBanlance(root.right);
    } //end isBanlance()

    /**
     * 返回中序遍历倒数第k个值
     *
     * @param k
     * @return
     */
    public T getInorderKVal(int k) {
        return getInorderKVal(this.root, k);
    } //end getInorderKVal()

    /**
     * 以root为起始节点，反向中序遍历树，并返回第k个节点
     *
     * @param root
     * @param k
     * @return
     */
    int index = 0;

    public T getInorderKVal(Entry<T> root, int k) {
        if (root == null) {
            return null;
        }
        // 反向中序遍历，相当于求整数第k个节点
        T ret1 = getInorderKVal(root.right, k);
        if (ret1 != null) {
            return ret1;
        }
        if (++index == k) {
            // 表示找见第k个值了
            return root.data;
        } //end if
        return getInorderKVal(root.left, k);
    } //end getInorderKVal()

    /**
     * 根据前序遍历和中序遍历构建完整的二叉树
     */
    public void rebuilTree() {
        Integer[] pre = {63, 23, 12, 18, 35, 46, 92, 98, 102};
        Integer[] in = {12, 18, 23, 35, 46, 63, 92, 98, 102};

        BST<Integer> bst = new BST<>();
        bst.rebuildTree(pre, in);
        //构建成功后，打印出来
        bst.preOrder(bst.root);
        bst.inOrder(bst.root);
    } //end rebuildTree()

    /**
     * 根据前序遍历和中序遍历构建完整的二叉树
     *
     * @param pre {63, 23, 12, 18, 35, 46, 92, 98, 102} 二叉树前序
     * @param in  {12, 18, 23, 35, 46, 63, 92, 98, 102} 二叉树中序
     */
    public void rebuildTree(T[] pre, T[] in) {
        this.root = rebuilTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    } //end buildRoot()

    /**
     * 重建二叉树
     *
     * @param pre
     * @param i
     * @param j
     * @param in
     * @param m
     * @param n
     * @return
     */
    public Entry<T> rebuilTree(T[] pre, int i, int j, T[] in, int m, int n) {
        if (i > j || m > n) {
            return null;
        }
        // 以前序遍历数组的首元素，创建当前子树的根节点
        Entry<T> root = new Entry<T>(pre[i]);
        for (int k = m; k <= n; k++) { //拿着pre[i] 在中序遍历中找根节点出现的位置
            if (pre[i].compareTo(in[k]) == 0) {
                root.left = rebuilTree(pre, i + 1, i + (k - m), in, m, k - 1);
                root.right = rebuilTree(pre, i + (k - m) + 1, j, in, k + 1, n);
                break;
            } //end if
        } //end for
        return root;
    } //end rebuilTree()

    /**
     * 非递归实现前序遍历
     * 使用栈来保存中间需要遍历的元素
     */
    public void nonRecursionPreOrder() {
        if (this.root == null) {
            return;
        }
        LinkedList<Entry<T>> stack = new LinkedList<>();
        while (!stack.isEmpty()) {
            Entry<T> top = stack.pop();
            System.out.println(top.data + " ");

            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        } //end while
        System.out.println();
    } //end nonRecursionPreorder()


    /**
     * 非递归实现中序遍历
     */
    public void nonRecursionInOrder() {
        if (this.root == null) {
            return;
        }
        LinkedList<Entry<T>> stack = new LinkedList<>();
        Entry<T> cur = this.root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left; // 一直深度把左孩子入栈
            } else {
                Entry<T> top = stack.pop();
                System.out.println(top.data + " ");
                cur = top.right;
            } //end if...else

        } //end while
    } //end nonRecursionInorder()

    /**
     * 非递归实现后续遍历
     */
    public void nonRecursionPostOrder() {
        if (this.root == null) {
            return;
        }
        LinkedList<Entry<T>> stack1 = new LinkedList<>();
        LinkedList<Entry<T>> stack2 = new LinkedList<>();

        stack1.push(this.root);
        while (!stack1.isEmpty()) {
            Entry<T> top = stack1.pop();
            stack2.push(top);

            if (top.left != null) {
                stack1.push(top.left);
            }
            if (top.right != null) {
                stack1.push(top.right);
            }
        } //end while

        // 这时候stack2中的元素顺序就是后序遍历的顺序
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().data + " ");
        }
    } //end nonRecursionPostOrder()

    /**
     * 非递归实现层序遍历
     */
    public void nonRecursionLevelOrder() {
        if (this.root == null) {
            return;
        }
        LinkedList<Entry<T>> queue = new LinkedList<>();
        queue.offer(this.root);
        while (!queue.isEmpty()) {
            Entry<T> front = queue.poll();
            System.out.println(queue.poll() + " ");

            if (front.left != null) {
                queue.offer(front.left);
            }
            if (front.right != null) {
                queue.offer(front.right);
            }
        } //end while
    } //end nonRecursionLevelOrder()


    /**
     * system calls main()
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {63, 23, 92, 12, 35, 79, 98, 18, 46, 82, 102};
        BST<Integer> bst = new BST<Integer>();
        // 插入
        for (int val : arr) {
            bst.insert(val);
        }


//		System.out.println(bst.query(25));
//		bst.insert(25);
//		System.out.println(bst.query(25));

        System.out.println("前序遍历：");
        bst.preOrder(bst.root);
        System.out.println();
        System.out.println("中序遍历：");
        bst.inOrder(bst.root);
        System.out.println();
        System.out.println("后序遍历：");
        bst.subOrder(bst.root);
        System.out.println();
        System.out.println("层序遍历：");
        bst.levelOrder(bst.root, bst.level(bst.root));
        System.out.println();

    } //end main()

}
