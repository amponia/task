package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DevicesPage {

    @FindBy(xpath = "//div//div//p[contains(text(),'Smartwatche i opaski')]")
    private WebElement devicesSubmenu;

    @FindBy(xpath="(//span[contains(text(),'Bez abonamentu')])[2]")
    private WebElement noSubscriptionOption;

    public void userSeeDevicesSubmenu(){
        Assertions.assertTrue(devicesSubmenu.isDisplayed());
    }

    public SmartwatchesAndWristbandsPage selectNoSubscriptionOption(){
        org.assertj.core.api.Assertions.assertThat(noSubscriptionOption.isEnabled());
        noSubscriptionOption.click();
        return new SmartwatchesAndWristbandsPage();
    }
}
