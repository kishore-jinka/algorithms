package com.algorithms.ik.recursion;

/* "127001" --> all valid IP addresses

1. 0 & 255 (inclusive)
2. should have 4 octets, separated by 3 "."
3. should be prefixed by 0 : so, 01. is not ok, 0 is okay. (0.0.0.0 is a valid IP)

*/

public class CheckIPAddresses {

    public static void checkIPAddress(String input){
        recursiveCheckAndPrint(input, "", 0, 0);
    }


    private static void recursiveCheckAndPrint(String input, String ipString, int index, int breaks){
        if(index == input.length() && breaks == 4){
            System.out.println(ipString.substring(1));
        }else if(index == input.length() && breaks < 4){
            return;
        }else if(index < input.length() && breaks < 4){
            if(index+1 <= input.length()){
                String s1 =  input.substring(index, index+1);
                recursiveCheckAndPrint(input, ipString + "." + s1, index+1, breaks + 1);
            }
            if(input.charAt(index) != '0'){
                if(index+2<=input.length()){
                    String s2 = input.substring(index, index+2);
                    recursiveCheckAndPrint(input, ipString + "." + s2, index+2, breaks + 1);
                }
                if(index+3<=input.length()){
                    String s3 = input.substring(index, index+3);
                    if(Integer.parseInt(s3) <=255){
                        recursiveCheckAndPrint(input, ipString + "." +s3, index+3, breaks + 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        checkIPAddress("127001");
    }

}








