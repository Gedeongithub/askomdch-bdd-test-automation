package runner;

import io.cucumber.junit.*;
import org.junit.runner.RunWith;
import static io.cucumber.junit.CucumberOptions.SnippetType.*;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/register.feature",
        glue = {"stepdefinitions", "hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"
        },
        monochrome = true,
        snippets = CAMELCASE


)
public class TestRunner {
}


