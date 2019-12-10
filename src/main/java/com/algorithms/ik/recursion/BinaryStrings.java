package com.algorithms.ik.recursion;

public class BinaryStrings {

    public void printAllBinaryStrings(int length){
        printAllBinaryStringsRecursive(length, "");
    }

    private void printAllBinaryStringsRecursive(int length, String slate){
        if(length==0){
            System.out.println(slate);
        }else{
            printAllBinaryStringsRecursive(length-1, slate+"0");
            printAllBinaryStringsRecursive(length-1, slate+"1");
        }
    }

    public static void main(String[] args){
        BinaryStrings bs = new BinaryStrings();
        bs.printAllBinaryStrings(3);
    }
}
