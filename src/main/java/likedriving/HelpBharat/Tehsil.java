package likedriving.HelpBharat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
public class Tehsil extends GeographicalEntity{

    private List<Village> villages;

    @Builder
    public Tehsil(Integer id, String name){
        super(id, name, GeographicalEntityType.TEHSIL, GeographicalEntityType.DISTRICT);
    }
}
