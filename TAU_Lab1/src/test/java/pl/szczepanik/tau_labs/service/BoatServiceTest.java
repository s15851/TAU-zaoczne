package pl.szczepanik.tau_labs.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pl.szczepanik.tau_labs.domain.Boat;
import java.lang.IllegalArgumentException;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class BoatServiceTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

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
        db.create(boat1);
        db.create(boat2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createBoatTestTheSameId() {
        Boat boat1 = new Boat(1, "Antila 27", 2009);
        Boat boat2 = new Boat(1, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.create(boat1);
        db.create(boat2);
    }

    @Test
    public void getBoatFromDb() {
        Boat boat1 = new Boat(1, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.create(boat1);
        db.read(boat1.getId());
    }

    @Test(expected = NoSuchElementException.class)
    public void getBoatFromDbWithoutId() {
        Boat boat1 = new Boat(1, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.create(boat1);
        int id = 2;
        db.read(id);
    }

    @Test
    public void checkReadAllBoats() {
        Boat boat1 = new Boat(1, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.create(boat1);

        List<Boat> newBoatList = new ArrayList<Boat>();
        newBoatList.add(boat1);
        assertEquals(newBoatList, db.readAll());
    }

    @Test
    public void checkIsBoatAdded() {
        Boat boat1 = new Boat(1, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.create(boat1);
        assertEquals(boat1, db.read(1));
    }

    @Test
    public void checkIsBoatUpdated() {
        Boat boat = new Boat(1, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.create(boat);
        Boat boat1 = db.read(boat.getId());
        boat1.setBoatModel("Phila");
        boat1.setYearOfProduction(2016);
        db.update(boat1);
        assertEquals(boat,db.read(1));
    }

    @Test
    public void checkIsBoatDeleted(){
        Boat boat = new Boat(1, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.create(boat);
        db.delete(1);
        exception.expect(NoSuchElementException.class);
        exception.expectMessage("There is no boat in this ID");
        db.read(boat.getId());

    }
}
