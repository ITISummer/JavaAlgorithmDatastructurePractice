package practice.lanqiao.lanqiao_practice_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 三数相比 {
	
		public static void main(String[] args) throws IOException {
			BufferedReader str=new BufferedReader(new InputStreamReader(System.in));
			String s=str.readLine();
	        String[] s1=s.split(" ");
	        int n=s1.length;
	        int[] arr=new int[n];
	        for(int i=0;i<n;i++){
	        	 arr[i]=Integer.parseInt(s1[i]);
	        }
	        Arrays.sort(arr);
	        for(int j=n-1;j>=0;j--){
	        	System.out.print(arr[j]+" ");
	        }
		}

		
	}


