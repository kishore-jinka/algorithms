package com.algorithms.ik.graphs;

import java.util.*;

/**
 * String Transformation Using Given Dictionary Of Words
 * https://oj.interviewkickstart.com/view_test_problem/5370/42/
 * 25 / 30 test cases passed successfully.
 */
public class StringTransformation {

    static String[] string_transformation(String[] words, String start, String stop) {
        List<String> list = new ArrayList();
        Map<String, Boolean> visited = new HashMap();
        for(String word: words){
            list.add(word);
            visited.put(word, false);
        }
        if(!list.contains(start)) {
            list.add(start);
            visited.put(start, false);
        }
        if(!list.contains(stop)) {
            list.add(stop);
            visited.put(stop, false);
        }
        Map<String,List<String>> graph = new HashMap();
        buildGraph(list, graph);
        //printGraph(graph);
        List<String> path = bfs(graph, visited, start, stop);

        return path.toArray(new String[path.size()]);
    }

    private static List<String> bfs(Map<String,List<String>> graph, Map<String, Boolean> visited, String start, String stop){
        Queue<List<String>> queue = new LinkedList();
        List<String> list = new ArrayList();
        list.add(start);
        queue.add(list);
        int endIndex = 0;
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            for(int i=0; i<numberOfNodes; i++) {
                List<String> path = queue.poll();
                List<String> neighbors = graph.get(path.get(endIndex));
                if(neighbors != null) {
                    for (String neighbor : neighbors) {
                        if (!visited.get(neighbor)) {
                            visited.put(neighbor, true);
                            List<String> partialPath = new ArrayList(path);
                            partialPath.add(neighbor);
                            if (neighbor.equals(stop)) return partialPath;
                            queue.add(partialPath);
                        }
                    }
                }
            }
            endIndex++;
        }
        return new ArrayList<String>(Arrays.asList("-1"));
    }

    private static void buildGraph(List<String> words, Map<String,List<String>> graph){
        for(int i=0; i<words.size(); i++){
            for(int j=0; j<words.size(); j++) {
                if (i==j) continue;
                if (checkStringsDiffByOne(words.get(i), words.get(j))) {
                    if (!graph.containsKey(words.get(i))) graph.put(words.get(i), new ArrayList());
                    graph.get(words.get(i)).add(words.get(j));
                }
            }
        }
    }

    private static boolean checkStringsDiffByOne(String word1, String word2){
        int totalMatches = 0;
        for(int i=0;i<word1.length(); i++){
            if(word1.charAt(i) == word2.charAt(i)) totalMatches++;
        }
        if(totalMatches == word1.length() - 1) return true;
        return false;
    }

    private static void printGraph(Map<String,List<String>> graph){
        for(Iterator<String> i = graph.keySet().iterator(); i.hasNext();){
            String key = i.next();
            System.out.println(key + ": " + graph.get(key));
        }
    }

    public static void main(String[] args){
//        String[] words = {"cat", "hat", "bad", "had"};
//        String start = "bat";
//        String stop = "had";
        String[] words = {"cccw", "accc", "accw"};
        String start = "cccc";
        String stop = "cccc";
        String[] transformations = string_transformation(words, start, stop);
        for(String path : transformations){
            System.out.println(path);
        }
    }
}
