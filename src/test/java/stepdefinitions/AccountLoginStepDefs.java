package stepdefinitions;

import hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import java.util.Map;
import static org.junit.Assert.assertEquals;


public class AccountLoginStepDefs {
    private WebDriver driver = Hooks.driver;


    @Given("I am on the Account Page")
    public void iAmOnTheAccountPage() {
        new AccountPage(driver).openAccountPage();
    }

    @When("I log in with valid credentials")
    public void iLogInWithValidCredentials(DataTable table) {

        Map<String,String> credentials = table.asMap(String.class,String.class);

        new AccountPage(driver).setCredentials(credentials.get("username"),credentials.get("password"));
    }

    @Then("I should be redirected to the Dashboard")
    public void iShouldBeRedirectedToTheDashboard() {
        new AccountPage(driver).isWelcomeMessage();
    }

    @And("I should see a welcome message with {string}")
    public void iShouldSeeAWelcomeMessage(String actualUsername) {
        assertEquals("Usernames are not identical",new AccountPage(driver).isWelcomeMessage(),actualUsername);
    }

    @When("I log in with username {string} and password {string}")
    public void iLogInWithUsernameAndPassword(String username, String password) {
        new AccountPage(driver).setCredentials(username,password);

    }

    @Then("I should see a login error message")
    public void iShouldSeeALoginErrorMessage() {

        String actual  =new AccountPage(driver).isErrorMessage();
        String expected = "One of your username or password is wrong or empty";
        assertEquals("You should not log in",expected,errorMessage(actual));
    }

    private String errorMessage(String error){

            if(error == null){
                return "No error";
            }
            if(error.contains("Unknown email address. Check again or try your username.")||
                    error.contains("Username is required.")||
            error.contains("The password field is empty.")){
                return "One of your username or password is wrong or empty";
            }
            return "Nothing matching";

        }
    }


