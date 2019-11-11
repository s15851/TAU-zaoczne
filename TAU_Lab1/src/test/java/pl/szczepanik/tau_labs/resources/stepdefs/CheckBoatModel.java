package pl.szczepanik.tau_labs.resources.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

class CheckBoat {
    static String whatBoatIsIt(String model) {
        if (model.equals("Tango 780")) {
            return "Yes";
        }
        return "No";
    }
}

public class CheckBoatModel {
    private String boatModel;
    private String actualAnswer;


    @Given("^this is \"([^\"]*)\"$")
    public void this_is(String model) {
        this.boatModel = model;
    }

    @When("^I ask you, are you sure it's Tango 780$")
    public void I_ask_you_are_you_sure_it_is_Tango_780() {
        this.actualAnswer = CheckBoat.whatBoatIsIt(boatModel);
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
}
