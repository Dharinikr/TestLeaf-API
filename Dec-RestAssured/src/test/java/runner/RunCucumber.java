package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"src/test/java/feature/CreateIncident.feature", "src/test/java/feature/CreateIncident2.feature"},
glue= {"steps","hooks"}, monochrome=true)

public class RunCucumber extends AbstractTestNGCucumberTests {
	
	

}
