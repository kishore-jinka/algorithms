package com.algorithms.leetcode.searching;

/**
 * 744. Find Smallest Letter Greater Than Target
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int position = getPosition(letters, target);
        //System.out.println(position);
        //edge case
        if(position > letters.length - 1){
            return letters[0];
        }else if(position == letters.length - 1){
            if(target < letters[position]){
                return letters[position];
            }else if(target == letters[position]){
                return letters[0];
            }
        }
        if(target < letters[position]) return letters[position];
        while(position <= letters.length-1 && target == letters[position]){
            position++;
        }
        if(position > letters.length -1) return letters[0];
        return letters[position];
    }

    private int getPosition(char[] letters, char target){
        int start = 0;
        int end = letters.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target == letters[mid]) return mid;
            if(target < letters[mid]) end = mid - 1;
            if(target > letters[mid]) start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args){
        //char[] letters = {'c', 'f', 'j'};
        //char target = 'k';
        char[] letters = {'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'};
        char target = 'p';
        FindSmallestLetterGreaterThanTarget findSmallestLetterGreaterThanTarget = new FindSmallestLetterGreaterThanTarget();
        System.out.println(findSmallestLetterGreaterThanTarget.nextGreatestLetter(letters, target));
    }
}

