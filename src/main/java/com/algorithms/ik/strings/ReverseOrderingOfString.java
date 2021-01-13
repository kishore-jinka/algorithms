package com.algorithms.ik.strings;

/**
 * Reverse The Ordering Of Words In A String
 * https://oj.interviewkickstart.com/view_test_problem/6708/70/
 */
public class ReverseOrderingOfString {

    static String reverse_ordering_of_words(String s) {
        char[] array = s.toCharArray();
        int start = 0;
        int end = array.length - 1;
        reverseChars(start, end, array);
        System.out.println(new String(array));
        for(int i=0; i<array.length; i++){
            if(array[i] == ' ') continue;
            start = i;
            end = i;
            while(end < array.length - 1 && array[end] != ' '){
                end++;
            }
            if(end == array.length - 1){
                if(array[end] == ' '){
                    reverseChars(start, end - 1, array);
                }else{
                    reverseChars(start, end, array);
                }
                break;
            }else if(end < array.length - 1){
                reverseChars(start, end - 1, array);
                i = end - 1;
            }
        }
        return new String(array);
    }

    private static void reverseChars(int start, int end, char[] array) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args){
        String s = " nice.. ;;    '' aa  bb   ' ";
        System.out.println(reverse_ordering_of_words(s));
    }
}
