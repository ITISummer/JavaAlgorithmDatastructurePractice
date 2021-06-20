package practice.leetcode.easy;

/**
 * @ClassName GoalParserInterpretation_1678
 * @Author LCX
 * @Date 2021 2021-06-20 10:29 a.m.
 * @Version 1.0
 **/
public class GoalParserInterpretation_1678 {
    /**
     * solution 1
     * using string api
     */
    public String interpret(String command) {
        String s1 = command.replace("()", "o");
        String s2 = s1.replace("(al)", "al");
        return s2;
    }

    /**
     * solution 2
     * using if statement
     */
    public String interpret_2(String command) {
        StringBuilder sb = new StringBuilder();
        int len = command.length();
        for (int i = 0; i < len; i++) {
            if ("G".equals(command.substring(i, i + 1))) {
                sb.append("G");
            } else if ("()".equals(command.substring(i, i + 2))) {
                sb.append("o");
                i++;
            } else if ("(al)".equals(command.substring(i, i + 4))) {
                sb.append("al");
                i += 3;
            }
        }
        return sb.toString();
    }
}
