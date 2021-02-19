package com.algorithms.google.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the best apartment block to select to you can walk the least to avail the
 * facilities.  In the above example it is block 3
     Blocks=[
         {
            "gym": false,
            "school": true,
            "store": false
         }
         {
             "gym": true,
             "school": false,
             "store": false
         }
         {
             "gym": true,
             "school": true,
             "store": false
         }
         {
             "gym": false,
             "school": true,
             "store": false
         }
         {
             "gym": false, 2
             "school": true, 0
             "store": true 0
         }
     ]
 */
public class BlockSelection {
    public int getBestBlockIndex(List<Block> blockList){
        int minDistance = Integer.MAX_VALUE;
        int bestBlockIndex = -1;
        int[][] distances = new int[blockList.size()][3];
        Block block0 = blockList.get(0);
        distances[0][0] = block0.gym ? 0 : Integer.MAX_VALUE;
        distances[0][1] = block0.school ? 0 : Integer.MAX_VALUE;
        distances[0][2] = block0.store ? 0 : Integer.MAX_VALUE;
        for(int i=1; i<blockList.size(); i++){
            distances[i][0] = blockList.get(i).gym ? 0 : distances[i-1][0] == Integer.MAX_VALUE ? Integer.MAX_VALUE : distances[i-1][0] + 1;
            distances[i][1] = blockList.get(i).school ? 0 : distances[i-1][1] == Integer.MAX_VALUE ? Integer.MAX_VALUE : distances[i-1][1] + 1;
            distances[i][2] = blockList.get(i).store ? 0 : distances[i-1][2] == Integer.MAX_VALUE ? Integer.MAX_VALUE : distances[i-1][2] + 1;
        }
        int blockMaxDistance0 = getMinDistance(distances[blockList.size() - 1][0], distances[blockList.size() - 1][1], distances[blockList.size() - 1][2]);
        if(blockMaxDistance0 < minDistance){
            minDistance = blockMaxDistance0;
            bestBlockIndex = blockList.size() - 1;
        }
        for(int i=blockList.size()-2; i>=0; i--){
            if(!blockList.get(i).gym && distances[i+1][0] < distances[i][0]) distances[i][0] = distances[i+1][0] + 1;
            if(!blockList.get(i).gym && distances[i+1][1] < distances[i][1]) distances[i][1] = distances[i+1][1] + 1;
            if(!blockList.get(i).gym && distances[i+1][2] < distances[i][2]) distances[i][2] = distances[i+1][2] + 1;
            int blockMaxDistance = getMinDistance(distances[i][0], distances[i][1], distances[i][2]);
            if(blockMaxDistance < minDistance){
                minDistance = blockMaxDistance;
                bestBlockIndex = i;
            }
        }
        return bestBlockIndex;
    }

    private int getMinDistance(int a, int b, int c){
        int min = Math.max(a, b);
        min = Math.max(min, c);
        return min;
    }

    public static void main(String[] args){
        List<Block> blockList = new ArrayList();
        Block block0 = new Block(false, true, false);
        Block block1 = new Block(true, false, false);
        Block block2 = new Block(true, true, false);
        Block block3 = new Block(false, true, false);
        Block block4 = new Block(false, true, true);
        blockList.add(block0);
        blockList.add(block1);
        blockList.add(block2);
        blockList.add(block3);
        blockList.add(block4);
        BlockSelection bs = new BlockSelection();
        int result = bs.getBestBlockIndex(blockList);
        String resultString = "Test Case1 with result " + result;
        System.out.println(result == 3 ? "Pass " + resultString : "Failed " + resultString);
    }

    static class Block{
        private boolean gym;
        private boolean school;
        private boolean store;
        Block(boolean gym, boolean school, boolean store){
            this.gym = gym;
            this.school = school;
            this.store = store;
        }
    }
}

/*
Blocks=[
    { //block 0
        "gym": false, MAX_VALUE, 1
        "school": true, 0, 0
        "store": false MAX_VALUE, 4
    } //max distance 4
     { //block 1
         "gym": true, 0, 0
         "school": false, 1, 1
         "store": false MAX_VALUE, 3
     }//max distance 3
     { //block 2
         "gym": true, 0, 0
         "school": true, 0, 0
         "store": false MAX_VALUE, 2
     }//max distance 2
     { //block 3
         "gym": false, 1, 1
         "school": true, 0, 0
         "store": false MAX_VALUE, 1
     }//max distance 1
     { //block 4
         "gym": false, 2
         "school": true, 0
         "store": true 0
     }//max distance 2
 ]
 */