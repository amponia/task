package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.SmartwatchesAndWristbandsPage;

public class SmartwatchesAndWristbandsStep {

    private SmartwatchesAndWristbandsPage smartwatchesPage = new SmartwatchesAndWristbandsPage();


    @Then("I should see devices displayed")
    public void userShouldSeeDevicesDisplayed() {
        smartwatchesPage.usersShouldSeeProductsDisplayed();
    }

    @Given("I select first item from the displayed menu")
    public void selectFirstItemFromTheDisplayedMenu() {
        smartwatchesPage.selectFirstDeviceFromTheList();
    }

}

