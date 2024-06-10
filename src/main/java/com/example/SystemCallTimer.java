package com.example;

import java.time.LocalTime;
//
//public class SystemCallTimer {
//    public static void main(String[] args) {
//        long startTime = System.nanoTime();
//        // Your program logic here
//        long endTime = System.nanoTime();
//
//        long elapsedTime = endTime - startTime;
//        System.out.println("Time taken for program execution: " + elapsedTime + " nanoseconds");
//
//        System.out.println(LocalTime.now());
//
//        long resumeTime = System.nanoTime();
//        long systemCallTime = resumeTime - endTime;
//        System.out.println("Time taken for system call: " + systemCallTime + " nanoseconds");
//    }
//}


public class SystemCallTimer {
    public static void main(String[] args) {

        // storing the time before running the loop
        long startTime = System.nanoTime();
        System.out.println(startTime+" nanoseconds");

        for (int i = 0; i < 1000000; i++) {
            // Wasting time :) I mean counting!!
        }

        // storing the time after running the loop
        long endTime = System.nanoTime();
        System.out.println(endTime+ " nanoseconds");

        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time: " + elapsedTime + " nanoseconds");
    }
}


