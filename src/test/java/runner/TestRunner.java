package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"StepDef"},
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json"},
        monochrome = true

)

public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object [][] scenarios(){
        return super.scenarios();
    }




}
