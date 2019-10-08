package com.algorithms.trees;

/**
 * Print the longest route in a tree
 */
public class TreeDiameter {

    public Integer findLongestRoute(Node rootNode){
        return 0;
    }

    class Node{
        private Node left;
        private Node right;
        private Integer leftChildDistance;
        private Integer rightChildDistance;

        public Node(Node left, Node right, Integer leftChildDistance, Integer rightChildDistance) {
            this.left = left;
            this.right = right;
            this.leftChildDistance = leftChildDistance;
            this.rightChildDistance = rightChildDistance;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public Integer getLeftChildDistance() {
            return leftChildDistance;
        }

        public Integer getRightChildDistance() {
            return rightChildDistance;
        }
    }
}
