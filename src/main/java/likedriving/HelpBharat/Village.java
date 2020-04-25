package likedriving.HelpBharat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Village extends GeographicalEntity{
    private List<ProminentPerson> prominentPersons;
    private List<ProminentPlace> prominentPlaces;

    @Builder
    public Village(Integer id, String name){
        super(id, name, GeographicalEntityType.VILLAGE, GeographicalEntityType.TEHSIL);
    }
}
