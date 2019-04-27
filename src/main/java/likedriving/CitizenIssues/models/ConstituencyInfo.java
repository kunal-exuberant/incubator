package likedriving.CitizenIssues.models;

import lombok.Getter;
import java.util.List;

@Getter
public class ConstituencyInfo {
    private Constituency constituencyDetails;
    private List<ElectoralIssue> electoralIssues;
}
