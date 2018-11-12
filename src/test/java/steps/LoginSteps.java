package steps;

import base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class LoginSteps extends BaseUtil {

    private BaseUtil base;

    public LoginSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        base.driver.get("http://www.executeautomation.com/demosite/Login.html");
    }

    @And("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
        //Create an ArrayList of users
        List<User> usersList = new ArrayList<User>();
        //Store all the users
        usersList = table.asList(User.class);

        LoginPage loginPage = new LoginPage(base.driver);

        for (User user : usersList) {
            loginPage.login(user.username, user.password);
        }
    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        LoginPage loginPage = new LoginPage(base.driver);
        loginPage.clickLogin();
    }

    @Then("^I should see the user form page$")
    public void iShouldSeeTheUserFormPage() throws Throwable {

        By initial = By.id("Initial");
        waitUntilFoundElement(initial);

        Assert.assertEquals("It isn't displayed!", base.driver.findElement(initial).isDisplayed(), true);
    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String userName, String password) throws Throwable {
        System.out.println("UserName is: " + userName);
        System.out.println("Password is: " + password);
    }

    public void waitUntilFoundElement(By by){
        WebDriverWait wait = new WebDriverWait(base.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public class User {
        public String username;
        public String password;

        public User(String userName, String passWord) {
            username = userName;
            password = passWord;
        }
    }
}
