package com.algorithms.leetcode.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 394. Decode String
 * https://leetcode.com/problems/decode-string/
 * https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1379/
 */
public class DecodeString {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack();
        for(int i=0; i<charArray.length; i++){
            if(charArray[i] != ']'){
                stack.add(charArray[i]);
            }else{
                List<Character> list = new ArrayList();
                while(stack.peek() != '['){
                    list.add(0, stack.pop());
                }
                stack.pop();
                StringBuilder sb = new StringBuilder();
                while(stack.size() != 0 && (stack.peek() >= '0' && stack.peek() <= '9')){
                    sb.append(stack.pop());
                }
                sb.reverse();
                Integer times = Integer.parseInt(sb.toString());
                for(int j=0; j<times; j++){
                    stack.addAll(list);
                }
            }
        }
        char[] chars = new char[stack.size()];
        int i=stack.size()-1;
        while(!stack.isEmpty()){
            chars[i] = stack.pop();
            i--;
        }
        return new String(chars);
    }

    public static void main(String[] args){
        String s = "2[abc]3[cd]ef";
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString(s));
    }
}
