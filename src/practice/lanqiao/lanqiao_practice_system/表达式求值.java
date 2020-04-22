package practice.lanqiao.lanqiao_practice_system;


import java.util.Scanner;
import java.util.Stack;
public class 表达式求值 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String exp=input.nextLine();
		System.out.println(opreate(exp(exp)));
	}

	private static int opreate(String exp) {
		Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        for(String expre:exp.split(" ")) {
        	if(expre.length()==0) {
        		continue;
        	}else if(expre.charAt(0)=='+'||expre.charAt(0)=='-') {
        		while(!operatorStack.isEmpty()&&(operatorStack.peek()=='+'||operatorStack.peek()=='-'||operatorStack.peek()=='*'||operatorStack.peek()=='/')) {
        			calc(operandStack,operatorStack);
        		}//end while
        		operatorStack.push(expre.charAt(0));
        	}else if(expre.charAt(0)=='*'||expre.charAt(0)=='/'){
        		while(!operatorStack.isEmpty()&&(operatorStack.peek()=='*'||operatorStack.peek()=='/')) {
        			calc(operandStack,operatorStack);
        		}//end while
        		operatorStack.push(expre.charAt(0));
        	} else if (expre.trim().charAt(0) == '(') {
                operatorStack.push('(');
            }
            else if (expre.trim().charAt(0) == ')') {
                while (operatorStack.peek() != '(') {
                    calc(operandStack, operatorStack);
                }
                operatorStack.pop();
            }else {
        		operandStack.push(Integer.parseInt(expre));
        	}
        }//end for
        while (!operatorStack.isEmpty()) {
           calc(operandStack, operatorStack);
        }
        return operandStack.pop();
	}//end opreate()
	/**
	 * �Ա��ʽ���д���
	 * */
	private static String exp(String exp) {
		exp=exp.trim();
		String result = "";
		for(int i=0;i<exp.length();i++) {
			if(exp.charAt(i)=='+'||exp.charAt(i)=='-'||exp.charAt(i)=='*'||exp.charAt(i)=='/'||exp.charAt(i)=='('||exp.charAt(i)==')') {
				result+=" "+exp.charAt(i)+" ";
			} else
                result += exp.charAt(i);
		}//end for
		return result.trim();
	}//end expression()

	public static void calc(Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();
        if (op == '+')
            operandStack.push(op2 + op1);
        else if (op == '-')
            operandStack.push(op2 - op1);
        else if (op == '*')
            operandStack.push(op2 * op1);
        else if (op == '/')
            operandStack.push(op2 / op1);
    }
}

