package datastructure.firstsearchmaze;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 解决迷宫问题--DFS
 * 1. 提示用户输入行列数
 * 2. 提示用户输入具体的迷宫信息
 * 3. 找一条从左上角0进到右下角0出的最短路径
 * @author LCX
 *
 */
/*
 * 测试用例
6 6
0 0 1 1 1 1
1 0 0 0 1 1
1 0 1 1 1 1
1 0 1 1 1 1
1 0 1 1 1 1
1 0 0 0 0 0
 */
public class DeepFirstSearchMaze {
	//存储迷宫的所有路径节点信息
	private MazeNode[][] mazeMap;
	//存储迷宫的路径节点
	private LinkedList<MazeNode> nodeStack;
	//迷宫的行数
	int row;
	//迷宫的列数
	int col;
	/**
	 * 迷宫的初始化操作
	 * @param row
	 * @param col
	 */
	public DeepFirstSearchMaze(int row, int col) {
		this.row = row;
		this.col = col;
		this.mazeMap = new MazeNode[this.row][this.col];
		this.nodeStack = new LinkedList<MazeNode>();
	}
	
	/**
	 *  生成迷宫的节点信息
	 * @param data
	 * @param x
	 * @param y
	 */
	public void setMaze(int data, int x, int y) {
		this.mazeMap[x][y] = new MazeNode(data, x, y); 
	}
	
	/**
	 * 调整迷宫所有节点的方向行走状态 
	 */
	public void initMaze() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (this.mazeMap[i][j].data == 1) {
					continue;
				}
				//当前节点的右边是0，设置当前节点的右边可以行走
				if (j < this.col - 1 && this.mazeMap[i][j+1].data == 0) {
					this.mazeMap[i][j].state[Constant.RIGHT] = Constant.OK;
				}
				
				//当前节点的下边是0，设置当前节点的下边可以行走
				if (i < this.row - 1 && this.mazeMap[i+1][j].data == 0) {
					this.mazeMap[i][j].state[Constant.DOWN] = Constant.OK;
				}
				
				//当前节点的左边是0，设置当前节点的左边可以行走
				if (j > 0 && this.mazeMap[i][j-1].data == 0) {
					this.mazeMap[i][j].state[Constant.LEFT] = Constant.OK;
				}
				
				//当前节点的上边是0，设置当前节点的上边可以行走
				if (i > 0 && this.mazeMap[i-1][j].data == 0) {
					this.mazeMap[i][j].state[Constant.UP] = Constant.OK;
				}
				
			}//end for
		}//end for
	}//end initMaze()
	
	/**
	 * 寻找迷宫路径
	 */
	public void findMaze() {
		//不存在迷宫的入口节点
		if (this.mazeMap[0][0].data == 1) {
			return;
		}
		//如果可以走，则将当前节点入栈
		this.nodeStack.push(this.mazeMap[0][0]);
		
		while (! nodeStack.isEmpty()) {
			MazeNode top = nodeStack.peek();
			if (top.x == this.row - 1 && top.y == this.col - 1) {
				//找到终点
				return;
			}
			
			//能走的节点入栈
			//当前节点右方向
			if (this.mazeMap[top.x][top.y].state[Constant.RIGHT] == Constant.OK) {
				this.mazeMap[top.x][top.y].state[Constant.RIGHT] = Constant.NO;
				this.mazeMap[top.x][top.y+1].state[Constant.RIGHT] = Constant.NO;
				this.nodeStack.push(this.mazeMap[top.x][top.y+1]);
				continue;
			}
			
			//当前节点下方向
			if (this.mazeMap[top.x][top.y].state[Constant.DOWN] == Constant.OK) {
				this.mazeMap[top.x][top.y].state[Constant.DOWN] = Constant.NO;
				this.mazeMap[top.x+1][top.y].state[Constant.UP] = Constant.NO;
				this.nodeStack.push(this.mazeMap[top.x+1][top.y]);
				continue;
			}
			
			//当前节点左方向
			if (this.mazeMap[top.x][top.y].state[Constant.LEFT] == Constant.OK) {
				this.mazeMap[top.x][top.y].state[Constant.LEFT] = Constant.NO;
				this.mazeMap[top.x][top.y-1].state[Constant.RIGHT] = Constant.NO;
				this.nodeStack.push(this.mazeMap[top.x][top.y-1]);
				continue;
			}
			
			//当前节点上方向
			if (this.mazeMap[top.x][top.y].state[Constant.UP] == Constant.OK) {
				this.mazeMap[top.x][top.y].state[Constant.UP] = Constant.NO;
				this.mazeMap[top.x-1][top.y].state[Constant.DOWN] = Constant.NO;
				this.nodeStack.push(this.mazeMap[top.x-1][top.y]);
				continue;
			}
			
			//都走不了，则出栈
			this.nodeStack.pop();
		}
		
	}//end findMaze()
	/**
	 * 打印迷宫路径的搜索结果
	 */
	private void showMaze() {
		if (this.nodeStack.isEmpty()) {
			System.out.println("迷宫不存在有效路径！");
		} else {
			//把最终的迷宫路径节点的值改成 * 
			while (! this.nodeStack.isEmpty()) {
				this.nodeStack.pop().data = '*';
			}
			
			//输出迷宫有效路径
			for (int i = 0; i < this.row; i++) {
				for (int j = 0; j < this.col; j++) {
					if (this.mazeMap[i][j].data == '*') {
						System.out.print('*'+" ");
					} else {
						System.out.print(this.mazeMap[i][j].data+" ");
					}
					
				}//end for
				System.out.println();
			}//end for
		}//end if...else
	}//end showMaze()
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("请输入迷宫的行列数(如 5 5)：");
		int row = input.nextInt();
		int col = input.nextInt();
		
		//创建迷宫对象
		DeepFirstSearchMaze maze = new DeepFirstSearchMaze(row, col);
		//用户输入地图
		System.out.println("请输入具体的迷宫路径（0：可走 1：不可走）：");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				maze.setMaze(input.nextInt(),i,j);
			}//end for
		}//end for
		//调整迷宫所有节点的方向行走状态 
		maze.initMaze();
		//寻找迷宫路径
		maze.findMaze();
		//打印结果
		maze.showMaze();
	}//end main()



	

	
	
	
	
}
















