package com.algorithms.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 249. Group Shifted Strings
 * https://leetcode.com/problems/group-shifted-strings/
 * https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1125/
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> listOfLists = new ArrayList();
        if(strings.length == 0) return listOfLists;
        Map<Couple, List<String>> map = new HashMap();
        for(int i=0; i<strings.length; i++){
            if(strings[i].length() == 0) continue;
            StringBuilder sb = new StringBuilder();
            if(strings[i].length() > 1){
                char[] chars = strings[i].toCharArray();
                for(int j=1; j<chars.length; j++){
                    int diff = chars[j] - chars[j-1];
                    if(diff > 0){
                        sb.append(diff);
                    }else{
                        sb.append(26 + diff);
                    }
                    if(j<chars.length-1) sb.append("|");
                }

            }else if(strings[i].length() == 1){
                sb.append("-");
            }
            Couple c = new Couple(strings[i].length(), sb.toString());
            if(map.get(c) == null){
                List<String> list = new ArrayList();
                map.put(c, list);
            }
            map.get(c).add(strings[i]);
        }
        listOfLists.addAll(map.values());
        return listOfLists;
    }

    private class Couple{
        int length;
        String pattern;
        Couple(int length, String pattern){
            this.length = length;
            this.pattern = pattern;
        }

        public boolean equals(Object obj){
            Couple c = (Couple) obj;
            if(this.pattern.equals(c.pattern) && this.length == c.length) return true;
            return false;
        }

        public int hashCode(){
            return 31*(this.pattern.length() + this.length);
        }
    }

    public static void main(String[] args) {
        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        GroupShiftedStrings groupShiftedStrings = new GroupShiftedStrings();
        List<List<String>> listOfLists = groupShiftedStrings.groupStrings(strings);
        for (List<String> stringList : listOfLists) {
            System.out.println(stringList);
        }

    }
}
