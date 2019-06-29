package likedriving.design.Glimpse;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TravelDestinationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TravelDestinationResource.class).in(Singleton.class);
    }
}
