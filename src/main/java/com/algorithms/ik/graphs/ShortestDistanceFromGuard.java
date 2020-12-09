package com.algorithms.ik.graphs;

import java.util.*;

/**
 * Shortest Distance From the Guard
 * https://oj.interviewkickstart.com/view_test_problem/6556/124/
 * TODO: INCOMPLETE 17 / 19 test cases passed successfully.
 */
public class ShortestDistanceFromGuard {

    public static List<List<Integer>> find_shortest_distance_from_a_guard(List<List<Character>> grid) {
        if(grid.size() == 0) return new ArrayList();

        //1. Discover all guards
        List<Coordinates> guards = new ArrayList<Coordinates>();
        for(int row = 0; row < grid.size(); row++){
            for(int column = 0; column < grid.get(0).size(); column++){
                if(grid.get(row).get(column) == 'G') guards.add(new Coordinates(row, column));
            }
        }

        //2. Launch BFS for each guard and update distance values of open spaces
        int[][] resultGridArray = new int[grid.size()][grid.get(0).size()];
        for(Coordinates guard : guards) {
            boolean[][] visited = new boolean[grid.size()][grid.get(0).size()];
            breathFirstSearch(visited, grid, resultGridArray, guard);
            //printResultGridArray(resultGridArray);
        }

        //3. Convert result array to result list
        List<List<Integer>> resultGridList = new ArrayList();
        for(int row = 0; row < grid.size(); row++){
            List<Integer> rowValues = new ArrayList();
            for(int column = 0; column < grid.get(0).size(); column++){
                if(grid.get(row).get(column) == 'W' || (grid.get(row).get(column) == 'O' && resultGridArray[row][column] == 0)){
                    rowValues.add(-1);
                }else {
                    rowValues.add(resultGridArray[row][column]);
                }
            }
            resultGridList.add(rowValues);
        }
        return resultGridList;
    }

    private static void breathFirstSearch(boolean[][] visited, List<List<Character>> grid, int[][] resultGridArray, Coordinates coordinates){
        Queue<Coordinates> queue = new LinkedList();
        queue.add(coordinates);
        visited[coordinates.row][coordinates.column] = true;
        int distance = 0;
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            distance++;
            for(int i=0; i<numberOfNodes; i++) {
                Coordinates next = queue.poll();
                List<Coordinates> neighbors = getNeighbors(grid, next);
                for (Coordinates neighbor : neighbors) {
                    if (!visited[neighbor.row][neighbor.column]) {
                        visited[neighbor.row][neighbor.column] = true;
                        if (resultGridArray[neighbor.row][neighbor.column] == 0 //first discovery
                                || distance < resultGridArray[neighbor.row][neighbor.column]) { //already discovered once
                            resultGridArray[neighbor.row][neighbor.column] = distance;
                        }
                        queue.add(neighbor);
                    }
                }
            }
        }
    }

    private static List<Coordinates> getNeighbors(List<List<Character>> grid, Coordinates coordinates){
        List<Coordinates> neighbors = new ArrayList<Coordinates>();
        if(coordinates.row-1 >= 0 && grid.get(coordinates.row-1).get(coordinates.column) == 'O')
            neighbors.add(new Coordinates(coordinates.row-1, coordinates.column));
        if(coordinates.column-1 >= 0 && grid.get(coordinates.row).get(coordinates.column-1) == 'O')
            neighbors.add(new Coordinates(coordinates.row, coordinates.column-1));
        if(coordinates.row+1 <= grid.size() - 1 && grid.get(coordinates.row+1).get(coordinates.column) == 'O')
            neighbors.add(new Coordinates(coordinates.row+1, coordinates.column));
        if(coordinates.column+1 <= grid.get(0).size() - 1 && grid.get(coordinates.row).get(coordinates.column+1) == 'O')
            neighbors.add(new Coordinates(coordinates.row, coordinates.column+1));
        return neighbors;
    }

    private static class Coordinates {
        int row;
        int column;
        Coordinates(int row, int column){
            this.row = row;
            this.column = column;
        }
    }

//    private static void printResultGridArray(int[][] resultGridArray){
//        int rows = resultGridArray.length;
//        int columns = resultGridArray[0].length;
//        for(int row = 0; row < rows; row++){
//            for(int column = 0; column < columns; column++){
//                System.out.print(resultGridArray[row][column] + ", ");
//            }
//            System.out.println();
//        }
//    }

    public static void main(String[] args){
        Character[] row0Chars = {'O', 'O', 'O', 'O', 'G'};
        List<Character> row0 = Arrays.asList(row0Chars);
        Character[] row1Chars = {'O', 'W', 'W', 'O', 'O'};
        List<Character> row1 = Arrays.asList(row1Chars);
        Character[] row2Chars = {'O', 'O', 'O', 'W', 'O'};
        List<Character> row2 = Arrays.asList(row2Chars);
        Character[] row3Chars = {'G', 'W', 'W', 'W', 'O'};
        List<Character> row3 = Arrays.asList(row3Chars);
        Character[] row4Chars = {'O', 'O', 'O', 'O', 'G'};
        List<Character> row4 = Arrays.asList(row4Chars);
        List<List<Character>> grid = new ArrayList();
        grid.add(row0);
        grid.add(row1);
        grid.add(row2);
        grid.add(row3);
        grid.add(row4);
        List<List<Integer>> resultGridList = find_shortest_distance_from_a_guard(grid);
        for(List l : resultGridList){
            System.out.println(l);
        }
        /*
            3 3 2 1 0
            2 -1 -1 2 1
            1 2 3 -1 2
            0 -1 -1 -1 1
            1 2 2 1 0
         */
    }

}
