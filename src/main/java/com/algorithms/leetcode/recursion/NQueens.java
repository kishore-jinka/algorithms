package com.algorithms.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> nQueensIntegerPositions = new ArrayList<List<String>>();
        List<Integer> intPositions = new ArrayList<Integer>();
        solveNQueensRecursive(n, intPositions, nQueensIntegerPositions);
        return nQueensIntegerPositions;
    }

    private void solveNQueensRecursive(int n, List<Integer> intPositions, List<List<String>> nQueensPositions){
        if(intPositions.size() == n){
            nQueensPositions.add(convertToStrings(intPositions));
            return;
        }
        for(int position=0; position<n; position++){
            intPositions.add(position);
            if(arePositionsGood(intPositions)){
                solveNQueensRecursive(n, intPositions, nQueensPositions);
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

    private List<String> convertToStrings(List<Integer> intPositions){
        List<String> stringPositions = new ArrayList<String>();
        for(Integer position : intPositions){
            StringBuffer stringBuffer = new StringBuffer("");
            for(int i=0; i<intPositions.size(); i++){
                if(i != position){
                    stringBuffer.append(".");
                }else{
                    stringBuffer.append("Q");
                }
            }
            stringPositions.add(stringBuffer.toString());
        }
        return stringPositions;
    }

    public static void main(String[] args){
        NQueens nQueens = new NQueens();
        List<List<String>> nQueensPositions = nQueens.solveNQueens(4);
        for(List<String> list : nQueensPositions){
            for(String position : list){
                System.out.println(position);
            }
        }

    }
}

//nQueensPositions.add(new ArrayList<Integer>(intPositions));

