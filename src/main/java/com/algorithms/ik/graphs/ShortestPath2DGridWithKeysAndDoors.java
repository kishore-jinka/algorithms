package com.algorithms.ik.graphs;

import java.util.*;

/**
 * Shortest Path In 2D Grid With Keys And Doors
 * https://oj.interviewkickstart.com/view_test_problem/5370/119/
 * 7 / 30 test cases passed successfully.
 * 23/30 test cases timed out.
 * Need to improve algorithm so that the timeout cases work well.
 * Otherwise logic is not bad.
 */
public class ShortestPath2DGridWithKeysAndDoors {

    static int[][] find_shortest_path(String[] grid) {
        char[][] graph = new char[grid.length][grid[0].length()];
        boolean startFound = false;
        Coordinates start = null;
        for(int row=0; row<grid.length; row++){
            for(int column=0; column<grid[0].length(); column++){
                graph[row][column] = grid[row].charAt(column);
                if(!startFound && graph[row][column] == '@') {
                    start = new Coordinates(row, column);
                    startFound = true;
                }
            }
        }
        //printGraphAndStart(graph, start);
        List<Coordinates> path = bfs(graph, start);
        int[][] toReturn = new int[path.size()][2];
        for(int i = 0; i < path.size(); i++){
            toReturn[i][0] = path.get(i).row;
            toReturn[i][1] = path.get(i).column;
        }
        return toReturn;
    }

    private static List<Coordinates> bfs(char[][] graph, Coordinates start){
        Queue<PathAndDoorKeys> queue = new LinkedList();
        PathAndDoorKeys startPathAndDoorKeys = new PathAndDoorKeys();
        startPathAndDoorKeys.path = new ArrayList();
        startPathAndDoorKeys.path.add(start);
        startPathAndDoorKeys.doorKeys = new HashMap();
        queue.add(startPathAndDoorKeys);
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            for(int i=0; i<numberOfNodes; i++) {
                PathAndDoorKeys pathAndDoorKeys = queue.poll();
                List<Coordinates> neighbors = getNeighbors(graph, pathAndDoorKeys.path.get(pathAndDoorKeys.path.size() - 1));
                if(neighbors != null) {
                    for (Coordinates neighbor : neighbors) {
                        Character c = graph[neighbor.row][neighbor.column];
                        if(c == '+'){
                            pathAndDoorKeys.path.add(neighbor);
                            return pathAndDoorKeys.path;
                        }
                        Map<Character, Integer> newDoorKeys = new HashMap<>(pathAndDoorKeys.doorKeys);
                        if(Character.isLetter(c)){
                            char lowerC = Character.toLowerCase(c);
                            if(newDoorKeys.get(lowerC) == null) newDoorKeys.put(lowerC, 0);
                            if(Character.isUpperCase(c)){
                                if(newDoorKeys.get(lowerC) < 1){
                                    continue;
                                }else{
                                    newDoorKeys.put(lowerC, newDoorKeys.get(lowerC) - 1);
                                }
                            }else{
                                newDoorKeys.put(lowerC, newDoorKeys.get(lowerC) + 1);
                            }
                        }
                        PathAndDoorKeys newPathAndDoorKeys = new PathAndDoorKeys();
                        newPathAndDoorKeys.doorKeys = newDoorKeys;
                        newPathAndDoorKeys.path = new ArrayList(pathAndDoorKeys.path);
                        newPathAndDoorKeys.path.add(neighbor);
                        queue.add(newPathAndDoorKeys);
                    }
                }
            }
        }
        List<Coordinates> defaultList = new ArrayList();
        return defaultList;
    }

    private static List<Coordinates> getNeighbors(char[][] grid, Coordinates coordinates){
        List<Coordinates> neighbors = new ArrayList<Coordinates>();
        if(coordinates.row-1 >= 0 && grid[coordinates.row-1][coordinates.column] != '#')
            neighbors.add(new Coordinates(coordinates.row-1, coordinates.column));
        if(coordinates.column-1 >= 0 && grid[coordinates.row][coordinates.column-1] != '#')
            neighbors.add(new Coordinates(coordinates.row, coordinates.column-1));
        if(coordinates.row+1 <= grid.length - 1 && grid[coordinates.row+1][coordinates.column] != '#')
            neighbors.add(new Coordinates(coordinates.row+1, coordinates.column));
        if(coordinates.column+1 <= grid[0].length - 1 && grid[coordinates.row][coordinates.column+1] != '#')
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

    private static class PathAndDoorKeys{
        List<Coordinates> path;
        Map<Character, Integer> doorKeys;
    }

    private static void printGraphAndStart(char[][] graph, Coordinates start){
        for(int row=0; row<graph.length; row++){
            System.out.println(graph[row]);
        }
        System.out.println("Start: " + start.row + ", " + start.column);
    }

    public static void main(String[] args){
        String[] grid = {"c.CB", ".b#.", "@#+."};
        int[][] path = find_shortest_path(grid);
        for(int row=0; row<path.length; row++){
            System.out.println(path[row][0]+","+path[row][1]);
        }
    }
}
