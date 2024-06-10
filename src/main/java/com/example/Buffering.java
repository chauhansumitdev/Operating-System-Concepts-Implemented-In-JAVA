package com.example;
import java.util.*;

public class Buffering {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Thread thread = new Thread(buffer);

        Scanner obj = new Scanner(System.in);

        thread.start();
        
        try{
            int val = obj.nextInt();
            thread.interrupt();
        }catch(Exception e){
            System.out.println("exit...");
        }

        obj.close();
    }
}

class Buffer implements Runnable{

    @Override
    public void run() {

        StringBuilder sb = new StringBuilder("---");

        int index = 0;
        try{
            while(true){
                System.out.print("\033[H\033[2J");
                System.out.flush();

                if(index > 3){
                    index = 0;
                }
                sb.insert(index, ">");
               
                System.out.print("downloading: "+ sb.toString());
                sb.deleteCharAt(index);
                index++;
                Thread.sleep(50);
            }
        }catch(Exception e){
            System.out.println("exit...");
        }
    }
}
