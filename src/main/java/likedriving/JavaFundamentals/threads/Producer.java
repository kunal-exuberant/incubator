package likedriving.JavaFundamentals.threads;

import static java.lang.Thread.sleep;

public class Producer {


    private static  int counter = 0;

    public static void executeTask(String callerName){
        counter++;
        System.out.println(callerName+": "+counter);
    }

    public static synchronized int getCounter(){
        return counter;
    }

    public static synchronized void setCounter(int counter){
        Producer.counter = counter;
    }

    public static void increment(){
        int counter = getCounter();
        counter++;
        System.out.println(counter);
        setCounter(counter);
    }

    public static void decrement(){
        int counter = getCounter();
        counter--;
        setCounter(counter);
        System.out.println(counter);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello producer");
                //executeTask("producer");
                while (true) {
                    increment();
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        producer.start();

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello consumer");
                //executeTask("consumer");
                while (true) {
                    decrement();
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("Producer and consumer both executed");
    }
}
