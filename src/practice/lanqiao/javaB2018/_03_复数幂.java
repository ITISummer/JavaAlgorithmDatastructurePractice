package practice.lanqiao.javaB2018;

import java.math.BigInteger;

/*
 * 复数幂
 */
public class _03_复数幂 {
	public static void main(String[] args) {
		BigInteger two = BigInteger.valueOf(2);
		BigInteger three = BigInteger.valueOf(3);
		
		BigInteger a = BigInteger.valueOf(2);
		BigInteger b = BigInteger.valueOf(3);
		BigInteger aa = null;
		BigInteger bb = null;
		for (int i = 0; i < 123455; i++) {
			aa = a.multiply(two).subtract(b.multiply(three)); //aa = 2*a-3*b
			bb = a.multiply(three).add(b.multiply(two)); // bb = 3*a + 2*b
			a = aa;
			b = bb;
		}
		System.out.println(aa+(bb.compareTo(BigInteger.ZERO)<0?"-":"+")+bb+"i");
	}
}
