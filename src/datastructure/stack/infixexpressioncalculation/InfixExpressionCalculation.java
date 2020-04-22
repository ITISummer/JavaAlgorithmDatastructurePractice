package datastructure.stack.infixexpressioncalculation;

import java.util.LinkedList;

/**
 * 中缀表达式转为后缀表达式（逆波兰表达式）计算<br>
 * 1. 如果栈为空，直接入栈运算符<br>
 * 2. 如果是“(”括号，直接入栈<br>
 * 3. 如果遇见“)”括号，连续出栈直到遇见“(”为止<br>
 * 4. 当前符号的优先级>栈顶符号，直接入栈当前符号<br>
 * 5. 当前符号优先级<=栈顶符号，栈顶一直出栈<br>
 * 6. 测试用例：9+(3-1)*3+10/2
 * [(3+4)*5-6] -> [3 4 + 5 * 6 -]
 * [4 * 5 - 8 + 60 +8 / 2] -> [4 5 * 8 - 60 + 8 2 / +]
 * @author LCX
 */
public class InfixExpressionCalculation {

    public static LinkedList<String> getSuffixExpression(String infixExpression) {
        //用来存储数字，因为可能出现多位数的数字，使用字符串来存储
        StringBuilder sb = new StringBuilder();
        //存储后缀表达式的内容
        LinkedList<String> suffixExpression = new LinkedList<String>();
        //存储符号的栈
        LinkedList<Character> signStack = new LinkedList<Character>();

        //开始遍历中缀表达式
        for (int i = 0; i < infixExpression.length(); i++) {
            //处理遍历到的数字
            if (Character.isDigit(infixExpression.charAt(i))) {
                //考虑数字可能是多位数
                sb.append(infixExpression.charAt(i));
            } else {
                if (sb.length() > 0) {
                    //遇到符号就把数字栈中栈顶数字放入后缀表达式
                    suffixExpression.add(sb.toString());
                    sb.delete(0, sb.length()); //将存储数组的数字字符串sb置为空
                } //end if
                //处理当前遍历到的符号
                if (signStack.isEmpty() || (infixExpression.charAt(i) == '(')) { //#1 #2
                    signStack.push(infixExpression.charAt(i));
                } else {
                    if (infixExpression.charAt(i) == ')') {//#3
                        while (!signStack.isEmpty()) {
                            char ch = signStack.pop();
                            if (ch == '(') {
                                break;
                            }
                            suffixExpression.add(String.valueOf(ch));//将字符转换为字符串添加到后缀表达式栈中
                        } //end while
                    } else {
                        //#4 #5 判断当前符号的优先级
                        while (!signStack.isEmpty() && !priority(infixExpression.charAt(i), signStack.peek())) {
                            suffixExpression.add(String.valueOf(signStack.pop()));
                        } //end while
                        signStack.push(infixExpression.charAt(i));
                    }//end if...else
                }//end if...else
            } //end if...else
        }//end for
        //处理最后一个数字串
        if (sb.length() > 0) {
            suffixExpression.add(String.valueOf(signStack.pop()));
        }
        //处理符号栈中剩余的符号
        while (!signStack.isEmpty()) {
            suffixExpression.add(String.valueOf(signStack.pop()));
        }
        System.out.println(suffixExpression);
        return suffixExpression;
    }

    /**
     * 判断符号优先级
     *
     * @param charAt 当前遍历到的符号
     * @param peek   栈顶符号
     * @return
     */
    private static boolean priority(char charAt, Character peek) {
        switch (charAt) {
            case '+':
            case '-':
                switch (peek) {
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        return false;
                    case '(':
                        return true;
                    default:
                        break;
                }//end switch
            case '*':
            case '/':
                switch (peek) {
                    case '*':
                    case '/':
                        return false;
                    case '(':
                    case '+':
                    case '-':
                        return true;
                    default:
                        break;
                }//end switch
                break;
        }//end switch
        return false;
    }// end priority()
}
