package likedriving.CitizenIssues;

import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class CitizenIssuesService extends Application<CitizenIssuesConfig> {
    public static void main(String[] args) throws Exception {
        System.out.println("Citizen Service started");
        new CitizenIssuesService().run(args);
    }

    @Override
    public void initialize(Bootstrap bootstrap) {
        System.out.println("Inside initialize method");
        bootstrap.addBundle(new AssetsBundle("/assets", "/", "client/index.html"));
        //bootstrap.addBundle(new RequestContextBundle("/*"));

        GuiceBundle guiceBundle = GuiceBundle.newBuilder()
                .addModule(new CitizenIssuesModule())
                .build();
        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(CitizenIssuesConfig configuration, Environment environment) throws Exception {
        System.out.println("Inside run method");
    }
}
