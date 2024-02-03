package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class SmartwatchesAndWristbandsPage extends HomePage {


    @FindBy(xpath = "//h1[contains(text(),'Urządzenia')]")
    private WebElement devicesHeader;

    @FindAll({@FindBy(xpath = "//div[contains(@class,'styles__StyledCard')]")})
    private List<WebElement> devicesList;

    private static String startPriceText;

    private static String toBePaidMonthlyText;

    private static String listedProductNameText;

    private static String productNameText;

    private String mainContent = "//section[@class='mainContent']";

    public void usersShouldSeeProductsDisplayed() {
        Assertions.assertTrue(devicesHeader.isDisplayed());
    }

    public ProductPage selectFirstDeviceFromTheList() {
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
        return new ProductPage();
    }

}
