package likedriving.design.TravelDestination.models;

import lombok.Getter;

import java.util.List;

@Getter
public class RequestModel {
    private List<Type> types;
    private Duration duration;
}
