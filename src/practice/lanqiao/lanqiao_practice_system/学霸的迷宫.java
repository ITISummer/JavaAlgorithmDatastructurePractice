package practice.lanqiao.lanqiao_practice_system;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 学霸的迷宫 {
	public static void main(String[] args) {
		int n,m;
		Scanner input = new Scanner(System.in);
		n=input.nextInt();
		m=input.nextInt();
		int map[][]=new int[n][m];
		int book[][]=new int[n][m];
		Queue<Integer> queX=new LinkedList<Integer>();
		Queue <Integer>queY=new LinkedList<Integer>();
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				map[i][j]=input.nextInt();
		queX.offer(0);queY.offer(0);
		book[0][0]=1;
		int direc[][]=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
		String str[]= {"��","��","��","��"},str1 = "";
		int tx,ty,step=0;
		while(queX.peek()!=n-1&&queY.peek()!=m-1) {
			step++;
			for(int i=0;i<4;i++) {
				tx=queX.peek()+direc[i][0];
				ty=queY.peek()+direc[i][1];
				if(tx<0||tx>n-1||ty<0||ty>m-1)
					continue ;
				if(map[tx][ty]==0&&book[tx][ty]==0) {
					book[tx][ty]=1;
					str1+=str[i];
					queX.offer(tx);queY.offer(ty);
				}//end if
			}//end for
			queX.poll();queY.poll();
		}//end while
		step++;
		System.out.println(step);
		System.out.println(str1);
		System.out.println(str1.substring(0,step-1));
	}//end main()
}
