package com.algorithms.leetcode.searching;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * 162. Find Peak Element
 * https://leetcode.com/problems/find-peak-element/
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        if(nums.length == 2){
            if(nums[0] < nums [1]) return 1;
            else return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if((mid > 0 && nums[mid] > nums[mid-1] && mid < nums.length -1 && nums[mid] > nums[mid+1])
                    || (mid > 0 && nums[mid] > nums[mid-1] && mid == nums.length - 1)
                    || (mid == 0 && mid < nums.length -1 && nums[mid] > nums[mid+1])) {
                //if nums[mid] is peak return nums[mid]
                return mid;
            }else if((mid > 0 && nums[mid] < nums[mid-1] && mid < nums.length -1 && nums[mid] < nums[mid+1])
                    || (mid > 0 && nums[mid] < nums[mid-1] && mid == nums.length - 1)
                    || (mid == 0 && mid < nums.length -1 && nums[mid] < nums[mid+1])){
                //else if nums[mid] is valley start = mid + 1
                start = mid + 1;
            }else if((mid > 0 && nums[mid] > nums[mid-1] && mid < nums.length -1 && nums[mid] < nums[mid+1])
                    || (mid > 0 && nums[mid] > nums[mid-1] && mid == nums.length -1)
                    || (mid == 0 && mid < nums.length -1 && nums[mid] < nums[mid+1])){
                //else if nums[mid] is in ascending zone start = mid + 1
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {3,2,1};
        FindPeakElement findPeakElement = new FindPeakElement();
        System.out.println(findPeakElement.findPeakElement(nums));
    }
}
