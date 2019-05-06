package likedriving.Glimpse;

import likedriving.Glimpse.models.Duration;
import likedriving.Glimpse.models.Type;
import lombok.Getter;

import java.util.List;

@Getter
public class RequestModel {
    private List<Type> types;
    private Duration duration;
}
