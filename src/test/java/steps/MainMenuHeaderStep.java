package steps;

import io.cucumber.java.en.And;
import pages.MainMenuHeaderPage;

public class MainMenuHeaderStep {

    private MainMenuHeaderPage mainMenuHeaderPage = new MainMenuHeaderPage ();

    @And("I select Devices from main header menu")
    public void selectDevicesFromMainHeaderMenu() {
        mainMenuHeaderPage.clickOnDevicesButton();
    }
}
