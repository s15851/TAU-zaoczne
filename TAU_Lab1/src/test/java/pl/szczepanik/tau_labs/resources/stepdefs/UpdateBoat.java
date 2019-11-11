package pl.szczepanik.tau_labs.resources.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pl.szczepanik.tau_labs.domain.Boat;
import pl.szczepanik.tau_labs.domain.DateTimeSource;
import pl.szczepanik.tau_labs.interfaces.TimeSource;
import pl.szczepanik.tau_labs.service.BoatService;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class UpdateBoat {

    private BoatService db;
    private Boat newBoat = new Boat(54, "Antila 27", 20);


    @Given("Added new boat \"([^\"]*)\" to DB with wrong year of production")
    public void addedNewBoatToDBWithWrongYearOfProduction(String model) {
        db = new BoatService();
        BoatService.db = new ArrayList<>();
        TimeSource timesource = new DateTimeSource();
        db.setTimeSource(timesource);
        Collections.addAll(BoatService.db,
                new Boat(51, "Antila 27", 2015),
                new Boat(52, "Tango 780", 2017),
                new Boat(53, "Antila 33", 2013)
        );
        BoatService.db.add(newBoat);
    }

    @When("^Boat year of production should be updated to (\\d+)$")
    public void boatYearOfProductionShouldBeUpdatedTo(int year) {
        BoatService.db.get(3).setYearOfProduction(year);
    }

    @Then("^Boat have a new year of production$")
    public void boatHaveANewYearOfProduction() {
        assertEquals(2019, BoatService.db.get(3).getYearOfProduction());
    }

}
