package com.algorithms.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
    public int totalNQueens(int n) {
        Counter counter = new Counter();
        List<Integer> intPositions = new ArrayList<Integer>();
        solveNQueensRecursive(n, intPositions, counter);
        return counter.count;
    }

    private void solveNQueensRecursive(int n, List<Integer> intPositions, Counter counter){
        if(intPositions.size() == n){
            counter.count++;
            return;
        }
        for(int position=0; position<n; position++){
            intPositions.add(position);
            if(arePositionsGood(intPositions)){
                solveNQueensRecursive(n, intPositions, counter);
            }
            intPositions.remove(intPositions.size() - 1);
        }
    }

    private boolean arePositionsGood(List<Integer> intPositions){
        if(intPositions.size() == 1) return true;
        for(int i=0; i<intPositions.size(); i++){
            for(int j=i+1; j<intPositions.size(); j++){
                if(intPositions.get(i) == intPositions.get(j)) return false;
                if(Math.abs(intPositions.get(j) - intPositions.get(i)) == j - i) return false;
            }
        }
        return true;
    }

    private class Counter{
        int count=0;
    }

    public static void main(String[] args){
        NQueensII nQueensII = new NQueensII();
        System.out.println(nQueensII.totalNQueens(8));
    }
}
