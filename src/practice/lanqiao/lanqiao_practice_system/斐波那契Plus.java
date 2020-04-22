package practice.lanqiao.lanqiao_practice_system;


import java.math.BigInteger;

public class 斐波那契Plus {
	
      public static void main(String[] args) {
         	 final  int N=100;
        	 long start5=System.currentTimeMillis();
          	System.out.println("ce"+fibonacci5(N));
          	System.out.println("cec"+(System.currentTimeMillis()-start5));
	}//end main()
      private static long fibonacci1(int n) {
    	  if(n==1||n==2) {
    		  return 1;
    	  }else {
    		  return fibonacci1(n-1)+fibonacci1(n-2);
    	  }
      }//end fibonacci1()

      private static long fibonacci2(int n) {
    	 if(n>1) {
    		 long result=1;
    		 do {
    			 result+=fibonacci2(n-2);
    			 n--;
    		 }while(n>1);
    		 return result;
    	 }//end if
    	 return n;
      }//end fibonacci2()

      private static long fibonacci3(int n) {
    	 if(n>1) {
    		 long a=0,b=1;
    		 do {
    			 long temp = b;
    			 b+=a;
    			 a=temp;
    			 
    		 }while(--n>1);
    		 return b;
    	 }
    	 return n;
      }//end fibonacci3()

      private static long fibonacci4(int n) {
    	 if(n>1) {
    		long a,b=1;
    		n--;
    		a=n&1;
    		n/=2;
    		while(n-->0) {
    			
    			a+=b;
    			b+=a;
    		}
    		 return b;
    	 }
    	 return n;
      }//end fibonacci4()

  	private  static BigInteger fibonacci5(int n){

  		if(n>1){
  			BigInteger a,b = BigInteger.ONE;
  			n--;
  			a = BigInteger.valueOf(n & 1);
  			n /=2;
  			while (n-->0) {
  				a = a.add(b);
  				b = b.add(a);
  			}
  			return b;
  		}
  		return (n ==0) ? BigInteger.ZERO : BigInteger.ONE;
  	}

}
