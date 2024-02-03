package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CartStep {

    @Then("cart page should be displayed")
    public void userShouldSeeCartPage() {
    }

    @And("{string} and {string} prices should match prices on previous page")
    public void andPricesShouldMatchPricesOnPreviousPage(String firstPrice, String secondPrice ) {
    }
}
