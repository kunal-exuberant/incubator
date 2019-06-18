package likedriving.design.DestinationStore;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class DestinationStore implements Serializable {
    static List<Destination> destinationStore = new ArrayList<>();
}
