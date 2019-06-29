package likedriving.design.TravelDestination;

import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TravelDestinationApp extends Application<TravelDestinationConfig> {
    public static void main(String[] args) throws Exception {
        System.out.println("Travel destination app started");
        new TravelDestinationApp().run(args);
        System.out.println("Travel destination has started");
    }

    @Override
    public void initialize(Bootstrap<TravelDestinationConfig> bootstrap) {
        System.out.println("Inside initialize method");
        //bootstrap.addBundle(new AssetsBundle("/assets", "/", "client/index.html"));

        GuiceBundle.Builder<TravelDestinationConfig> guiceBundleBuilder = GuiceBundle.newBuilder();

        GuiceBundle guiceBundle = guiceBundleBuilder
                .setConfigClass(TravelDestinationConfig.class)
                .addModule(new TravelDestinationModule())
                .build(Stage.DEVELOPMENT);
        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(TravelDestinationConfig configuration, Environment environment) throws Exception {
        System.out.println("Inside run method");
        environment.jersey().setUrlPattern("/*");
        final TravelDestinationResource travelDestinationResource = new TravelDestinationResource(new DestinationService(new DataStore()));
        environment.jersey().register(travelDestinationResource);
    }
}
