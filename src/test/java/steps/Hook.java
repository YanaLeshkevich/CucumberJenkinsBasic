package steps;

import base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void initializeTest(){
        System.out.println("Run Before Test!!!");

        System.setProperty("webdriver.gecko.driver","D:\\drivers\\geckodriver.exe");
        base.driver = new FirefoxDriver();
    }

    @After
    public void tearDownTest(Scenario scenario){

        if (scenario.isFailed()){
            //Take screenshoot
            System.out.println(scenario.getName());
        }

        System.out.println("Run after Test!!!");
    }
}
