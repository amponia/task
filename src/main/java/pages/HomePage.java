package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    @FindBy(xpath = "//h1[@class='sr-only']")
    private WebElement mainMenuHeader;

    @FindBy(css = "button[id='didomi-notice-agree-button']")
    private WebElement cookiesConsentButton;

    private WebDriver driver = new ChromeDriver();

    public void goToHomePage() {
        PageFactory.initElements(driver, this);
        driver.get("https://www.t-mobile.pl/");
        driver.manage().window().maximize();
    }

    public void acceptCookies() {
        Assertions.assertThat(cookiesConsentButton.isDisplayed());
        cookiesConsentButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='sr-only']")));
    }

    public void userIsOnHomePage() {
        Assertions.assertThat(mainMenuHeader.isDisplayed());
    }

}
