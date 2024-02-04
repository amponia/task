package pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import static org.assertj.core.api.Assertions.assertThat;

public class PlainTest {

    @FindBy(xpath = "//h1[@class='sr-only']")
    private WebElement mainMenuHeader;

    @FindBy(css = "button[id='didomi-notice-agree-button']")
    private WebElement cookiesConsentButton;

    @FindBy(xpath = "//button[(contains(text(),'Urządzenia'))]")
    private WebElement devicesButton;

    @FindBy(xpath = "//div//div//p[contains(text(),'Smartwatche i opaski')]")
    private WebElement devicesSubmenu;

    @FindBy(xpath = "(//span[contains(text(),'Bez abonamentu')])[2]")
    private WebElement noSubscriptionOption;

    @FindBy(xpath = "//h1[contains(text(),'Urządzenia')]")
    private WebElement devicesHeader;

    @FindAll({@FindBy(xpath = "//div[contains(@class,'styles__StyledCard')]")})
    private List<WebElement> devicesList;
    private static String startPriceText;
    private static String listedProductNameText;
    private static String toBePaidMonthlyText;
    private String mainContent = "//section[@class='mainContent']";

    private static String productNameText;

    @Test
    public void test() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://www.t-mobile.pl/");
        driver.manage().window().maximize();
        cookiesConsentButton.click();
        assertThat(mainMenuHeader.isDisplayed());
        devicesButton.click();
        assertThat(devicesSubmenu.isDisplayed());
        assertThat(noSubscriptionOption.isEnabled());
        noSubscriptionOption.click();
        org.junit.jupiter.api.Assertions.assertTrue(devicesHeader.isDisplayed());

        WebElement firstItem = devicesList.stream()
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException());
        WebElement listedProductName = firstItem.findElement(new By.ByXPath(mainContent + "//h2"));
        listedProductNameText = listedProductName.getText();
        WebElement startPrice = firstItem.findElement(new By.ByXPath(mainContent + "//div[@class='leftText']//div[contains(@class,'actualText')]"));
        startPriceText = startPrice.getText();
        WebElement monthlyRate = firstItem.findElement(new By.ByXPath(mainContent + "//div[@class='rightText']//div[contains(@class,'actualText')]"));
        toBePaidMonthlyText = monthlyRate.getText();
        firstItem.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        WebElement productNameHeader = driver.findElement(By.xpath("//h1"));
        productNameText = productNameHeader.getText();
        System.out.println(listedProductNameText);
        System.out.println(productNameText);
        org.junit.jupiter.api.Assertions.assertTrue(listedProductNameText.equals(productNameText));
    }

}


