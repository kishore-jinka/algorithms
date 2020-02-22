package com.algorithms.leetcode.strings;

import java.util.*;

/**
 * 336. Palindrome Pairs
 * https://leetcode.com/problems/palindrome-pairs/
 * TODO: INCOMPLETE
 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        //List<List<Integer>> pairsList = new ArrayList<List<Integer>>();
        List<String> pairsList = new ArrayList();
        TrieNode forwardTrie = new TrieNode();
        for(String word : words){
            insert(word, forwardTrie);
        }
        for(String word : words){
            String reverse = reverseWord(word);
            TrieNode parentNode = startsWith(reverseWord(word), forwardTrie);
            if(parentNode != null){
                if(parentNode.children == null){
                    pairsList.add(word + ", " + reverse);
                }else{
                    List<String> palindromeList = new ArrayList();
                    collectPalindromeChildren(parentNode, palindromeList, new StringBuilder(""));
                    for(String childPalindrome : palindromeList){
                        pairsList.add(word + ", " + reverse+childPalindrome);
                    }
                }
            }
        }

        TrieNode reverseTrie = new TrieNode();
        for(String word : words){
            insert(reverseWord(word), reverseTrie);
        }
        for(String word : words){
            TrieNode parentNode = startsWith(word, reverseTrie);
            if(parentNode != null){
                String reverse = reverseWord(word);
                if(parentNode.children == null){
                    pairsList.add(reverse + ", " + word);
                }else{
                    List<String> palindromeList = new ArrayList();
                    collectPalindromeChildren(parentNode, palindromeList, new StringBuilder(""));
                    for(String childPalindrome : palindromeList){
                        pairsList.add(reverse + ", " + word+childPalindrome);
                    }
                }
            }
        }

        for(String pair : pairsList){
            System.out.println(pair);
        }
        return null;
    }

    /** Inserts a word into the trie. */
    public void insert(String word, TrieNode rootNode) {
        TrieNode parentNode = rootNode;
        char[] charArray = word.toCharArray();
        for(int i=0; i<charArray.length; i++){
            if(parentNode.children == null) parentNode.children = new HashMap();
            if(parentNode.children.get(charArray[i]) == null){
                TrieNode childNode = new TrieNode();
                parentNode.children.put(charArray[i], childNode);
            }
            if(i == charArray.length-1) parentNode.children.get(charArray[i]).isWord = true;
            parentNode = parentNode.children.get(charArray[i]);
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public TrieNode startsWith(String prefix, TrieNode rootNode) {
        TrieNode parentNode = rootNode;
        char[] charArray = prefix.toCharArray();
        boolean isFound = false;
        for(int i=0; i<charArray.length; i++){
            if(parentNode.children == null) return null;
            TrieNode childNode = parentNode.children.get(charArray[i]);
            if(childNode == null) return null;
            parentNode = childNode;
            if(i==charArray.length-1){
                isFound = true;
                return parentNode;
            }
        }
        if(isFound){
            return parentNode;
        }else return null;
    }

    private void collectPalindromeChildren(TrieNode parentNode, List<String> palindromeList, StringBuilder builder){
        if(parentNode.children != null) {
            if (builder.length() > 0 && isPalindrome(builder)) palindromeList.add(builder.toString());
            Set<Character> children = parentNode.children.keySet();
            for (Character c : children) {
                builder.append(c);
                collectPalindromeChildren(parentNode.children.get(c), palindromeList, builder);
            }
        }
    }

    private boolean isPalindrome(StringBuilder builder){
        int length = builder.length();
        for(int i=0; i<=builder.length()/2; i++){
            if(builder.charAt(i) != builder.charAt(length-i-1)) return false;
        }
        return true;
    }

    private String reverseWord(String word){
        String reverse = "";
        for(Character c : word.toCharArray()){
            reverse = c + reverse;
        }
        return reverse;
    }

    private class TrieNode{
        private Map<Character, TrieNode> children;
        private boolean isWord = false;
    }

    public static void main(String[] args){
        String[] input = {"abcd","dcba","lls","s","sssll"};
        PalindromePairs palindromePairs = new PalindromePairs();
        List<List<Integer>> pairsList = palindromePairs.palindromePairs(input);
        for(List<Integer> pair : pairsList){
            System.out.println(pair);
        }
    }
}

/*
Example 1:
Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]

Example 2:
Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]

List<Integer> pairs0 = new ArrayList<Integer>();
        pairs0.add(0);
        pairs0.add(1);
        List<Integer> pairs1 = new ArrayList<Integer>();
        pairs1.add(1);
        pairs1.add(0);
        List<Integer> pairs2 = new ArrayList<Integer>();
        pairs2.add(3);
        pairs2.add(2);
        List<Integer> pairs3 = new ArrayList<Integer>();
        pairs3.add(2);
        pairs3.add(4);
        pairsList.add(pairs0);
        pairsList.add(pairs1);
        pairsList.add(pairs2);
        pairsList.add(pairs3);
 */