package pages;

import constants.EndPoint;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.cssSelector("button[value='Log in']");
    By message = By.cssSelector("strong:nth-child(1)");
    By errorMessage = By.cssSelector("div[id='content'] li:nth-child(1)");
    //Data fields for user registration section

    By username_regField = By.id("reg_username");
    By email_regField = By.id("reg_email");
    By password_regField = By.id("reg_password");
    By registerButton = By.cssSelector("button[value='Register']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void openAccountPage(){
        load(EndPoint.ACCOUNT.url);

    }
// the methods for registration section except openAccountPage() method

    public void registerUsername(String username){
        driver.findElement(username_regField).sendKeys(username);
    }

    public void registerEmail(String email){
        driver.findElement(email_regField).sendKeys(email);
    }

    public void registerPassword(String password){
        driver.findElement(password_regField).sendKeys(password);
    }
    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }

    public void setAllRegFields(String username,String email,String password){
        registerUsername(username);
        registerEmail(email);
        registerPassword(password);
    }


//The methods for login section
    public void fillUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void fillPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton(By element){
        driver.findElement(element).click();
    }

    public void setCredentials(String username, String password){
        fillPassword(password);
        fillUsername(username);
        clickLoginButton(loginButton);
    }

    public String isWelcomeMessage(){
       return driver.findElement(message).getText();
    }

    public String isErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }


}
