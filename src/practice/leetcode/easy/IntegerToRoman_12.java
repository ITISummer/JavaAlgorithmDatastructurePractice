package practice.leetcode.easy;

import java.util.Scanner;

public class IntegerToRoman_12 {
	public static void main(String[] args) {
		System.out.println("Please input a  integer:");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		System.out.println(intToRoman_2(num));
	}// end main()
	
	/*
	 * Test Data: 
	 * III--3 
	 * IV--4 
	 * IX--9 
	 * LVIII--58 
	 * MCMXCIV--1994
	 * MCCCXIV--1314
	 * MMMIX--3009
	 * MMMCCXLIX--3249
	 */
public static String intToRoman_1(int num) {
        String []roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","III","II","I"};
        int []integer = {1000,900,500,400,100,90,50,40,10,9,5,4,3,2,1};
        String str="";
        for(;num>0;) {
        	for(int i=0;i<15;i++) {
        		if(num>=integer[i]) {
        			num -= integer[i];
        			str += roman[i];
        			break;
        		}else {
        			continue;
        		}//end if
        	}//end for
        }//end for
	return str;
    }//end intToRoman()

/**
 * Use the simplest method.
 * */
public static String intToRoman_2(int num) {
	
    String str="";
    int a = num/1000;
    int b = num%1000/100;
    int c = num%100/10;
    int d = num%10;

    //Enumerate each possible value
    if(a==0) {str+="";}
    if(a==1) {str+="M";}
    if(a==2) {str+="MM";}
    if(a==3) {str+="MMM";}
    
    if(b==0) {str+="";}
    if(b==1) {str+="C";}
    if(b==2) {str+="CC";}
    if(b==3) {str+="CCC";}
    if(b==4) {str+="CD";}
    if(b==5) {str+="D";}
    if(b==6) {str+="DC";}
    if(b==7) {str+="DCC";}
    if(b==8) {str+="DCCC";}
    if(b==9) {str+="CM";}
    
    if(c==0) {str+="";}
    if(c==1) {str+="X";}
    if(c==2) {str+="XX";}
    if(c==3) {str+="XXX";}
    if(c==4) {str+="XL";}
    if(c==5) {str+="L";}
    if(c==6) {str+="LX";}
    if(c==7) {str+="LXX";}
    if(c==8) {str+="LXXX";}
    if(c==9) {str+="XC";}
    
    if(d==0) {str+="";}
    if(d==1) {str+="I";}
    if(d==2) {str+="II";}
    if(d==3) {str+="III";}
    if(d==4) {str+="IV";}
    if(d==5) {str+="V";}
    if(d==6) {str+="VI";}
    if(d==7) {str+="VII";}
    if(d==8) {str+="VIII";}
    if(d==9) {str+="IX";}
    
    return str;
}//end intToRoman()
}//end IntegerToRoman_12
