package likedriving.CitizenIssues.models;

import java.util.List;

public abstract class ElectoralUnit {
    private long id;
    private String name;
    private List<ElectoralIssue> issue;
    private ElectedRepresentative electedRepresentative;
}
