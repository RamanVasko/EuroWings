package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        features = "src/test/resources",
        glue = "stepdef",
//        tags = "@FLIGHT-ROUTES"
        tags = "@TAG-02-Verify-Flight-Routes")

public class Runner {
}
