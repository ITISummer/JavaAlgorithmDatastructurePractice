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
public class BroadFirstSearchMaze {
	//存储迷宫的所有路径节点信息
	private MazeNode[][] mazeMap;
	//存储迷宫的路径节点，借助该队列，以左上角入口为中心，层层向外扩展最短的路径的节点
	private LinkedList<MazeNode> nodeQue;
	
	private MazeNode[][] mazeRecord;
	//迷宫的行数
	int row;
	//迷宫的列数
	int col;
	/**
	 * 迷宫的初始化操作
	 * @param row
	 * @param col
	 */
	public BroadFirstSearchMaze(int row, int col) {
		this.row = row;
		this.col = col;
		this.mazeMap = new MazeNode[this.row][this.col];
		this.mazeRecord = new MazeNode[this.row][this.col];
		this.nodeQue = new LinkedList<MazeNode>();
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
		//如果可以走，则将当前节点入队列
		this.nodeQue.offer(this.mazeMap[0][0]);
		
		while (! this.nodeQue.isEmpty()) {
			MazeNode front = this.nodeQue.peek();
			//能走的节点入队
			//当前节点右方向
			if (this.mazeMap[front.x][front.y].state[Constant.RIGHT] == Constant.OK) {
				this.mazeMap[front.x][front.y].state[Constant.RIGHT] = Constant.NO;
				this.mazeMap[front.x][front.y+1].state[Constant.RIGHT] = Constant.NO;
				//把节点入队
				this.nodeQue.offer(this.mazeMap[front.x][front.y+1]);
				//记录节点行走信息
				this.mazeRecord[front.x][front.y+1] = this.mazeMap[front.x][front.y];
				//检查是否找到右下角的出口节点
				if (check(front.x, front.y+1)) {
					return;
				}
			}
			
			//当前节点下方向
			if (this.mazeMap[front.x][front.y].state[Constant.DOWN] == Constant.OK) {
				this.mazeMap[front.x][front.y].state[Constant.DOWN] = Constant.NO;
				this.mazeMap[front.x+1][front.y].state[Constant.UP] = Constant.NO;
				this.nodeQue.offer(this.mazeMap[front.x+1][front.y]);
				
				//记录节点行走信息
				this.mazeRecord[front.x+1][front.y] = this.mazeMap[front.x][front.y];
				if (check(front.x+1, front.y)) {
					return;
				}
			}
			
			//当前节点左方向
			if (this.mazeMap[front.x][front.y].state[Constant.LEFT] == Constant.OK) {
				this.mazeMap[front.x][front.y].state[Constant.LEFT] = Constant.NO;
				this.mazeMap[front.x][front.y-1].state[Constant.RIGHT] = Constant.NO;
				this.nodeQue.offer(this.mazeMap[front.x][front.y-1]);
				
				//记录节点行走信息
				this.mazeRecord[front.x][front.y-1] = this.mazeMap[front.x][front.y];
				if (check(front.x, front.y-1)) {
					return;
				}
			}
			
			//当前节点上方向
			if (this.mazeMap[front.x][front.y].state[Constant.UP] == Constant.OK) {
				this.mazeMap[front.x][front.y].state[Constant.UP] = Constant.NO;
				this.mazeMap[front.x-1][front.y].state[Constant.DOWN] = Constant.NO;
				this.nodeQue.offer(this.mazeMap[front.x-1][front.y]);
				
				//记录节点行走信息
				this.mazeRecord[front.x-1][front.y] = this.mazeMap[front.x][front.y];
				if (check(front.x-1, front.y)) {
					return;
				}
			}
			
			//队头元素所有方向都处理过了，则出队当前队头元素
			this.nodeQue.poll();
		}
		
	}//end findMaze()
	/**
	 * 检查坐标路径是否是出口节点的坐标
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean check(int x, int y) {
		return x == this.row - 1 && y == this.col-1;
	}//end check()

	/**
	 * 打印迷宫路径的搜索结果
	 */
	public void showMaze() {
		if (this.nodeQue.isEmpty()) {
			System.out.println("迷宫不存在有效路径！");
		} else {
			//把最终的迷宫路径节点的值改成 * 
			int x = this.row - 1;
			int y = this.col - 1 ;
			for(;;) {
				this.mazeMap[x][y].data = '*';
				if (x == 0 && y == 0) {
					break;
				}
				MazeNode node = this.mazeRecord[x][y];
				x = node.x;
				y = node.y;
			}//end for()
			
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
		BroadFirstSearchMaze maze = new BroadFirstSearchMaze(row, col);
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
















