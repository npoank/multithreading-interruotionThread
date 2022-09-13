package multithreading.interruptionthreads;

import java.util.Random;

public class InterruptionThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 1_000_000_000; i++) {
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("thread1 interrupt");
                        break;
                    }
                    System.out.println(Math.sin(random.nextDouble()));
                }
            }
        });
        System.out.println("Start thread1");

        thread1.start();

        Thread.sleep(100);
        thread1.interrupt();

        thread1.join();

        System.out.println("Finish thread1");
    }
}
