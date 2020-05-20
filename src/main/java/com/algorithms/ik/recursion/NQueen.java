package com.algorithms.ik.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    static String[][] find_all_arrangements(int n) {
        List<String[]> nQueensPositions = new ArrayList<String[]>();
        List<Integer> intPositions = new ArrayList<Integer>();
        solveNQueensRecursive(n, intPositions, nQueensPositions);
        return convertListToArray(nQueensPositions,n);
    }

    private static void solveNQueensRecursive(int n, List<Integer> intPositions, List<String[]> nQueensPositions){
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

    private static boolean arePositionsGood(List<Integer> intPositions){
        if(intPositions.size() == 1) return true;
        for(int i=0; i<intPositions.size(); i++){
            for(int j=i+1; j<intPositions.size(); j++){
                if(intPositions.get(i) == intPositions.get(j)) return false;
                if(Math.abs(intPositions.get(j) - intPositions.get(i)) == j - i) return false;
            }
        }
        return true;
    }

    private static String[] convertToStrings(List<Integer> intPositions){
        String[] stringPositions = new String[intPositions.size()];
        for(int j=0; j<intPositions.size(); j++){
            Integer position = intPositions.get(j);
            StringBuffer stringBuffer = new StringBuffer("");
            for(int i=0; i<intPositions.size(); i++){
                if(i != position){
                    stringBuffer.append("-");
                }else{
                    stringBuffer.append("q");
                }
            }
            stringPositions[j] = stringBuffer.toString();
        }
        return stringPositions;
    }

    private static String[][] convertListToArray(List<String[]> nQueensPositions, int n){
        String[][] stringArray = new String[nQueensPositions.size()][n];
        for(int i=0; i<nQueensPositions.size(); i++){
            stringArray[i] = nQueensPositions.get(i);
        }
        return stringArray;
    }

    public static void main(String[] args){
        String[][] nQueensPositions = find_all_arrangements(4);
        for(String[] list : nQueensPositions){
            for(String position : list){
                System.out.println(position);
            }
        }

    }
}
