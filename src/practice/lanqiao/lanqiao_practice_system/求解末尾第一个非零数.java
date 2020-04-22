package practice.lanqiao.lanqiao_practice_system;


/*import java.util.Scanner;


public class P0505{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int temp = 1;
		for (int i = 1; i <= n; ++i) {
			temp *= i;
			while (temp % 10 == 0) {
				temp /= 10;
			}
			temp %= 1000;
		}
		int num = 0;
		while (num == 0) {
			num = temp % 10;
			temp /= 10;
		}
		System.out.println(num);

	}
}*/



/*import java.util.*;
import java.math.*;
public class P0505 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        BigDecimal sum = BigDecimal.ONE;
        BigDecimal temp = BigDecimal.ONE;
        for(int i = 1; i <= n; i++) {
            sum = sum.multiply(BigDecimal.valueOf(i));
        }
        //System.out.println(sum);
        String S = sum.toString();
        for(int i = S.length()-1; i >= 0; i--) {
            if(S.charAt(i) != '0') {
                System.out.println(S.charAt(i));
                return ;
            }
        }
        return ;
    }
 
}*/


    import java.util.Scanner;
    public class 求解末尾第一个非零数 {
         public static void main(String[] args) {
            Scanner sca = new Scanner(System.in);
            int in1 = sca.nextInt();
            int count = 1;
            for(int i = 1;i <= in1; i++) {
                count *= i;
                if(count>1000) {
                if(count%10 == 0) {
                   if(count%100 == 0) {
                       count = (count%1000==0?count/1000:count/100);
                   }else count /=10;
                }
                    count %=1000;
            }
            }
            if(count%10 == 0) {
                   count = count%100==0?count/100:count/10;
                }
            count%=10; 
            System.out.println(count);
         
         }
     
    }
 
