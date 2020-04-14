package likedriving.JavaFundamentals.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ProcessorDemo {



    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<String>> list = new ArrayList<>();

        for (int i = 0; i <5 ; i++) {
            Future<String> future = executorService.submit(new Processor());
            list.add(future);
        }

        list.forEach(a->{
            try {
                System.out.println(a.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }


}

class Processor implements Callable<String> {

    private int id = 2;

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return String.valueOf(id*id);
    }
}
