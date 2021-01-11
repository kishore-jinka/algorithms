package com.algorithms.ik.graphs;

import java.util.*;

/**
 * Count Basins
 * https://oj.interviewkickstart.com/view_test_problem/6556/122/
 * 23 / 23 test cases passed successfully.
 */
public class CountBasins {
    public static List<Integer> find_basins(List<List<Integer>> matrix) {
        //Write your code here
        List<Coordinates> troughs = new ArrayList();
        int totalRows = matrix.size();
        int totalColumns = matrix.get(0).size();
        for(int row=0; row<totalRows; row++){
            for(int column=0; column<totalColumns; column++){
                int value = matrix.get(row).get(column);
                if(row-1 >= 0 && matrix.get(row-1).get(column) < value) continue;
                if(column-1 >= 0 && matrix.get(row).get(column-1) < value) continue;
                if(row+1 <= totalRows-1 && matrix.get(row+1).get(column) < value) continue;
                if(column+1 <= totalColumns - 1 && matrix.get(row).get(column+1) < value) continue;
                troughs.add(new Coordinates(row, column));
            }
        }
        //printTroughs(troughs);
        List<Integer> basins = new ArrayList();
        boolean[][] visited = new boolean[matrix.size()][matrix.get(0).size()];
        for(Coordinates trough : troughs) {
            breathFirstSearch(visited, matrix, basins, trough);
        }
        Collections.sort(basins);
        return basins;
    }

    private static void breathFirstSearch(boolean[][] visited, List<List<Integer>> matrix, List<Integer> basins, Coordinates trough){
        Queue<Coordinates> queue = new LinkedList();
        queue.add(trough);
        visited[trough.row][trough.column] = true;
        int basinCount=1;
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            for(int i=0; i<numberOfNodes; i++) {
                Coordinates next = queue.poll();
                List<Coordinates> neighbors = getCrestNeighbors(matrix, next);
                for (Coordinates neighbor : neighbors) {
                    if (!visited[neighbor.row][neighbor.column]) {
                        visited[neighbor.row][neighbor.column] = true;
                        basinCount++;
                        queue.add(neighbor);
                    }
                }
            }
        }
        basins.add(basinCount);
    }

    private static List<Coordinates> getCrestNeighbors(List<List<Integer>> matrix, Coordinates c){
        List<Coordinates> list = new ArrayList();
        int value = matrix.get(c.row).get(c.column);
        int totalRows = matrix.size();
        int totalColumns = matrix.get(0).size();
        if(c.row-1 >= 0 && matrix.get(c.row-1).get(c.column) > value & getLeastNeighborValue(matrix,c.row-1, c.column) == value)
            list.add(new Coordinates(c.row-1, c.column));
        if(c.column-1 >= 0 && matrix.get(c.row).get(c.column-1) > value & getLeastNeighborValue(matrix, c.row, c.column-1) == value)
            list.add(new Coordinates(c.row, c.column-1));
        if(c.row+1 <= totalRows-1 && matrix.get(c.row+1).get(c.column) > value & getLeastNeighborValue(matrix,c.row+1, c.column) == value)
            list.add(new Coordinates(c.row+1, c.column));
        if(c.column+1 <= totalColumns - 1 && matrix.get(c.row).get(c.column+1) > value & getLeastNeighborValue(matrix, c.row, c.column+1) == value)
            list.add(new Coordinates(c.row, c.column+1));
        return list;
    }

    private static int getLeastNeighborValue(List<List<Integer>> matrix, int row, int column){
        int minValue = Integer.MAX_VALUE;
        int totalRows = matrix.size();
        int totalColumns = matrix.get(0).size();
        if(row-1 >= 0 && matrix.get(row-1).get(column) < minValue) minValue = matrix.get(row-1).get(column);
        if(column-1 >= 0 && matrix.get(row).get(column-1) < minValue) minValue = matrix.get(row).get(column-1);
        if(row+1 <= totalRows-1 && matrix.get(row+1).get(column) < minValue) minValue = matrix.get(row+1).get(column);
        if(column+1 <= totalColumns-1 && matrix.get(row).get(column+1) < minValue) minValue = matrix.get(row).get(column+1);
        return minValue;
    }

    private static class Coordinates {
        int row;
        int column;
        Coordinates(int row, int column){
            this.row = row;
            this.column = column;
        }
    }

    private static void printTroughs(List<Coordinates> troughs){
        for(Coordinates trough : troughs){
            System.out.println(trough.row + ", " + trough.column);
        }
    }

    public static void main(String[] args){
        Integer[] array0 = {0, 2, 1, 3};
        List<Integer> list0 = Arrays.asList(array0);
        Integer[] array1 = {2, 1, 0, 4};
        List<Integer> list1 = Arrays.asList(array1);
        Integer[] array2 = {3, 3, 3, 3};
        List<Integer> list2 = Arrays.asList(array2);
        Integer[] array3 = {5, 5, 2, 1};
        List<Integer> list3 = Arrays.asList(array3);
        List<List<Integer>> matrix = new ArrayList();
        matrix.add(list0);
        matrix.add(list1);
        matrix.add(list2);
        matrix.add(list3);
        System.out.println(find_basins(matrix));
    }
}
