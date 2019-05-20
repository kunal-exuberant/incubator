package likedriving.design.ParallelProcessing;

import java.util.concurrent.*;

public class ParallelProcessing {


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

//    List<Callable<String>> callableTasks = new ArrayList<>();
//        callableTasks.add(callableTask);
//        callableTasks.add(callableTask);
//        callableTasks.add(callableTask);
//
//        executorService.execute(runnableTask);
//
//    Future<String> future =
//            executorService.submit(callableTask);
//
//    String result = executorService.invokeAny(callableTasks);
//
//    List<Future<String>> futures = executorService.invokeAll(callableTasks);
}
