package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "classpath:features"
        },
        glue = {
                "steps",
                "hooks"
        /*},
        plugin = {
                "pretty",
                "html:target/results.html",
                "json:target/cucumber3.json"*/
        },
        plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        dryRun = false,
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

@ContextConfiguration
public class SolutionRunnerTest {
}
