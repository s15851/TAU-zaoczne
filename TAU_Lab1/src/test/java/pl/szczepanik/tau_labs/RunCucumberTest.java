package pl.szczepanik.tau_labs;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, features = "src/test/java/pl/szczepanik/tau_labs/resources", snippets = SnippetType.CAMELCASE)

public class RunCucumberTest {
}
