package likedriving.HelpBharat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class India extends GeographicalEntity{

    private List<State> states;

    @Builder
    public India(Integer id, String name, List<State> states){
        super(id, name, GeographicalEntityType.INDIA, GeographicalEntityType.WORLD);
        this.states = states;
    }
}
