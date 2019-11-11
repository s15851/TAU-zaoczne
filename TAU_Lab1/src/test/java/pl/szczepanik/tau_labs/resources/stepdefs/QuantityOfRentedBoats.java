package pl.szczepanik.tau_labs.resources.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pl.szczepanik.tau_labs.domain.Boat;
import pl.szczepanik.tau_labs.domain.DateTimeSource;
import pl.szczepanik.tau_labs.interfaces.TimeSource;
import pl.szczepanik.tau_labs.service.BoatService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class QuantityOfRentedBoats {

    private BoatService db;
    private int counter;

    @Given("^rental of 1 boat$")
    public void rentalOfBoat() {
        db = new BoatService();
        TimeSource timesource = new DateTimeSource();
        db.setTimeSource(timesource);
        assertNotNull(db);
    }

    @When("^boat has been rented$")
    public void boatHasBeenRented() {
        counter = BoatService.db.size();
        Boat boat = new Boat(51, "Antila 27", 2009);
        db.create(boat);
    }

    @Then("^quantity of rented boats has been increased by (\\d+)$")
    public void quantityOfRentedBoatsHasBeenIncreasedBy(int quantityOfAddedBoats) {
        assertEquals(counter + quantityOfAddedBoats, BoatService.db.size());
    }

}
