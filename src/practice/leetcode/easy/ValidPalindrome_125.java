package practice.leetcode.easy;


/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome_125 {
    public static boolean isPalindrome_1(String s) {
        s = s.toLowerCase();
//        System.out.println(s);
        int i = 0;
        int j = s.length()-1;
        int diff = 0;
        while (i<j) {
            if(!isAlphanumericLetter(s.charAt(i))) {
                i++;
                continue;
            }
            if(!isAlphanumericLetter(s.charAt(j))) {
                j--;
                continue;
            }
            diff = Math.abs(s.charAt(i)-s.charAt(j));
            if(diff == 32 || diff == 0) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * judge if the character is the alphanumeric letter
     * @param c
     * @return
     */
    private static boolean isAlphanumericLetter(char c) {
        if(Character.isUpperCase(c) || Character.isLowerCase(c) || Character.isDigit(c)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "0P";
        boolean res = isPalindrome_1(s);
//        System.out.println(res);
    }

    public boolean isPalindrome(String s) {
        // convert String s to lowerCase with regex
        String tempString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        // Reverse the tempString
        String rev = new StringBuffer(tempString).reverse().toString();
        // check tempString to rev String
        return tempString.equals(rev);
    }
}
