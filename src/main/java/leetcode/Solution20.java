package leetcode;

import java.util.Stack;

public class Solution20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i<s.length()) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((top == '(' && c != ')') || (top == '{' && c != '}') || (top == '[' && c != ']')) {
                    return false;
                }
            }
            i++;
        }
        return stack.isEmpty();
    }

}
