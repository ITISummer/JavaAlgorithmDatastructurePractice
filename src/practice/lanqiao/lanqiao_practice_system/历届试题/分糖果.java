package practice.lanqiao.lanqiao_practice_system.历届试题;

import java.util.Scanner;

/*
http://lx.lanqiao.cn/problem.page?gpid=T124
 */
public class 分糖果 {
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int N=input.nextInt();
		int arr[]=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=input.nextInt();
		}//end for
		int count=0;
		fun(arr,count) ;
	}//end main()
	public static void fun(int arr[],int count) {
		boolean flag=false;
		for(int i=1;i<arr.length;i++) {
			if(arr[0]==arr[i])
				flag=true;
			else {
				flag=false;
				break;
			}//end if
		}//end for
		if(flag==false) {
			int arr1[]=new int[arr.length];
			for(int i=0;i<arr.length;i++)
				arr1[i]=arr[i]/=2;
			arr[0]+=arr1[arr1.length-1];
			for(int i=1;i<arr.length;i++)
				arr[i]+=arr1[i-1];
			for(int i=0;i<arr.length;i++)
				if(arr[i]%2==1) {
					arr[i]+=1;
					count+=1;
				}//end for
			fun(arr,count);
		}else {
			System.out.println(count);
		}
	}//end fun()
}
