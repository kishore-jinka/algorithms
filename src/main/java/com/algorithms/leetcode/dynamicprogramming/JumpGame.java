package com.algorithms.leetcode.dynamicprogramming;

/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3310/
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length == 0) return false;
        if(nums.length == 1) return true;
        boolean[] visited = new boolean[nums.length];
        visited[0] = true;
        for(int i=1; i<nums.length; i++){
            int j = i-1;
            while (j>=0){
                visited[i] = (i-j <= nums[j]) && visited[j];
                if(visited[i]) break;
                j--;
            }
        }
        return visited[nums.length-1];
    }

    public static void main(String[] args){
        int[] nums = {1,0,2,0,4};
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(nums));
    }
}
