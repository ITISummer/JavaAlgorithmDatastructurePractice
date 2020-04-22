package practice.lanqiao.lanqiao_practice_system;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class 括号匹配 {
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		String line=input.nextLine();
		TreeMap<Integer,Integer> res=new TreeMap<>();
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<line.length();i++) {
			char c=line.charAt(i);
			if(c=='(') {
				stack.push(i+1);
			}else {
				Integer pop =stack.pop();
				res.put(pop, i+1);
			}//end if
		}//end for
		for(Map.Entry<Integer, Integer>entry:res.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}//end for
	}//end main()
}
