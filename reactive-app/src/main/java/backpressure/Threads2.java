package backpressure;

import java.util.Date;
import java.util.concurrent.SynchronousQueue;

public class Threads2 {

    public static void main(String[] args) {
        SynchronousQueue<Date> queue = new SynchronousQueue<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    queue.offer(new Date());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    try {
                        System.out.println(queue.take());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }
}
