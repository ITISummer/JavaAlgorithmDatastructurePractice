package practice.leetcode.medium;

public class PowXN_50 {
	public static void main(String[] args) {
		System.out.println(myPow_4(2,5));
	}//end main()
	
	/**
	 * Recursion.
	 * */
	/*
	 * Test Data:
	 * 
	 * */
public static double myPow_1(double x, int n) {
        if(n==0) return 1;
        double half = myPow_1(x,n/2);
        //odd-even check
        if(n%2==0) return half*half;
        if(n>0) return half*half*x;
        return half*half/x;
    }//end myPow()

/**
 * Recurrence.
 * */
public static double myPow_2(double x, int n) {
    double res = 1.0;
    for (int i = n; i != 0; i /= 2) {
        if (i % 2 != 0) res *= x;
        x *= x;
    }//end for
    return n < 0 ? 1 / res : res;
}//end myPow()

/**
 * 
 * */
public static double myPow_3(double x, int n)
{
    double result = 1;
     
    if (n == Integer.MIN_VALUE)
    {
        n = n + 2;
    }
     
    int tempN = Math.abs(n);
     
    for (int i = 31; i >= 0; i--)
    {
        result = result * result;
        if ((tempN & (1 << i)) > 0)  result = result * x;
    }
     
    if (n < 0) result = 1/result;
     
    return result;
}//end myPow()

/**
 * 
 * */
public static double myPow_4(double x, int n)
{
    double result = 1.0;
    for (int  i = 0, absn = Math.abs(n); i <= 31; ++i, absn >>= 1, x *= x)
    {
        if ((absn & 1)==1)
        {
            result *= x;
        }
    }
 
    return n < 0 ? 1 / result : result;
}//end myPow()

}//end PowXN_50
