package datastructure.bst;

/**
 * BST树节点-二叉搜索树
 * @author LCX
 *
 */
public class Entry<T extends Comparable<T>> {
	 T data;//数据域
	 Entry<T> left;//左孩子域
	 Entry<T> right;//右孩子域
	
	public Entry() {
		this(null, null, null);
	}

	public Entry(T data, Entry<T> left, Entry<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}


	public Entry(T t)  {
		this(t, null, null);
	}
}
