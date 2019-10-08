package com.algorithms.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeastCommonAncestor {

    int lca(Node head, Node a, Node b){
        if(head == null || a == null || b == null) return -1;
        List<Integer> pathToA = new ArrayList<Integer>();
        List<Integer> pathToB = new ArrayList<Integer>();
        if(pathToNodeExists(head, a, pathToA) && pathToNodeExists(head, b, pathToB)){
            Integer sizeToTraverse = pathToA.size() < pathToB.size() ? pathToA.size() : pathToB.size();
            Integer previous = -1;
            for(int i = 0; i < sizeToTraverse; i++){
                if(pathToA.get(i) == pathToB.get(i)){
                    previous = pathToA.get(i);
                }else{
                    return previous;
                }
            }
        }
        return -1;
    }

    boolean pathToNodeExists(Node head, Node toSearch, List<Integer> path){
        if(head == null) return false;
        path.add(head.data);
        if(head.data == toSearch.data) return true;
        if((pathToNodeExists(head.left, toSearch, path)) || (pathToNodeExists(head.right, toSearch, path))) {
            return true;
        }
        path.remove(path.size() -1);
        return false;
    }

    //Integer[] arrayA = new Integer[pathToA.size()];
    //System.out.println(Arrays.toString(pathToA.toArray(arrayA)));
    //Integer[] arrayB = new Integer[pathToB.size()];
    //System.out.println(Arrays.toString(pathToB.toArray(arrayB)));
    public static void main(String[] args){
        Node node1 = new Node();
        node1.data = 1;
        Node node2 = new Node();
        node2.data = 2;
        Node node3 = new Node();
        node3.data = 3;
        Node node4 = new Node();
        node4.data = 4;
        Node node5 = new Node();
        node5.data = 5;
        Node node6 = new Node();
        node6.data = 6;
        Node node7 = new Node();
        node7.data = 7;
        Node node8 = new Node();
        node8.data = 8;
        Node node9 = new Node();
        node9.data = 9;
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node8;
        node5.right = node9;
        node3.left = node6;
        node3.right = node7;
        LeastCommonAncestor leastCommonAncestor = new LeastCommonAncestor();
        System.out.println(leastCommonAncestor.lca(node1, node7, node9));
    }

    private static class Node {
        int data;
        Node left;
        Node right;
    }
}
