package likedriving.JavaFundamentals.threads.diningphilosopher;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Philosopher {
    private int id;
    private String name;
    private Activity activity;
    private Chopstick leftChopstick;
    private Chopstick rightChopstick;

    public Philosopher(int id, String name, Activity activity){
        this.id = id;
        this.name = name;
        this.activity = activity;
    }
}
