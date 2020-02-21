package com.algorithms.leetcode.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class Trie {
    /** Initialize your data structure here. */
    private TrieNode rootNode;

    public Trie() {
        rootNode = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode parentNode = rootNode;
        char[] charArray = word.toCharArray();
        boolean isFound = false;
        for(int i=0; i<charArray.length; i++){
            if(parentNode.children == null) return false;
            TrieNode childNode = parentNode.children.get(charArray[i]);
            if(childNode == null) return false;
            parentNode = childNode;
            if(i==charArray.length-1 && childNode.isWord) isFound = true;
        }
        return isFound;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode parentNode = rootNode;
        char[] charArray = prefix.toCharArray();
        boolean isFound = false;
        for(int i=0; i<charArray.length; i++){
            if(parentNode.children == null) return false;
            TrieNode childNode = parentNode.children.get(charArray[i]);
            if(childNode == null) return false;
            parentNode = childNode;
            if(i==charArray.length-1) isFound = true;
        }
        return isFound;
    }

    private class TrieNode{
        private Map<Character, TrieNode> children;
        private boolean isWord = false;
    }

    public static void main(String[] args){
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}
