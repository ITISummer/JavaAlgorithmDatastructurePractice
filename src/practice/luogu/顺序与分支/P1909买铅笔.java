package practice.luogu.顺序与分支;

import java.util.Scanner;

/**
 * []https://www.luogu.com.cn/problem/P1909
 */
public class P1909买铅笔 {
    public static void main(String[] args) {
        //表示最小的花费
        int minCost = 0;
        //表示铅笔数量
        int pencil = 0;
        //数量和价值
        int[][] countValue = new int[3][2];
        //中间值
        int tempValue = 0;
        Scanner input = new Scanner(System.in);
        pencil = input.nextInt();

        //循环输入铅笔种类和价值
        for (int i = 0; i < countValue.length; i++) {
            for (int j = 0; j < countValue[i].length; j++) {
                countValue[i][j] = input.nextInt();
            } //end for
            //输入一组值后就动态计算全部购买此组值需要花费的钱
            if (pencil % countValue[i][0] != 0) {
                tempValue = (pencil / countValue[i][0] + 1) * countValue[i][1];
            } else {
                tempValue = (pencil / countValue[i][0]) * countValue[i][1];
            }
            //取最小值
            if (minCost > tempValue || minCost == 0) {
                minCost = tempValue;
            }
        } //end for
        System.out.println(minCost);
    } //end main()

}


//#include<cstdio>
//    using namespace std;
//            int i,j,k,n,m,w,ans;
//            int main(){
//            scanf("%d",&n);
//            for(i=0;i<3;i++){
//        scanf("%d%d",&j,&k);m=j;w=k;//输入并存下初始的价格与数量
//        while(j<n){j<<=1;k<<=1;}//价格与数量不断*2直到数量大于n
//        while(j>n){j-=m;k-=w;}//*2有可能导致买太多了，减去一些
//        while(j<n){j+=m;k+=w;}//减去之后又可能太少了，加上一些
//        //其实就是大幅度地上调，然后做一些微调
//        if(k<ans||ans==0)ans=k;//判断是否是最小花费
//        }
//        printf("%d\n",ans);
//        return 0;//输出并返回
//        }
