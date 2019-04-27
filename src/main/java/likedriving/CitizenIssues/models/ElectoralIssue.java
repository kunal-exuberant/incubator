package likedriving.CitizenIssues.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
public class ElectoralIssue {
    private long id;
    @Min(5)
    @Max(50)
    private String title;

    @Min(10)
    @Max(200)
    private String description;
    private long SupportingVotes = -1;
    private User createdBy;
}
