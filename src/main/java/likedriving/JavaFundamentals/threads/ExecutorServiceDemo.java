package likedriving.JavaFundamentals.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executorService.submit(new Worker());
        }
    }
}


class Worker implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <5 ; i++) {
            try {
                System.out.println(i);
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
