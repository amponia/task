package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;


public class HomePageStep extends Hooks{

    private HomePage homePage = new HomePage();

    @Given("that I navigate to T-Mobile homepage")
    public void navigateToHomePage() {
        homePage.goToHomePage();
    }

    @And("I accept cookies button")
    public void acceptCookiesButton() {

        homePage.acceptCookies();
    }

    @Then("I should see T-Mobile homepage")
    public void homePageIsVisible() {
        homePage.userIsOnHomePage();
        log.info("User is on T-Mobile homepage");
    }

    @Then("I should see T-Mobile homepage with cart updated with <int> product")
    public void userShouldSeeHomepageWithUpdatedCart(int itemAmount) {
    }
}
