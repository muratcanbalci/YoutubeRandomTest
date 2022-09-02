package stepDefinitions;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        format = {"json:target/cucumber.json"},
        plugin = { "pretty", "json:target/cucumber.json" },
        monochrome = true
)

public class CucumberTest {
}
