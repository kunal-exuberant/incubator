package likedriving.JavaFundamentals.threads;

import lombok.AllArgsConstructor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LatchDemo {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
    }

}

@AllArgsConstructor
class LatchWorker implements Runnable{


    private int id;
    private CountDownLatch countDownLatch;

    @Override
    public void run() {
        countDownLatch.countDown();
    }
}
