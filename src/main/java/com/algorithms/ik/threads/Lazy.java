package com.algorithms.ik.threads;

public class Lazy {

    private static boolean initialized = false;

    static{
        Thread t = new Thread(new Runnable(){
            public void run(){
                System.out.println("run(): before initialized = true");
                initialized = true;
                System.out.println("run(): after initialized = true");
            }
        });
        System.out.println("before t.start");
        t.start();
        System.out.println("after t.start");
//        try{
//            System.out.println("before t.join");
//            //t.join();
//            System.out.println("after t.join");
//        }catch(InterruptedException iex){
//            throw new AssertionError(iex);
//        }
    }

    public static void main(String[] args){
        System.out.println("initialized in main():" + initialized);
    }
}
