package stepDefinitions;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"stepDefinitions","PageObjectModel","utilities"},
        plugin = {"pretty","html:target/cucumber-html-report","json:target/cucumber.json"},
        monochrome = true,
        dryRun = true,
        tags = ("@Duplicate")
)

public class CucumberTest {
}
