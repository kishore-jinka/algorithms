package com.algorithms.leetcode.recursion;

/**
 * 779. K-th Symbol in Grammar
 * https://leetcode.com/problems/k-th-symbol-in-grammar/
 * https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/1675/
 */
public class KthSymbolInGrammer {

    public int kthGrammar(int N, int K) {
        if(K<1 || N<1) return -1;
        if(K==1 && N>=1) return 0;
        if(K==2 && N>=2) return 1;
        int previousK = 0;
        if(K%2 == 1){
            previousK = (K+1)/2;
        }else{
            previousK = K/2;
        }
        int current = kthGrammar(N-1, previousK);
        if(K%2 == 0){
            current = 1 - current;
        }
        return current;
    }



    public static void main(String[] args){
        KthSymbolInGrammer kthSymbolInGrammer = new KthSymbolInGrammer();
        //System.out.println(kthSymbolInGrammer.kthGrammar(30, 434991989));
        System.out.println(kthSymbolInGrammer.kthGrammar(1, 1));
    }

}
