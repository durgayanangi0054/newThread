package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/Features",
    glue = {"setoDefinition","utils"},
    plugin = {"pretty", "html:target/cucumber-reports.html"}
    //tags = "@regression"
)
public class TestRunner extends AbstractTestNGCucumberTests {	
	
	  @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
}