package practice.lanqiao.javaB2013;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MainTest {
    public static void main(String[] args) {
        /*BigInteger val = new BigInteger("6",10);
        System.out.println(val);
        System.out.println(val.bitCount());
        System.out.println(val.bitLength());
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("3");
        System.out.println(Arrays.toString(a.divideAndRemainder(b)));*/

        BigInteger a = new BigInteger("6",10);
        BigDecimal val = new BigDecimal(a);
        BigDecimal val2 = new BigDecimal("2");

        System.out.println(val.divide(val2,5));

    }//end main()
}
