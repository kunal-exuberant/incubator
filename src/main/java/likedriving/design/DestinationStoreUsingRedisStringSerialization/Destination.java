package likedriving.design.DestinationStoreUsingRedisStringSerialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Destination implements Serializable {
    public static int DESTINATION_ID;
    private int id;
    private String name;
    private String description;
    private Address address;

    public Destination(String name){
        this.id = ++DESTINATION_ID;
        this.name = name;
    }
}
