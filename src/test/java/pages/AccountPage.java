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

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void openAccountPage(){
        load(EndPoint.ACCOUNT.url);
//        driver.get("https://askomdch.com/account/");

    }


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
