package com.algorithms.leetcode.searching;

/**
 * 278. First Bad Version
 * https://leetcode.com/problems/first-bad-version/
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3316/
 */
public class FirstBadVersion extends VersionControl{
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start < end){
            int mid = start/2 + end/2;
            if(start%2 == 1 && end%2 == 1) mid = mid + 1;
            if(isBadVersion(mid)){ // bad version is between start and mid
                end = mid;
            }else{ // bad version is between mid and end
                start = mid+1;
            }
        }
        return start;
    }

    public static void main(String[] args){
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        System.out.println(firstBadVersion.firstBadVersion(2126753390));
    }
}

/**
 * VersionControl is implemented in custom way.
 * The actual implementation is with leetcode.
 */
class VersionControl{
    boolean isBadVersion(int version){
        if(version >= 1702766719) return true;
        return false;
    }
}
