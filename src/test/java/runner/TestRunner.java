package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

/**
 * Created by Yana on 09.11.2018.
 */

//@RunWith(Cucumber.class)--JUnit

@CucumberOptions(features = {"src/test/java/features"}
        , format = {"json:target/cucumber.json",
                    "html:target/site/cucumber-pretty"}
        , glue = "steps")

public class TestRunner extends AbstractTestNGCucumberTests{
}
