package practice.lanqiao.lanqiao_practice_system.历届试题;

import java.util.Scanner;

/*
http://lx.lanqiao.cn/problem.page?gpid=T125
 */
public class 兰顿蚂蚁 {
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int m=input.nextInt();
		int n=input.nextInt();
		int map[][]=new int[m][n];

		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				map[i][j]=input.nextInt();
		int x=input.nextInt();
		int y=input.nextInt();
		String s=input.next();
		int k=input.nextInt();
		fun(map,x,y,s,k);
	}//end main()
	public static void  fun(int map[][],int x,int y,String s,int k) {
		int step=0;
		while(step!=k)
		switch(s) {
		case "U":
				if(map[x][y]==0) {
					s="L";
					map[x][y--]=1;
				}else if(map[x][y]==1) {
					s="R";
					map[x][y++]=0;
				}
				step++;
				break;
		case "D":
			if(map[x][y]==0) {
				s="R";
				map[x][y++]=1;
			}else if(map[x][y]==1) {
				s="L";
				map[x][y--]=0;
			}
			step++;
			break;
		case "L":
			if(map[x][y]==0) {
				s="D";
				map[x++][y]=1;
			}else if(map[x][y]==1) {
				s="U";
				map[x--][y]=0;
			}
			step++;
			break;
		case "R":
			if(map[x][y]==0) {
				s="U";
				map[x--][y]=1;
			}else if(map[x][y]==1) {
				s="D";
				map[x++][y]=0;
			}
			step++;
			break;
		}//end switch
		System.out.println(x+" "+y);
	}//end fun()
}
