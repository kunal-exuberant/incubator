package likedriving.HelpBharat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
public class UnionTerritory extends GeographicalEntity{

    private List<District> districts;

    @Builder
    public UnionTerritory(Integer id, String name){
        super(id, name, GeographicalEntityType.UNION_TERRITORY, GeographicalEntityType.INDIA);
    }
}
