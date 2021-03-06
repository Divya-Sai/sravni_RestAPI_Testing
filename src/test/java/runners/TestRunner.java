package runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features",
		glue = {"stepDefinition" },
		//tags = { "@hooks,@get,@smokes" },
		plugin = {"pretty",
				"html:output/html-report" },
		monochrome = true,
		strict = true,
		dryRun = false)
public class TestRunner {

}
