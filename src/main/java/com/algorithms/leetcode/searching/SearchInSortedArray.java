package com.algorithms.leetcode.searching;

/**
 * 702. Search in a Sorted Array of Unknown Size
 * https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
 */
public class SearchInSortedArray {
    public int search(ArrayReader reader, int target) {
        int start = 0;
        int end = 1;
        while(reader.get(end) < target){
            end = end * 2;
        }
        start = end/2;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(reader.get(mid) == target) return mid;
            if(reader.get(mid) < target) start = mid + 1;
            if(reader.get(mid) > target) end = mid - 1;
        }
        return -1;
    }
}

interface ArrayReader {
    public int get(int index);
}
