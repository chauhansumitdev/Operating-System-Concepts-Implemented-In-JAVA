package com.example;

public class SyncTwo {
    public static void main(String[] args) throws Exception {
        CountThread obj = new CountThread();

        Thread thread = new Thread(obj);
        

        CountThread obj2 = new CountThread();

        Thread thread2 = new Thread(obj2);
        
        thread2.start();
        thread.start();
        

        thread2.join();
        
        System.out.println(CountStore.getCount());

        System.out.println(thread.isAlive());
        System.out.println(thread2.isAlive());
    }
}


class CountThread implements Runnable{

    @Override
    public void run() {

        for(int i=0;i<1000;i++){
            CountStore.increment();
        }
    }

}


class CountStore{
    static int count = 0;

    static synchronized void increment(){
        count++;
    }

    static void decrement(){
        count--;
    }

    static int getCount(){
        return count;
    }
}
