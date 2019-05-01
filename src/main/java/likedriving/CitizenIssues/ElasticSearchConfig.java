package likedriving.CitizenIssues;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
public class ElasticSearchConfig implements Serializable {
    @JsonProperty
    @NotNull
    String host;

    @JsonProperty
    int port;

    @JsonProperty
    @NotNull
    String clusterName;
}
