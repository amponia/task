package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenuHeaderPage {

    @FindBy(xpath = "//button[(contains(text(),'Urządzenia'))]")
    private WebElement devicesButton;

    public DevicesPage clickOnDevicesButton() {
        Assertions.assertThat(devicesButton.isDisplayed());
        devicesButton.click();
        return new DevicesPage();
    }

    @FindBy(xpath = "//h1[@class='sr-only']")
    private WebElement mainMenuHeader;

    @FindBy(css = "button[id='didomi-notice-agree-button']")
    private WebElement cookiesConsentButton;

}
