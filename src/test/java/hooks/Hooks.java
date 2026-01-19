package hooks;


import context.TestContext;
import factory.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    public static WebDriver driver;
    private final TestContext testContext;

    public Hooks(TestContext testContext){
        this.testContext = testContext;
    }

    @Before
    public void setUp(Scenario scenario) {
        testContext.scenarioName = scenario.getName();

       driver = DriverFactory.initializeDriver(System.getProperty("browser","chrome"));
        System.out.println("Browser launched");

    }


    @After
    public void tearDown() {
        System.out.println("Browser closed");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (driver != null) {
            driver.quit();
        }
    }
}
