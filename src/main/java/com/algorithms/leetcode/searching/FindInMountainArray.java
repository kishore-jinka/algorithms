package com.algorithms.leetcode.searching;

/**
 * 1095. Find in Mountain Array
 * https://leetcode.com/problems/find-in-mountain-array/
 * //TODO: INCOMPLETE
 */
public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeak(mountainArr);
        if(peakIndex == -1) return -1;
        if(mountainArr.get(peakIndex) == target) return peakIndex;
        int frontIndex = findTargetInIncreasingSequence(target, 0, peakIndex-1, mountainArr);
        if(frontIndex != -1) return frontIndex;
        int rearIndex = findTargetInDecreasingSequence(target, peakIndex+1, mountainArr.length() -1, mountainArr);
        return rearIndex;
    }

    private int findPeak(MountainArray mountainArr){
        int start = 0;
        int end = mountainArr.length() - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mountainArr.get(mid) > mountainArr.get(mid-1)
                    && mountainArr.get(mid) > mountainArr.get(mid+1)){
                return mid;
            }else if(mountainArr.get(mid) > mountainArr.get(mid-1)){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }

    private int findTargetInIncreasingSequence(int target, int start, int end, MountainArray mountainArr){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mountainArr.get(mid) == target){
                return mid;
            }else if(mountainArr.get(mid) < target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }

    private int findTargetInDecreasingSequence(int target, int start, int end, MountainArray mountainArr){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mountainArr.get(mid) == target){
                return mid;
            }else if(mountainArr.get(mid) < target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        FindInMountainArray findInMountainArray = new FindInMountainArray();
        System.out.println(findInMountainArray.findInMountainArray(1, new MountainArray()));
    }

    private static class MountainArray {
        private int[] array = {0,5,3,1};
        int get(int index){
            return array[index];
        }
        int length(){
            return 4;
        }
    }
}
