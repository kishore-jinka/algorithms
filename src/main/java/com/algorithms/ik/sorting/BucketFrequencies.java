package com.algorithms.ik.sorting;

public class BucketFrequencies {

    private static void doFrequencySort(int[] a){
        int l = a.length; //N = l-1
        for(int i = 0; i<l; i++){
            int realIntValue = a[i] % l;
            a[realIntValue] = a[realIntValue] + l;
        }
        String[] frequencyBucket = new String[a.length];
        for(int i = 0; i<l; i++){
            int frequency = a[i]/l;
            if(frequency > 0){
                if(frequencyBucket[frequency] == null){
                    frequencyBucket[frequency] = Integer.toString(i);
                }else{
                    frequencyBucket[frequency] = frequencyBucket[frequency] + "," + Integer.toString(i);
                }
            }
        }
        for(int i = l-1; i>=0; i--){
            if(frequencyBucket[i] != null)
                System.out.println("Frequency of " + frequencyBucket[i] + " is " + i);
        }
    }

    public static void main(String[] args){
        int[] a = {4,2,3,3,3};
        doFrequencySort(a);
    }
}
