package backpressure;

public class Threads {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    generateData();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    consumeDate();
                }
            }
        }).start();
    }

    public static void consumeDate() {
        System.out.println("1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void generateData() {
        System.out.println("3");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
