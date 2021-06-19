package practice.leetcode.easy;

/**
 * @ClassName DefangingAnIPAddress_1108
 * @Author LCX
 * @Date 2021 2021-06-19 11:54 a.m.
 * @Version 1.0
 **/
public class DefangingAnIPAddress_1108 {
    /**
     * solution 1
     */
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    /**
     * solution 2
     */
    public String defangIPaddr_2(String address) {
        StringBuilder sb = new StringBuilder();
        char ch[] = address.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != '.') {
                sb.append(ch[i]);
            } else {
                sb.append("[.]");
            }
        }
        return (sb.toString());
    }
}
