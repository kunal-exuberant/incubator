package likedriving.HelpBharat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class State extends GeographicalEntity{

    private List<District> districts;

    @Builder
    public State(Integer id, String name, List<District> districts){
        super(id, name, GeographicalEntityType.STATE, GeographicalEntityType.INDIA);
        this.districts = districts;
    }
}
