package pl.szczepanik.tau_labs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pl.szczepanik.tau_labs.domain.Boat;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
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

    @Test(expected = NoSuchFieldError.class)
    public void getBoatFromDbwithoutId() {
        Boat boat1 = new Boat(1, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.addBoat(boat1);
        int id = 2;
        db.getBoatById(id);
    }

    @Test
    public void checkReadAllBoats() {
        Boat boat1 = new Boat(1, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.addBoat(boat1);

        List<Boat> newBoatList = new ArrayList<Boat>();
        newBoatList.add(boat1);
        assertEquals(newBoatList, db.readAll());
    }

    @Test
    public void checkIsBoatAdded() {
        Boat boat1 = new Boat(1, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.addBoat(boat1);
        assertEquals(boat1, db.getBoatById(1));
    }


}
