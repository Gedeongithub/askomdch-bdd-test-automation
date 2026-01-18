package stepdefinitions;

import hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RegisterSteps {
    private WebDriver driver = Hooks.driver;


    @Given("New user is on the Account Page")
    public void newUserIsOnTheAccountPage() {
        new AccountPage(driver).openAccountPage();
    }

    @When("New user register with valid data")
    public void newUserRegisterWithValidData(DataTable table) {
        Map<String,String> credentials = table.asMap(String.class,String.class);
        new AccountPage(driver).setAllRegFields(credentials.get("username"),credentials.get("email address"),credentials.get("password"));
    }

    @Then("New user is registered and get welcome message with name {string}")
    public void newUserIsRegisteredAndGetWelcomeMessage(String actualUsername) {
        assertEquals("Usernames are not identical",new AccountPage(driver).isWelcomeMessage(),actualUsername);
    }

    @When("New user register with invalid {string},{string} and {string}")
    public void newUserRegisterWithInvalidAnd(String username, String email, String password) {
        new AccountPage(driver).setAllRegFields(username,email,password);
    }

    @And("click Register button")
    public void clickRegisterButton() {
        new AccountPage(driver).clickRegisterButton();
    }

    @Then("Warning message is displayed")
    public void warningMessageIsDisplayed() {
        String actual  = new AccountPage(driver).isErrorMessage();
        System.out.println("Real: "+actual);
        String expected = "One of your username or password is wrong or empty";
        assertEquals("You should not log in",expected,errorMessage(actual));

    }
    private String errorMessage(String error){

        if(error == null){
            return "No error";
        }
        if(error.contains("Please enter an account password.")||
                error.contains("Please provide a valid email address.")||
                error.contains("Please enter a valid account username.")){
            return "One of your username or password is wrong or empty";
        }
        return "Nothing matching";

    }

}
