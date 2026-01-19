package runner;

import io.cucumber.junit.*;
import org.junit.runner.RunWith;
import static io.cucumber.junit.CucumberOptions.SnippetType.*;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"stepdefinitions",
                "hooks",
                "custom_type" },
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"
        },
//        tags ="@account",
        monochrome = true,
        snippets = CAMELCASE

)
public class TestRunner {
}


