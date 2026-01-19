package hooks;


import factory.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {

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
