package Steps;
import Pages.HomePage;
import Pages.SearchResults;
import Utils.WebDriverHolder;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matcher;
import sun.security.util.PendingException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by anastasiyahrytsyuk on 2/17/16.
 */
public class SearchSteps {
    HomePage homePage = new HomePage();
    List<String> list = new ArrayList<String>();

    @Given("^I am on the Home page$")
    public void i_am_on_the_Home_page() throws Throwable {
        homePage.open();
    }

    @Given("^I select \"(.*?)\" search$")
    public void i_select_search(String searchDep) throws Throwable {
        // do nothing as all departments search is selected by default
    }

    @When("^I search for \"(.*?)\"$")
    public void i_search_for(String query) throws Throwable {
        SearchResults searchResult = homePage.Search().searchFor(query);
        list = searchResult.getProducts();


    }

    @Then("^I see the list of corresponding search results for product for \"(.*?)\"$")
    public void i_see_the_list_of_corresponding_search_results_for_product_for(String product) throws Throwable {
        assertThat(true, is(list.get(0).contains(product)));
        assertThat(list, hasSize(20));
    }


}