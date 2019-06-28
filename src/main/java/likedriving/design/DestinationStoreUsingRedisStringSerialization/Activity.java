package likedriving.design.DestinationStoreUsingRedisStringSerialization;

import java.io.IOException;
import java.util.Scanner;

public interface Activity {
    void addDestination(Scanner sc) throws IOException;
    void showDestinationList() throws IOException;
}
