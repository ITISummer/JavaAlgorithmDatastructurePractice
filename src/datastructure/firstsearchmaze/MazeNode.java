package datastructure.firstsearchmaze;

/**
 * 一个迷宫的节点类型定义
 * @author LCX
 *
 */
public class MazeNode {
	int data;//存储结点的值
	int x;//节点的x坐标
	int y;//节点的y坐标
	int[] state;//存储四个方向的状态
	
	public MazeNode(int data, int x, int y) {
		this.data = data;
		this.x = x;
		this.y = y;
		
		this.state = new int[Constant.NUMBER];
		for (int i = 0; i < Constant.NUMBER; i++) {
			this.state[i] = Constant.NO;
		}
	}
	
	
}
