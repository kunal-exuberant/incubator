package likedriving.design.ParallelProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParallelProcessing {

    public static void main(String[] args){

        ExecutorService executorService =
                new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>());

        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };

        Callable<Integer> callable1 = () -> 1;



        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        executorService.execute(runnableTask);

        Future<String> future =
                executorService.submit(callableTask);


        try {
            String result = executorService.invokeAny(callableTasks);
            List<Future<String>> futures = executorService.invokeAll(callableTasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
