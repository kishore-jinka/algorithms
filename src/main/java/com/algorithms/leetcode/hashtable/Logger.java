package com.algorithms.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 359. Logger Rate Limiter
 * https://leetcode.com/problems/logger-rate-limiter/
 * https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1122/
 */
public class Logger {

    Map<String, Integer> map;

    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer previousTimeStamp = map.get(message);
        if(previousTimeStamp != null && timestamp-previousTimeStamp < 10){
            return false;
        }
        map.put(message, timestamp);
        return true;
    }

    public static void main(String[] args){
        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1, "foo")); //returns true;
        System.out.println(logger.shouldPrintMessage(2,"bar")); //returns true;
        System.out.println(logger.shouldPrintMessage(3,"foo")); //returns false;
        System.out.println(logger.shouldPrintMessage(8,"bar")); //returns false;
        System.out.println(logger.shouldPrintMessage(10,"foo")); //returns false;
        System.out.println(logger.shouldPrintMessage(11,"foo")); //returns true;
    }
}
