package practice.lanqiao.lanqiao_practice_system;

import java.util.Scanner;

public class 大数相乘 {
    
    public void printResult(String A, String B) {
        char[] arrayA = A.toCharArray();
        char[] arrayB = B.toCharArray();
        int len = A.length() + B.length();
      
        int judge = 1;
        int enda = 0, endb = 0;
        if(arrayA[0] == '-' && arrayB[0] != '-') {
            judge = -1;
            len = len - 1;
            enda = 1;
        } else if(arrayA[0] != '-' && arrayB[0] == '-') {
            judge = -1;
            len = len - 1;
            endb = 1;
        } else if(arrayA[0] == '-' && arrayB[0] == '-') {
            len = len - 2;
            enda = 1;
            endb = 1;
        }
        int[] result = new int[len];
        int a, b;
        for(int i = A.length() - 1, tempi = 0; i >= enda;i--,tempi++) {
            a = arrayA[i] - '0';
            for(int j = B.length() - 1, tempj = 0;j >= endb;j--, tempj++) {
                b = arrayB[j] - '0';
                result[len-tempi-tempj-2] += (result[len-tempi-tempj-1] + a * b) / 10;
                result[len-tempi-tempj-1] = (result[len-tempi-tempj-1] + a * b) % 10;
            }//end for
        }//end for
        int i = 0;
        while(result[i] == 0 && i < len - 1)
            i++;
        if(judge == -1)
            System.out.print("-");
        for(;i < len;i++)
            System.out.print(result[i]);
    }
    
    public static void main(String[] args) {
        大数相乘 test = new 大数相乘();
        Scanner in = new Scanner(System.in);
        String A = in.next();
        String B = in.next();
        test.printResult(A, B);
        
//        System.out.println();
//        BigInteger reA=new BigInteger(A);
//        BigInteger reB=new BigInteger(B);
//        BigInteger result=reA.multiply(reB);
//        System.out.println(result.toString());
    }
}
