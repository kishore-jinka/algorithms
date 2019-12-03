package com.algorithms.others.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class KnapSack {


    private static int recurssiveKnapSack(List<Item> items, int itemsSize, int maxWeight) {
        int result = 0;
        if (itemsSize == 0 || maxWeight == 0) {
            result = 0;
        } else if (items.get(itemsSize - 1).getWeight() > maxWeight) {
            result = recurssiveKnapSack(items, itemsSize - 1, maxWeight);
        } else {
            int tmp1 = recurssiveKnapSack(items, itemsSize - 1, maxWeight);
            int tmp2 = items.get(itemsSize - 1).getValue() + recurssiveKnapSack(items, itemsSize - 1, maxWeight - items.get(itemsSize - 1).getWeight());
            result = Math.max(tmp1, tmp2);
        }
        return result;
    }

    private static int dynamicKnapSack(List<Item> items, int itemsSize, int maxWeight, int[][] ksArray) {
        if(ksArray[itemsSize-1][maxWeight-1] > -1) return ksArray[itemsSize][maxWeight];
        int result = 0;
        if (itemsSize == 0 || maxWeight == 0) {
            result = 0;
        } else if (items.get(itemsSize - 1).getWeight() > maxWeight) {
            result = recurssiveKnapSack(items, itemsSize - 1, maxWeight);
        } else {
            int tmp1 = recurssiveKnapSack(items, itemsSize - 1, maxWeight);
            int tmp2 = items.get(itemsSize - 1).getValue() + recurssiveKnapSack(items, itemsSize - 1, maxWeight - items.get(itemsSize - 1).getWeight());
            result = Math.max(tmp1, tmp2);
        }
        ksArray[itemsSize-1][maxWeight-1] = result;
        return result;
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item(1, 5));
        items.add(new Item(2, 3));
        items.add(new Item(4, 5));
        items.add(new Item(2, 3));
        items.add(new Item(5, 2));
        int maxWeight = 10;
        //System.out.println(recurssiveKnapSack(items, items.size(), maxWeight));
        int[][] ksArray = initializeDoubleArray(items.size(),maxWeight);
        System.out.println(dynamicKnapSack(items, items.size(), maxWeight, ksArray));
    }

    private static int[][] initializeDoubleArray(int a, int b){
        int[][] intArray = new int[a][b];
        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                intArray[i][j] = -1;
            }
        }
        return intArray;
    }

    static class Item {

        private final int weight;
        private final int value;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        int getWeight() {
            return weight;
        }

        int getValue() {
            return value;
        }
    }
}


