package practice.luogu.循环循环循环;

import java.util.Scanner;

/**
 * 【https://www.luogu.com.cn/problem/P1980】
 */
public class P1980计数问题 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int x = input.nextInt();
        int temp; //用于存放i的值
        int tempN;//用于存放临时的余数值
        int result = 0;//用于统计结果
        for (int i = 1; i <= n; i++) {
            temp = i;
            while (temp != 0) {
                tempN = temp % 10;
                temp /= 10;
                if (tempN == x) {
                    result ++;
                } //end if
            } //end while
        } //end for
        System.out.println(result);
    } //end main()
}


//另一种思想

//#include<iostream>
//#include<cstdio>
//using namespace std;
//        int main(){
//        int n,x,m=1,ans=0;
//        scanf("%d%d",&n,&x);
//        while(m<=n){
//        int a=n/(m*10),b=n/m%10,c=n%m; //a,b,c为n的三部分，求哪一位x的个数，b就为那一位数，a为b左边的数，c为b右边的数，如求1~728中十位7的个数，则a=7，b=2，c=8
//        if(x){
//        if(b>x) ans+=(a+1)*m; //如果b>x，说明有(a+1)*m个x（如求1~728中个位7的个数，则为（72+1）*1=73）
//        if(b==x) ans+=a*m+c+1; //如果b=x，说明有a*m+c+1个x（如求1~728中百位7的个数，则为0*100+28+1=29）
//        if(b<x) ans+=a*m; //如果b<x，说明有a*m个x（如求1~728中十位7的个数，则为7*10个）
//        }
//        else{ //x=0的情况和x！=0的情况有所不同
//        if(b) ans+=a*m;
//        else ans+=(a-1)*m+c+1;
//        }
//        m*=10;
//        }
//        printf("%d\n",ans);
//        return 0;
//        }