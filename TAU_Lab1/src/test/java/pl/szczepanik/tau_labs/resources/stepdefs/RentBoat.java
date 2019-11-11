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

public class RentBoat {

    private BoatService db;
    private int counter;
    private String selectedModel;
    private Integer selectedYearOfProduction;

    @Given("^Customer chooses a boat from list of boats for rent$")
    public void customerChoosesABoatFromListOfBoatsForRent() {
        db = new BoatService();
        BoatService.db = new ArrayList<>();
        TimeSource timesource = new DateTimeSource();
        db.setTimeSource(timesource);
        Collections.addAll(BoatService.db,
                new Boat(61, "Antila 27", 2009),
                new Boat(62, "Tango 780", 2017),
                new Boat(63, "Twister", 2010),
                new Boat(64, "Antila 27", 2010),
                new Boat(65, "Antila 33", 2009)
        );
        counter = BoatService.db.size();
    }

    @When("^Customer choose model \"([^\"]*)\"$")
    public void customerChooseModel(String model) {
        selectedModel = model;
    }

    @When("^Customer choose year of production (\\d+)$")
    public void customerChooseYearOfProduction(int year) {
        selectedYearOfProduction = year;
    }

    @Then("^Boat has been rented and removed from list of boats for rent$")
    public void boatHasBeenRentedAndRemovedFromListOfBoatsForRent() {
        Boat choosedBoat = db.readAll().stream().filter(boat -> boat.getBoatModel().equals(selectedModel) && boat.getYearOfProduction() == selectedYearOfProduction).findFirst().get();
        assertEquals(choosedBoat, db.read(choosedBoat.getId()));
        db.delete(choosedBoat);
        assertEquals(4, BoatService.db.size());
    }

    @Then("^Quantity of boats for rent has been reduced by (\\d+)$")
    public void quantityOfBoatsForRentHasBeenReducedBy(int quantityOfReducedBoats) {
        assertEquals(counter - quantityOfReducedBoats, BoatService.db.size());
    }

}
