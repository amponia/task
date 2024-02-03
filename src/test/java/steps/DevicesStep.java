package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.DevicesPage;

public class DevicesStep {

    private DevicesPage devicesPage = new DevicesPage();

    @Then("I should see dropdown list from Devices menu")
    public void userSeesDevicesDropdownList() {
        devicesPage.userSeeDevicesSubmenu();
    }

    @Given("I select No subscription from Smartwatches and writsbands submenu")
    public void selectNoSubscriptionOption() {
        devicesPage.selectNoSubscriptionOption();
    }
}

