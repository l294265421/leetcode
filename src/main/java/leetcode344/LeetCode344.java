package leetcode344;

import java.util.LinkedList;

public class LeetCode344 {
    public String reverseString(String s) {
    	if (s == null) {
			return null;
		}
        int len = s.length();
        if (len < 2) {
			return s;
		}
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0; i < len; i++) {
        	stack.push(s.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
			builder.append(stack.pop());
		}
        return builder.toString();
    }
}
