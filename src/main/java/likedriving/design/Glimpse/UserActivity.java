package likedriving.design.Glimpse;

import java.io.IOException;
import java.util.Scanner;

public interface UserActivity {
    void addDestination(Scanner sc) throws IOException;
    void showDestinationList() throws IOException;
}
