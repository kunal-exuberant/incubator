package likedriving.design.TravelDestination;

import java.io.IOException;
import java.util.Scanner;

public interface UserActivity {
    void addDestination(Scanner sc) throws IOException;
    void showDestinationList() throws IOException;
}
