package com.algorithms.dynamicprogramming;

public class EggDropping {

    private static int resurssiveEggDrop(int eggs, int floors) {
        int finalResult = 0;
        if (floors == 1 || floors == 0 || eggs == 1) {
            finalResult = floors;
        } else {
            int min = Integer.MAX_VALUE;
            int result = 0;
            for (int i = 1; i <= floors; i++) {
                result = Math.max(resurssiveEggDrop(eggs - 1, i - 1), resurssiveEggDrop(eggs, floors - i));
                if (result < min) min = result;
            }
            finalResult = min + 1;
        }
        return finalResult;
    }

    private static int dynamicEggDrop(int eggs, int floors, int[][] eggDropArray) {
        if(eggDropArray[eggs-1][floors] > -1) return  eggDropArray[eggs-1][floors];
        int finalResult = 0;
        if (floors == 1 || floors == 0 || eggs == 1) {
            finalResult = floors;
        } else {
            int min = Integer.MAX_VALUE;
            int result = 0;
            for (int i = 1; i <= floors; i++) {
                result = Math.max(resurssiveEggDrop(eggs - 1, i - 1), resurssiveEggDrop(eggs, floors - i));
                if (result < min) min = result;
            }
            finalResult = min + 1;
        }
        eggDropArray[eggs - 1][floors] = finalResult;
        return finalResult;
    }

    public static void main(String[] args) {
        int eggs = 5;
        int floors = 10;
        //System.out.println(resurssiveEggDrop(eggs, floors));

        int[][] eggDropArray = initializeDoubleArray(eggs,floors);
        System.out.println(dynamicEggDrop(eggs, floors, eggDropArray));
    }

    private static int[][] initializeDoubleArray(int a, int b){
        int[][] intArray = new int[a][b+1];
        for(int i=0; i<a; i++){
            for(int j=0; j<=b; j++){
                intArray[i][j] = -1;
            }
        }
        return intArray;
    }

}
