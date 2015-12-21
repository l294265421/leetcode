package leetcode150;

import java.util.LinkedList;
/**
 * 后缀表达式求值
 */
public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        String operators = "+-*/";
        for (String string : tokens) {
			boolean isOperator = operators.indexOf(string) != -1;
			if (isOperator) {
				Integer num1 = stack.pop();
				Integer num2 = stack.pop();
				Integer result;
				if (string.equals("+")) {
					result = num2 + num1;
				} else if (string.equals("-")) {
					result = num2 - num1;
				} else if (string.equals("*")) {
					result = num2 * num1;
				} else {
					result = num2 / num1;
				}
				stack.push(result);
			} else {
				stack.push(Integer.valueOf(string));
			}
		}
        return stack.pop();
    }
}
