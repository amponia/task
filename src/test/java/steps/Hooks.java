package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    public static WebDriver driver;

    protected static final Logger log = LoggerFactory.getLogger(Hooks.class);

    @BeforeStep
    public void setUp() {

        if (driver == null) {
            driver = new ChromeDriver();
        }
    }


    @AfterAll
    public void cleanUp() {
        if (null != driver) {
            driver.close();
            driver.quit();
        }
       }



}

