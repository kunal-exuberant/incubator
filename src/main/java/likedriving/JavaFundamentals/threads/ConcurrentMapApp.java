package likedriving.JavaFundamentals.threads;

import lombok.AllArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapApp {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<String, Integer>();
/*        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new FirstConcurrentMapWorker(concurrentMap));
        executorService.submit(new SecondConcurrentMapWorker(concurrentMap));*/


        new Thread(new FirstConcurrentMapWorker(concurrentMap)).start();
        new Thread(new SecondConcurrentMapWorker(concurrentMap)).start();
    }

}

@AllArgsConstructor
class FirstConcurrentMapWorker implements Runnable{
    private ConcurrentHashMap<String, Integer> concurrentMap;

    @Override
    public void run() {
        try {
            concurrentMap.put("A", 1);
            concurrentMap.put("B", 2);
            Thread.sleep(500);
            concurrentMap.put("C", 3);
            Thread.sleep(500);
            concurrentMap.put("D", 4);
            concurrentMap.put("E", 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

@AllArgsConstructor
class SecondConcurrentMapWorker implements Runnable{
    private ConcurrentHashMap<String, Integer> concurrentMap;

    @Override
    public void run() {
        try {
            System.out.println(concurrentMap.get("A"));
            System.out.println(concurrentMap.get("B"));
            System.out.println(concurrentMap.get("C"));
            Thread.sleep(500);
            System.out.println(concurrentMap.get("D"));
            Thread.sleep(500);
            System.out.println(concurrentMap.get("E"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
