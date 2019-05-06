package likedriving.CitizenIssues;

import io.dropwizard.Application;
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
    }

    @Override
    public void run(CitizenIssuesConfig configuration, Environment environment) throws Exception {
        System.out.println("Inside run method");
    }
}
