package app.algo.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CheckParenthesis {
    private static Map<Character, Character> mappings = new HashMap<>();
    static {
        mappings.put('}', '{');
        mappings.put(')', '(');
        mappings.put(']', '[');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length();i++) {
            char c = s.charAt(i);
            // if char is closing
            if(mappings.containsKey(c)) {
                char tel = stack.empty() ? '#' : stack.pop();
                if(tel != mappings.get(c)) {
                    return  false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
