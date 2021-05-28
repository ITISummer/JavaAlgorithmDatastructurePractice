package javabasic.stringtest;


import java.util.Arrays;

/**
 * String 常见算法题
 */
public class StringAlgo {
    public static void main(String[] args) {
//        System.out.println(reverse_1("abcdefg", 2, 5));
//        System.out.println(reverse_2("abcdefg", 2, 5));
//        System.out.println(getCount("ab","abkkcadkabkedfkaabkskab"));
//        System.out.println(getMaxSubStr_1("cvhellobnm", "abcwerthelloyuiodef"));
        System.out.println(Arrays.toString(getMaxSubStr_2("cvhellobnmabcde", "abcwerthelloyuiodefabcde")));
    }

    /**
     * 获取两个字符串中最大相同字符串。
     * s1 = "abcwerthelloyuiodef";
     * s2 = "cvhellobnm";
     * 提示：将短的那个串进行长度依次递减的子串与较长的串比较
     * [视频讲解](https://www.bilibili.com/video/BV1Kb411W75N?p=477&spm_id_from=pageDriver)
     * 前提：两个字符串中只有一个最大相同字符串
     */
    public static String getMaxSubStr_1(String s1, String s2) {
        if (s1 != null && s2 != null) {
            String maxStr = (s1.length() >= s2.length()) ? s1 : s2;
            String minStr = (s1.length() < s2.length()) ? s1 : s2;
            int minLen = minStr.length();
            for (int i = 0; i < minLen; i++) {
                // 选择子串
                for (int x = 0, y = minLen - i; y <= minLen; x++, y++) {
                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)) {
                        return subStr;
                    }
                }
            }
        }
        return null;
    }

    /**
     * 获取多个最大相同字符串
     * @param s1
     * @param s2
     * @return
     */
    public static String[] getMaxSubStr_2(String s1, String s2) {
        if (s1 != null && s2 != null) {
            StringBuilder sb = new StringBuilder();
            String maxStr = (s1.length() >= s2.length()) ? s1 : s2;
            String minStr = (s1.length() < s2.length()) ? s1 : s2;
            int minLen = minStr.length();
            for (int i = 0; i < minLen; i++) {
                // 选择子串
                for (int x = 0, y = minLen - i; y <= minLen; x++, y++) {
                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)) {
                        sb.append(subStr+",");
                    }
                }
                if (sb.length() != 0) {
                    break;
                }
            }
            // 将最后一个 , 替换为 ""，然后以 , 分割为字符串数组
            String[] sp = sb.toString().replaceAll(",$","").split(",");
            return sp;

        }
        return null;
    }
    /**
     * 获取一个字符串在另一个字符串中出现的次数
     * "ab" 在 abkkcadkabkedfkaabkskab
     */
    public static int getCount(String subStr, String mainStr) {
        int mainLen = mainStr.length();
        int subLen = subStr.length();
        int count = 0;
        int index = -1;
        if (mainLen >= subLen) {
            // 方法一：
//            if ((index = mainStr.indexOf(subStr)) != -1) {
//                count ++;
//            }
//            return count += getCount(subStr,mainStr.substring(index+subLen));
            // 方法二：
//            while ((index = mainStr.indexOf(subStr)) != -1) {
//                count++;
//                mainStr = mainStr.substring(index+subLen);
//            }
            // 方法三： 从指定 index 处开始寻找 subStr
            while ((index = mainStr.indexOf(subStr, index)) != -1) {
                count++;
                index += subLen;
            }
        }
        return count;
    }

    /**
     * 将字符串中指定部分[start,end]进行反转
     * 如： abcdefg -> abfedcg
     */
    public static String reverse_1(String str, int start, int end) {
        if (str != null && !"".equals(str)) {
            char[] tempArr = str.toCharArray();
            for (int x = start, y = end; x < y; x++, y--) {
                char temp = tempArr[x];
                tempArr[x] = tempArr[y];
                tempArr[y] = temp;
            }
            return new String(tempArr);
        }
        return null;
    }

    /**
     * 方式二
     *
     * @param str
     * @param start
     * @param end
     * @return
     */
    public static String reverse_2(String str, int start, int end) {
        if (str != null) {
            StringBuilder res = new StringBuilder(str.length());
            res.append(str.substring(0, start));
            for (int i = end; i >= start; i--) {
//                str+=str.charAt(i);
                res.append(str.charAt(i));
            }
            res.append(str.substring(end + 1));
            return res.toString();
        }
        return null;
    }

}
