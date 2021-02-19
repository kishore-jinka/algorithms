package com.algorithms.google.strings;

import java.util.ArrayDeque;

/**
 * Aho Corasick Algorithm
 *
 * Which of the following words are contained in the given phone number.
 * Input Words = ["foo", "bar", "baz", "foobar", "emo", "cap", "car", "cat"]
 * Input Phone Number 3662277815781519518916891
 *                    18003569377 -> 1800flowers
 * Output: ["foo", "bar", "foobar", "emo", "cap", "car"]
 */
public class AhoCorasick {

    static int[] toNumber(char[] word){
        int[] map = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
        int[] res = new int[word.length];
        for(int i=0; i<res.length; i++) res[i] = map[word[i] - 'a'];
        return res;
    }


    static void solve(char[] phoneLetters, char[][] wordLetters){
        int[] phoneNumber = new int[phoneLetters.length];
        for(int i=0; i<phoneNumber.length; i++) phoneNumber[i] =  phoneLetters[i] - '0';
        int[][] words = new int[wordLetters.length][];
        for(int i=0; i<words.length; i++) words[i] = toNumber(wordLetters[i]);
        Node trie = new Node();
        for(int[] a : words) trie.addWord(a, 0);
    }

    static class Node{ //Trie Node
        Node[] children = new Node[10];
        Node failLink; // calculated by aho-corasick
        Node[] nextWithFail; //calculated by aho-corasick
        boolean visited = false;

        public Node addWord(int[] word, int index){
            if(index == word.length) return this;
            int child = word[index];
            if(children[child] == null) children[child] = new Node();
            return children[child].addWord(word, index+1);
        }

        public void dfs(ArrayDeque<Node> bfs){
            //for(Node child : nodes){}
        }
    }




















}
