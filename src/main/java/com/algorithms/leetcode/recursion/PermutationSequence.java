package com.algorithms.leetcode.recursion;

/**
 * 60. Permutation Sequence
 * https://leetcode.com/problems/permutation-sequence/submissions/
 * TODO: The below implementation is very bad.  Need to improve this
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {
        String str = "";
        for(int i=1; i<=n; i++) str = str + i;
        //System.out.println(str);
        StringSet stringSet = new StringSet();
        Counter counter = new Counter();
        try {
            printPermutation(str, "", k, counter, stringSet);
        }catch(Exception ex){
            //System.out.println(ex);
        }
        return stringSet.getS();
    }

    private void printPermutation(String str, String ans, int k, Counter counter, StringSet stringSet) throws Exception{

        if (str.length() == 0) {
            counter.setCount(counter.getCount() + 1);
            if(counter.getCount() == k) {
                stringSet.setS(ans);
                throw new Exception();
            }
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            printPermutation(ros, ans + ch, k, counter, stringSet);
        }

    }

    private class Counter{
        private int count;
        void setCount(int count){
            this.count = count;
        }
        int getCount(){
            return this.count;
        }
    }

    private class StringSet{
        private String s;
        void setS(String s){
            this.s = s;
        }
        String getS(){
            return this.s;
        }
    }

    public static void main(String[] args) {
        PermutationSequence permutationSequence = new PermutationSequence();
        System.out.println(permutationSequence.getPermutation(3, 3));
    }
}
