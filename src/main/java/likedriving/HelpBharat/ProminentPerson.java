package likedriving.HelpBharat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class ProminentPerson {
    private int id;
    private String name;
    private String description;
}
