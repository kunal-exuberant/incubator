package likedriving.JavaFundamentals.threads.diningphilosopher;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class DiningPhilosopherApp {

    private static List<Philosopher> philosophers = new ArrayList<>();
    private static List<Chopstick> chopsticks = new ArrayList<>();

    public void setup(){
        for (int i = 0; i < 5; i++) {
            Philosopher philosopher = new Philosopher(i, "philosopher"+i, Activity.THINKING);
            philosophers.add(philosopher);

            Chopstick chopstick = new Chopstick(i, "chopstick"+i, true);
            chopsticks.add(chopstick);

            philosopher.setLeftChopstick(chopstick);
        }
    }

    public static void main(String[] args) {
        DiningPhilosopherApp diningPhilosopherApp = new DiningPhilosopherApp();
        diningPhilosopherApp.setup();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Chopstick leftChopstick, rightChopstick;
        for (int i = 0; i <5 ; i++) {
            if(i == 0){
                leftChopstick = chopsticks.get(4);
                rightChopstick = chopsticks.get(i+1);
            }
            else if(i == 4){
                leftChopstick = chopsticks.get(i-1);
                rightChopstick = chopsticks.get(0);
            }
            else{
                leftChopstick = chopsticks.get(i-1);
                rightChopstick = chopsticks.get(i+1);
            }
            executorService.submit(new Eating(philosophers.get(i), leftChopstick, rightChopstick));
        }
    }
}

@AllArgsConstructor
class Eating implements Runnable{

    private Philosopher philosopher;
    private Chopstick leftChopStick;
    private Chopstick rightChopstick;

    @Override
    public void run() {
        try {
            eating();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eating() throws InterruptedException {
        System.out.println(philosopher.getName() +" is trying to acquire chopsticks to eat");

        if(leftChopStick.isAvailable()) {
            leftChopStick.setAvailable(false);
            philosopher.setLeftChopstick(leftChopStick);
        }
        if(rightChopstick.isAvailable()) {
            rightChopstick.setAvailable(false);
            philosopher.setRightChopstick(rightChopstick);
        }

        if(philosopher.getLeftChopstick() != null && philosopher.getRightChopstick() != null) {
            System.out.println(philosopher.getName() + " has started eating");
            philosopher.setActivity(Activity.EATING);
            Thread.sleep(2000);

            System.out.println(philosopher.getName() + " has eaten\n");
            leftChopStick.setAvailable(true);
            rightChopstick.setAvailable(true);
            System.out.println(philosopher.getName() + " has released both chopsticks");
            philosopher.setActivity(Activity.THINKING);
        }
        else{
            System.out.println(philosopher.getName() + " is unable to acquire both chopsticks\n");
            philosopher.setActivity(Activity.THINKING);
        }
    }
}
