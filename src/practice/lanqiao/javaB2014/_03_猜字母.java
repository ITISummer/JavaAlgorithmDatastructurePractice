package practice.lanqiao.javaB2014;

import java.util.ArrayList;
import java.util.List;

/*
标题：
猜字母把abcd..s共19个字母组成的序列重复拼接106次，
得到长度为2014的串
接下来删除第1个字母（即开头的字母a），
以及第3个，第5个等所有奇数位置的字母得到的新串再进行删除 奇数位置 字母的动作。
如此下去，最后只剩下一个字母，请写出该字母。
答案是一个小写字母，请通过浏览器提交答案。不要填写任何多余的內容。*
 */
//public class _03_猜字母 {
//    // initialize char array
//    public static void main(String[] args) {
//        List<Character> list = new ArrayList<>();
//        for (int i = 1; i <= 106; i++) {
//            for (int j = 0; j <= 18; j++) {
//                list.add((char) ('a' + j));
//            }
//        }
////        System.out.println(list.toString());
//
//        // calculation
//        while (list.size() > 1) {
//            for (int i = 0; i < list.size(); i++) {
//                if ((i + 1) % 2 != 0) {
//                    list.remove(i);
//                }
//            }
//        }
//        // print the result
//        System.out.println((char) list.get(0));
//    }
//
//}

public class _03_猜字母 {
    public static void main(String[] args) {
        // initialize char array
        char[] arr = new char[2014];
        int k = 0;
        for (int i = 1; i <= 106; i++) {
            for (int j = 0; j <= 18; j++) {
                arr[k++] = (char) ('a' + j);
            }
        }

        // calculation
        int len = arr.length;
        while (len > 1) {
            int newLen = 0;
            for (int i = 1; i < len; i += 2) {
                arr[newLen++] = arr[i];
            }
            len = newLen;
        }
        // print the result
        System.out.println(arr[0]);
    }
}
