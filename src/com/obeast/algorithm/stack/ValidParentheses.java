package com.obeast.algorithm.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author wxl
 * Date 2022/9/8 11:26
 * @version 1.0
 * Description: 有效的括号
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 == 1){
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                if (stack.isEmpty() || stack.peek() != map.get(c)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        int len = s.length();
        if (len % 2 == 1){
            return false;
        }
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < len; i++){
            char c = s.charAt(i);
            if (c == '('){
                stack.push(')');
            }
            else if (c == '['){
                stack.push(']');
            }
            else if (c == '{'){
                stack.push('}');
            }
            else if (stack.isEmpty() || stack.peek() != c) {
                return false;
            }
            else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid2(s));
    }
}
