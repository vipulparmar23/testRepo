package threading;

import java.util.LinkedList;

public class PCExampleClass {

    public static void main(String[] args) throws InterruptedException{
        // Object of a class that has both produce and consume methods

        final PC pc = new PC();

        // Create a producer thread
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try{
                    pc.produce();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    pc.consume();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // t1 finishes before t2
        t1.join();
        t2.join();


    }

}

class PC{
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 2;

    public void produce() throws InterruptedException{
        int value = 0;

        while(true){
            synchronized (this){
                // producer thread waits while list is full

                while(list.size() == capacity)
                    wait();
                System.out.println("Producer Produced: "+value);

                list.add(value++);

                // Notify the consumer thread that it can start consuming
                notify();

                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException{
        while(true){
            synchronized (this){
                // wait if list is empty
                while(list.size() == 0)
                    wait();

                int val = list.removeFirst();

                System.out.println("Consumer consumed: "+val);

                notify();

                Thread.sleep(1000);
            }
        }
    }
}