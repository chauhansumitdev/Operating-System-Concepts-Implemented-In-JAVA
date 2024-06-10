package com.example;
import java.util.*;

public class MultiThreaded {
    public static void main(String[] args){

        System.out.print("entry : main");

        SmallThread smallThread = new SmallThread();

        Thread thread = new Thread(smallThread);

        thread.start();

        try{
            thread.join();
            // wait for the thread to finish execution before continuing current thread;
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.print("exit : main");

    }
}

class SmallThread implements Runnable{
    @Override
    public void run() {

        System.out.print("entry : thread");

        try{
            while (true){
                Scanner obj = new Scanner(System.in);
                int val = obj.nextInt();
                if(val == 1){
                    System.out.println("sleeping :<>");
                    Thread.sleep(2000);
                    System.out.print("i am back :D");
                }else if(val == 2){
                    System.out.print(":)");
                }else if(val == 3){
                    System.out.println("See ya !!");
                    System.out.println("exit : thread");
                    return;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
