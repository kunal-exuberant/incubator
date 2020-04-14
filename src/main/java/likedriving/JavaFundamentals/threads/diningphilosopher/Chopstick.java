package likedriving.JavaFundamentals.threads.diningphilosopher;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Chopstick {
    private int id;
    private String name;
    private boolean available = true;

    public synchronized boolean isAvailable(){
        return this.available;
    }

    public synchronized void setAvailable(boolean available){
        this.available = available;
    }
}
