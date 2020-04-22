package datastructure.stack.infixexpressioncalculation;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 计算后缀表达式结果-遇到符号则弹出数字栈中两个数字
 * 与中缀表达式不同，中缀表达式是在处理表达式的同时进行符号优先级判断和计算
 * @author LCX
 */
public class ExpressionResult {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        System.out.println("请输入中缀四则运算表达式：");
        String infixExpression = input.nextLine();
        LinkedList<String> suffixExe = InfixExpressionCalculation.getSuffixExpression(infixExpression);
        getSuffixExeResult(suffixExe);
    }//end main()

    public static int getSuffixExeResult(LinkedList<String> suffixExe) {
        LinkedList<Integer> digitStack = new LinkedList<Integer>();
        //遍历后缀表达式
        for (String val : suffixExe) {
            if (isDigit(val)) {//遍历到的字符串是数字
                digitStack.push(Integer.valueOf(val));
            } else {
                //是符号，则计算结果
                int left = digitStack.pop();
                int right = digitStack.pop();
                int ret = 0;
                switch (val) {
                    case "+":
                        ret = left + right;
                        break;
                    case "-":
                        ret = left - right;
                    case "*":
                        ret = left * right;
                    case "/":
                        ret = left / right;
                    default:
                        break;
                } //end switch
                digitStack.push(ret);
            } //end if...else
        }//end for
        return 0;
    }//end getSuffixExeResult()

    /**
     * 判断返回的后缀表达式中元素是否是数字（考虑到数字是多位数的情况）
     * @param val
     * @return
     */
    private static boolean isDigit(String val) {
        for (int i = 0; i < val.length(); i++) {
            if (Character.isDigit(val.charAt(i))) {
                return true;
            } //end if
        } //end for
        return false;
    }//end isDigt()
}
