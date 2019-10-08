package com.algorithms.dynamicprogramming;

public class LongestCommonSubsequence {

    private static int recursiveLCS(String a, String b, int indexA, int indexB) {
        int result = 0;
        //base case
        if (indexA < 0 || indexB < 0) {
            result = 0;
        } else if (a.charAt(indexA) == b.charAt(indexB)) {
            result = 1 + recursiveLCS(a, b, indexA - 1, indexB - 1);
        } else if (a.charAt(indexA) != b.charAt(indexB)) {
            int tmp1 = recursiveLCS(a, b, indexA - 1, indexB);
            int tmp2 = recursiveLCS(a, b, indexA, indexB - 1);
            result = Math.max(tmp1, tmp2);
        }
        return result;
    }

    private static int dynamicLCS(String a, String b, int indexA, int indexB, int[][] lcsArray) {
        if(lcsArray[indexA -1][indexB-1] > -1) return lcsArray[indexA -1][indexB-1];
        int result = 0;
        //base case
        if (indexA < 0 || indexB < 0) {
            result = 0;
        } else if (a.charAt(indexA) == b.charAt(indexB)) {
            result = 1 + recursiveLCS(a, b, indexA - 1, indexB - 1);
        } else if (a.charAt(indexA) != b.charAt(indexB)) {
            int tmp1 = recursiveLCS(a, b, indexA - 1, indexB);
            int tmp2 = recursiveLCS(a, b, indexA, indexB - 1);
            result = Math.max(tmp1, tmp2);
        }
        lcsArray[indexA -1][indexB-1] = result;
        return result;
    }

    public static void main(String[] args){
        String a = "ABCF";
        String b = "APBEDC";
        int[][] lcsArray = initializeDoubleArray(a.length(),b.length());
        //System.out.println(recursiveLCS(a, b, a.length() -1, b.length() -1));
        System.out.println(dynamicLCS(a, b, a.length() -1, b.length() -1, lcsArray));
    }

    private static int[][] initializeDoubleArray(int a, int b){
        int[][] intArray = new int[a][b];
        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                intArray[i][j] = -1;
            }
        }
        return intArray;
    }
}
