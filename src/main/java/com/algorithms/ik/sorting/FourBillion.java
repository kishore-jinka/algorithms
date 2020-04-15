package com.algorithms.ik.sorting;

import java.util.List;

//find a positive integer that is not there in the given list of non negative integers
public class FourBillion {

    public static long find_integer(List<Long> arr) {
        for(long i=0; i<arr.size(); i++){
            int intI = (int) i;
            if(arr.get(intI) < arr.size()) arr.set(intI, -1*arr.get(intI));
        }
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i)>0 && arr.get(i) < arr.size()) return arr.get(i);
        }
        return arr.size() + 1;
    }


}
