package practice.lanqiao.lanqiao_practice_system;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 问题描述
　　任何一个正整数都可以用2进制表示，例如：137的2进制表示为10001001。
　　将这种2进制表示写成2的次幂的和的形式，令次幂高的排在前面，可得到如下表达式：137=2^7+2^3+2^0
　　现在约定幂次用括号来表示，即a^b表示为a（b）
　　此时，137可表示为：2（7）+2（3）+2（0）
　　进一步：7=2^2+2+2^0 （2^1用2表示）
　　3=2+2^0 
　　所以最后137可表示为：2（2（2）+2+2（0））+2（2+2（0））+2（0）
　　又如：1315=2^10+2^8+2^5+2+1
　　所以1315最后可表示为：
　　2（2（2+2（0））+2）+2（2（2+2（0）））+2（2（2）+2（0））+2+2（0）
输入格式
　　正整数（1<=n<=20000）
输出格式
　　符合约定的n的0，2表示（在表示中不能有空格）
样例输入
137
样例输出
2(2(2)+2+2(0))+2(2+2(0))+2(0)
样例输入
1315
样例输出
2(2(2+2(0))+2)+2(2(2+2(0)))+2(2(2)+2(0))+2+2(0)
提示
　　用递归实现会比较简单，可以一边递归一边输出
 * */
public class Cloth {

		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int number = Integer.valueOf(br.readLine());//从控制台以十进制读入数据
			//System.out.println(Integer.toBinaryString(number));
			toString(Integer.toBinaryString(number));//将读入的十进制数字转换成二进制的字符串
		}

		private static void toString(String binary) {
			char[] temp = binary.toCharArray();//将数字转换成字符串进而转换成字符数组
			boolean control = false;
			
			for (int i = 0; i < temp.length; i++) {
				if (temp[i] == '1') {
					if (control)
						System.out.print("+");
					else
						control = true;
					System.out.print("2");
					int mi = temp.length - i - 1;
					if (mi == 0)
						System.out.print("(0)");
					else if (mi > 1) {
						System.out.print("(");
						toString(Integer.toBinaryString(mi));
						System.out.print(")");
					}

				}//end if
			}//end for
		}//end toString()

	}


