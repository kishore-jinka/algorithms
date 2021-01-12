package com.algorithms.ik.graphs;

import java.util.*;

/**
 * Find Order Of Characters From Alien Dictionary
 * https://oj.interviewkickstart.com/view_test_problem/5485/38/
 */
public class OrderOfCharactersFromAlienDictionary {

    private static int time = 0;
    static String find_order(String[] words) {
        if(words.length == 1){
            if(words[0].length() == 1){
                return words[0];
            }else if(words[0].length() > 1){
                for(int i=1; i<words[0].length(); i++){
                    if(words[0].charAt(0) != words[0].charAt(i)) return null;
                    return words[0].substring(0,1);
                }
            }
        }
        Map<Character, List<Character>> graph = new HashMap();
        for(int i=0; i<words.length-1; i++){
            int length = words[i].length();
            if(words[i+1].length() < length) length = words[i+1].length();
            for(int j=0; j<length; j++){
                if(words[i].charAt(j) != words[i+1].charAt(j)){
                    if(graph.get(words[i].charAt(j)) == null) graph.put(words[i].charAt(j), new ArrayList<Character>());
                    graph.get(words[i].charAt(j)).add(words[i+1].charAt(j));
                    break;
                }
                //in case both words are same like aaaa, aaaa then we should add a to the graph
                if(j==length-1){
                    if(graph.get(words[i].charAt(j)) == null) graph.put(words[i].charAt(j), new ArrayList<Character>());
                }
            }
        }
        //printGraph(graph);
        Map<Character, Boolean> visited = new HashMap();
        Map<Character, Integer> arrived = new HashMap();
        Map<Character, Integer> departed = new HashMap();
        TreeMap<Integer, Character> treeMap = new TreeMap();
        Set<Character> keySet = graph.keySet();
        for(Iterator<Character> i = keySet.iterator(); i.hasNext();){
            Character letter = i.next();
            if(visited.get(letter) == null || !visited.get(letter)){
                depthFirstSearch(visited, arrived, departed, graph, letter, treeMap);
            }
        }
        Iterator<Character> iterator = treeMap.values().iterator();
        StringBuilder toReturn = new StringBuilder();
        while(iterator.hasNext()){
            toReturn.append(iterator.next());
        }
        return toReturn.toString();
    }

    private static void depthFirstSearch(Map<Character, Boolean> visited, Map<Character, Integer> arrived, Map<Character, Integer> departed, Map<Character, List<Character>> graph, Character letter, TreeMap<Integer, Character> treeMap){
        if(visited.get(letter) == null || !visited.get(letter)){
            //Update visited to true
            visited.put(letter, true);
            //Update arrived time for the course
            arrived.put(letter, time++);
            if(graph.get(letter) != null) {
                for (Character c : graph.get(letter)) {
                    depthFirstSearch(visited, arrived, departed, graph, c, treeMap);
                }
            }
            //Update departed time for the course
            departed.put(letter, time++);
            //Reverse topological sort based on departed times
            treeMap.put(0-departed.get(letter), letter);
        }
    }

    private static void printGraph(Map<Character, List<Character>> graph){
        for(Iterator<Character> i = graph.keySet().iterator(); i.hasNext();){
            Character key = i.next();
            System.out.println(key + ": " + graph.get(key));
        }
    }

    public static void main(String[] args){
        //String[] input = {"baa", "abcd", "abca", "cab", "cad"};
        String[] input = {"g", "g", "g", "g"};
        String output = find_order(input);
        System.out.println("output: " + output);
    }
}
