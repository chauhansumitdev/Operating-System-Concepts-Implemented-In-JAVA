package com.example;

import java.util.*;

public class ProducerConsumer {
    public static void main(String[] args) {
        BufferStore buffer = new BufferStore(5);

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        Thread p = new Thread(producer);
        Thread c = new Thread(consumer);

        p.start();
        c.start();


    }
}







class Producer implements Runnable{

    BufferStore buffer;

    Producer(BufferStore buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int value = 0 ;

        while(true){
            try{
                if(buffer.capacity == value){
                    value = 0;
                }
                System.out.println(value);
                buffer.produce(value++);
                Thread.sleep(500);
            }catch(Exception e){

            }
        }
    }

}






class Consumer implements Runnable{

    BufferStore buffer;

    Consumer(BufferStore buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try{
                int value = buffer.consume();
                Thread.sleep(1000);
                System.out.println(value);
            }catch(Exception e){

            }
        }
    }

}








class BufferStore{
    Queue<Integer> buffer = new LinkedList<>();
    int capacity;

    BufferStore(int capacity){
        this.capacity=capacity;
    }

    synchronized void produce(int value) throws Exception{
        while(buffer.size() == capacity){
            wait();
        }
        buffer.add(value);
        notifyAll();
    }

    synchronized int consume() throws Exception{
        while(buffer.isEmpty()){
            wait();
        }
        int value = buffer.poll();
        notifyAll();
        return value;
    }
}