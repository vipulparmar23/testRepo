package threading;

public class TestThread implements Runnable {


    public static void main(String[] args) {
        Thread t = new Thread(new TestThread());
        t.start();
        try {
            t.join(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Joining after 1000ms: ");
        System.out.println("Current thread: "+t.getName());
        System.out.println("Is Alive? :"+t.isAlive());
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("Current thread: "+t.getName());
        System.out.println("is Alive? :"+t.isAlive());
    }
}
