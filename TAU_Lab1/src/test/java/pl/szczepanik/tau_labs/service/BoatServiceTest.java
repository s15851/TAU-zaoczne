package pl.szczepanik.tau_labs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pl.szczepanik.tau_labs.domain.Boat;


import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class BoatServiceTest {

    @Test
    public void createBoatObject() {
        Boat boat = new Boat();
        assertNotNull(boat);
    }

    @Test
    public void createBoatTest() {
        Boat boat1 = new Boat(1, "Antila 27", 2009);
        Boat boat2 = new Boat(2, "Tango 780", 2017);
        BoatService db = new BoatService();
        db.addBoat(boat1);
        db.addBoat(boat2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void createBoatTestTheSameId() {
        Boat boat1 = new Boat(1, "Antila 27", 2009);
        Boat boat2 = new Boat(1, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.addBoat(boat1);
        db.addBoat(boat2);
    }

    @Test
    public void getBoatFromDb() {
        Boat boat1 = new Boat(1, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.addBoat(boat1);
        db.getBoatById(boat1.getId());
    }



}
