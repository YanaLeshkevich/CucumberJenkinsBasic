package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Yana on 09.11.2018.
 */
public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "UserName")
    public WebElement txtUserName;

    @FindBy(name = "Password")
    public WebElement txtPassword;

    @FindBy(name = "Login")
    public WebElement btnLogin;

    public void login(String userName, String password){
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
    }

    public void clickLogin(){
        btnLogin.submit();
    }

}
