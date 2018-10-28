package threading;

class MultiThread extends Thread{
    public void run(){
        try{
            System.out.println("Thread "+Thread.currentThread().getId()+" is running.");
        }catch (Exception e){
            System.out.println("Exception is caught");
        }
    }
}


public class MultiThreadingDemo {

    public static void main(String[] args){
        int n = 8;

        for(int i = 0; i < 8; i++){
            MultiThread m = new MultiThread();
            m.start();
        }
    }
}
