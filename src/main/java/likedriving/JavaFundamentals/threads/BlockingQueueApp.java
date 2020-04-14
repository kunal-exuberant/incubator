package likedriving.JavaFundamentals.threads;


import lombok.AllArgsConstructor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@AllArgsConstructor
class FirstWorker implements Runnable{

    private BlockingQueue<Integer> blockingQueue;

    @Override
    public void run() {

        int counter  = 0;
        while (true){
            try {
                blockingQueue.put(counter);
                System.out.println("Putting items to the queue --- "+counter);
                counter++;
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

@AllArgsConstructor
class SecondWorker implements Runnable{

    private BlockingQueue<Integer> blockingQueue;

    @Override
    public void run() {

        while (true){
            try {
                int num = blockingQueue.take();
                System.out.println("Taking items to the queue --- " + num);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class BlockingQueueApp {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        FirstWorker firstWorker = new FirstWorker(queue);
        SecondWorker secondWorker = new SecondWorker(queue);

        new Thread(firstWorker).start();
        new Thread(secondWorker).start();
    }

}
