package likedriving.CitizenIssues.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ElectoralUnit {
    private long id;
    private String name;
    private List<ElectoralIssue> issue;
    private ElectedRepresentative electedRepresentative;
}
