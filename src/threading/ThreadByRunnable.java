package threading;

class Threading implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println("New Thread: "+Thread.currentThread().getId() + " Name: " + Thread.currentThread().getName());
        }catch (Exception e){
            System.out.println("Exception caught");
        }
    }
}

public class ThreadByRunnable {
    public static void main(String[] args) {
        int n = 8;

        System.out.println("Main Thread: "+Thread.currentThread().getId() + " Name: " + Thread.currentThread().getName());
        for (int i = 0; i < n; i++){
            Thread obj = new Thread(new Threading());
            obj.start();
        }
    }
}
