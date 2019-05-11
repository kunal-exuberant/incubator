package likedriving.CitizenIssues;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CitizenIssuesModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ConstituencyResources.class).in(Singleton.class);
    }
}
