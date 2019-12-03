package com.algorithms.ik.sorting;

import java.util.*;

public class ThreeSumZero {

    /*
     * Complete the function below.
     */
    static String[] findZeroSum(int[] arr) {
        Map<Integer, Integer> negativeSumMap = new HashMap<Integer, Integer>();
        Set<Triplet> tripletSet = new HashSet<Triplet>();
        for(Integer i: arr){
            Integer value = negativeSumMap.get(i);
            if(value == null){
                negativeSumMap.put(i,1);
            }else{
                negativeSumMap.put(i, value + 1);
            }
        }
        for(int counter1 = 0; counter1 < arr.length; counter1++){
            for(int counter2 = counter1 + 1; counter2 < arr.length; counter2++){
                int lower = arr[counter1] <= arr[counter2] ? arr[counter1] : arr[counter2];
                int higher = arr[counter1] <= arr[counter2] ? arr[counter2] : arr[counter1];
                int negativeSum = 0 - (lower+higher);
                tripletSet.add(new Triplet(lower, higher, negativeSum));

            }
        }
        Set<Triplet> threeSumZeroSet = new HashSet<Triplet>();
        for(Triplet triplet : tripletSet){
            Integer negativeSumCount = negativeSumMap.get(triplet.getThird());
            if(negativeSumCount != null) {
                boolean addTriplet =  false;
                if (triplet.getLower() == 0 && triplet.getHigher() == 0 && negativeSumCount >= 3) {
                    addTriplet = true;
                } else if ((triplet.getLower() == triplet.getThird() || triplet.getHigher() == triplet.getThird()) && (triplet.getLower() !=0 || triplet.getHigher() != 0) && negativeSumCount >= 2) {
                    addTriplet = true;
                } else if ((triplet.getLower() != triplet.getThird() && triplet.getHigher() != triplet.getThird()) && negativeSumCount >= 1) {
                    addTriplet = true;
                }
                if(addTriplet){
                    orderTriplet(triplet);
                    threeSumZeroSet.add(triplet);
                }
            }
        }
        String[] toReturn = new String[threeSumZeroSet.size()];
        int i = 0;
        for(Triplet triplet : threeSumZeroSet){
            toReturn[i++] = triplet.getLower() + "," + triplet.getHigher() + "," + triplet.getThird();
        }
        return toReturn;
    }

    private static void orderTriplet(Triplet triplet){
        List<Integer> l = new ArrayList<Integer>();
        l.add(triplet.getLower());
        l.add(triplet.getHigher());
        l.add(triplet.getThird());
        Collections.sort(l);
        triplet.setLower(l.get(0).intValue());
        triplet.setHigher(l.get(1).intValue());
        triplet.setThird(l.get(2).intValue());
    }

    static class Triplet{
        private int lower;
        private int higher;
        private int third;


        public Triplet(int lower, int higher, int third) {
            this.lower = lower;
            this.higher = higher;
            this.third = third;
        }

        public int getLower() {
            return lower;
        }

        public void setLower(int lower) {
            this.lower = lower;
        }

        public int getHigher() {
            return higher;
        }

        public void setHigher(int higher) {
            this.higher = higher;
        }

        public int getThird() {
            return third;
        }

        public void setThird(int third) {
            this.third = third;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triplet triplet = (Triplet) o;
            return lower == triplet.lower &&
                    higher == triplet.higher &&
                    third == triplet.third;
        }

        @Override
        public int hashCode() {
            return Objects.hash(lower, higher, third);
        }


    }


    public static void main(String[] args){
        //int[] arr = {10, 3, -4, 1, -6, 9};
        int[] arr = {-1, -1, 0, 0, 1, 1};
        for(String s: findZeroSum(arr)){
            System.out.println(s);
        }

    }

}

/*


3 Sum



Problem Statement:



Given an integer array arr of size N, find all magical triplets in it.



Magical triplet is the group of 3 integers, whose sum is zero.



Note that magical triplets may or may not be made of consecutive numbers in arr.



Input/Output Format For The Function:



Input Format:



There is only one argument: integer array arr.



Output Format:



Return a string array res.

Each string in res array corresponds to a magical triplet in arr.



Note that:

Order of strings(magical triplets) in res does not matter.
Order of elements inside a magical triplet does not matter. i.e. if your output triplet have same elements, but only in different order, then it's an acceptable triplet and will lead to an acceptable solution.
There should be no duplicate triplets in res. Eg: 1,1,-2 and 1,-2,1 are duplicates.
If no such triplets are found, then return an empty array as res.


Input/Output Format For The Custom Input:



Input Format:



The first line of input should contain an integer N, denoting size of input array arr. In next N lines, ith line should contain an integer arr[i], denoting a value at index i of arr.



If N = 6 and arr = [10, 3, -4, 1, -6, 9], then input should be:



6

10

3

-4

1

-6

9



Output Format:



Let’s denote size of res as m, where res is the array of strings returned by solution function.

Then, there will be m lines of output, where ith line contains res[i], denoting value at index i of res.



For input N = 6 and arr = [10, 3, -4, 1, -6, 9], output will be:



10,-4,-6

3,-4,1



Constraints:

1 <= N <= 2000
-10^3 <= arr[i] <= 10^3, for all valid i
arr may contain duplicate numbers.
arr is not necessarily sorted.


Sample Test Case:



Sample Test Case 1:



Sample Input 1:



arr = [10, 3, -4, 1, -6, 9];



Sample Output 1:



10,-4,-6

3,-4,1



Sample Test Case 2:



Sample Input 2:



arr = [12, 34, -46];



Sample Output 2:



12,-46,34



Sample Test Case 3:



Sample Input 3:



arr = [0, 0, 0];



Sample Output 3:



0,0,0



Sample Test Case 4:



Sample Input 4:



arr = [-2, 2, 0 -2, 2];



Sample Output 4:



2,-2,0


 */
