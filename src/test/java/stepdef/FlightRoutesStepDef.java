package stepdef;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FlightRoutesStepDef extends Base {

//    FlightStatusPage flightStatusPage;

    @Given("Open Flight Routes Page")
    public void OpenFlightRoutesPage() {
        setUp("https://www.eurowings.com/en/information/at-the-airport/flight-status.html");
    }

    @And("Accept Privacy Settings")
    public void acceptPrivacySettings() {
        super.flightStatusPage.acceptPrivacySettings();
    }

    @Then("Verify Flight Routes {string}")
    public void verifyFlightRoutes(String pageTitle) {
        assertEquals(pageTitle, super.flightStatusPage.getPageTitle());
        tearDown();
    }

    @Given("Fill departure airport field with {string}")
    public void fillDepartureAirportFieldWith(String departureAirport) {
        super.flightStatusPage.fillDepartureAirportField(departureAirport);
    }

    @And("Fill destination airport field with {string}")
    public void fillDestinationAirportFieldWith(String destinationAirport) {
        super.flightStatusPage.fillDestinationAirportField(destinationAirport);
    }

    @And("Fill departure date field")
    public void fillDepartureDateField() {
        super.flightStatusPage.fillDepartureDateField();
    }

    @Then("Verify Flight Status table header")
    public void verifyFlightStatusTableHeader() {
        assertEquals("Status of your searched flight", super.flightStatusPage.getFlightStatusTableHeader());
    }

    @Then("Verify active date")
    public void verifyActiveDate() {
        assertEquals("Tue, 20/06/", super.flightStatusPage.getActiveDay());
    }

    @Then("Verify flight is exist")
    public void verifyFlightIsExist() {
        assertTrue(super.flightStatusPage.isFlightExist());
        tearDown();
    }
}
