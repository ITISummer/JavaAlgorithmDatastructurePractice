package practice.leetcode.easy;

/**
 * https://leetcode.com/problems/length-of-last-word/
 * Test Case:
 * "   fly me   to   the moon  "
 * "Hello World"
 * "luffy is still joyboy"
 */
public class LengthofLastWord_58 {
    /**
     * trim()+lastIndexOf()
     * @param s
     * @return
     */
        public static int lengthOfLastWord_1(String s) {
            s = s.trim();
            s = s.substring(s.lastIndexOf(' ')+1);
//            System.out.println(s.length());
            return s.length();
        }

    /**
     * trim()+split()
     * @param s
     * @return
     */
    public static int lengthOfLastWord_2(String s) {
        s = s.trim();
        String[] tmp = s.split(" ");
//        System.out.println(tmp[tmp.length-1].length());
        return tmp[tmp.length-1].length();
    }

    /**
     * iteration
     * @param s
     * @return
     */
    public static int lengthOfLastWord_3(String s) {
        int cnt = 0;
        for(int i = s.length()-1; i>=0; i--) {
            if(s.charAt(i)==' ') {
                if(cnt > 0){
//                    System.out.println(cnt);
                    return cnt;
                }
                continue;
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
//        LengthofLastWord_58.lengthOfLastWord_1("Hello World");
        LengthofLastWord_58.lengthOfLastWord_2("   fly me   to   the moon  ");
    }
}
