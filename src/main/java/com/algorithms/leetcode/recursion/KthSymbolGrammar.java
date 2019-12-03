package com.algorithms.leetcode.recursion;

//todo:incomplete-wrong approach
public class KthSymbolGrammar {

    public int kthGrammar(int N, int K) {
        if(N <= 1) return 0;
        byte[] b = new byte[1];
        b[0] = 0;
        if(N>1){
           b = getNthRow(N, 1, b);
        }
        return b[K-1];
    }

    private byte[] getNthRow(int finalRow, int currentRow, byte[] byteArray){
        if(currentRow >= finalRow) return byteArray;
        byte[] newByteArray = new byte[byteArray.length*2];
        for(int i=0; i<byteArray.length; i++){
            newByteArray[2*i] = byteArray[i];
            if(byteArray[i] == 0){
                newByteArray[2*i+1] = 1;
            }else{
                newByteArray[2*i+1] = 0;
            }
        }
        return getNthRow(finalRow, currentRow+1, newByteArray);
    }

    public static void main(String[] args){
        KthSymbolGrammar ksg = new KthSymbolGrammar();
        //System.out.println(ksg.kthGrammar(1, 1));
        //System.out.println(ksg.kthGrammar(2, 1));
       // System.out.println(ksg.kthGrammar(2, 2));
        System.out.println(ksg.kthGrammar(4, 5));
    }
}

/*
On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).

Examples:
Input: N = 1, K = 1
Output: 0

Input: N = 2, K = 1
Output: 0

Input: N = 2, K = 2
Output: 1

Input: N = 4, K = 5
Output: 1

Explanation:
row 1: 0
row 2: 01
row 3: 0110
row 4: 01101001
Note:

N will be an integer in the range [1, 30].
K will be an integer in the range [1, 2^(N-1)].
 */