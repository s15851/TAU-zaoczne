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
        Boat boat1 = new Boat(3, "Antila 27", 2009);
        Boat boat2 = new Boat(3, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.create(boat1);
        db.create(boat2);
    }

    @Test
    public void getBoatFromDb() {
        Boat boat1 = new Boat(4, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.create(boat1);
        db.read(boat1.getId());
    }

    @Test(expected = NoSuchElementException.class)
    public void getBoatFromDbWithoutId() {
        Boat boat1 = new Boat(5, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.create(boat1);
        int id = 10;
        db.read(id);
    }

    @Test
    public void checkReadAllBoats() {
        Boat boat1 = new Boat(6, "Antila 27", 2009);
        Boat boat2 = new Boat(12, "Antila 27", 2009);
        Boat boat3 = new Boat(13, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.create(boat1);
        db.create(boat2);
        db.create(boat3);
        List<Boat> newBoatList = db.readAll();
        exception.expectMessage("There is no boat in this ID");
        assertEquals(db.read(0), newBoatList.get(0));
        assertEquals(db.read(1), newBoatList.get(1));
        assertEquals(db.read(2), newBoatList.get(2));

    }

    @Test
    public void checkIsBoatAdded() {
        Boat boat1 = new Boat(7, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.create(boat1);
        assertEquals(boat1, db.read(7));
    }

    @Test
    public void checkIsBoatUpdated() {
        Boat boat = new Boat(8, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.create(boat);
        Boat boat1 = db.read(boat.getId());
        boat1.setBoatModel("Phila");
        boat1.setYearOfProduction(2016);
        db.update(boat1);
        assertEquals(boat,db.read(8));
    }

    @Test
    public void checkIsBoatDeleted(){
        Boat boat = new Boat(9, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.create(boat);
        db.delete(9);
        exception.expect(NoSuchElementException.class);
        exception.expectMessage("There is no boat in this ID");
        db.read(boat.getId());

    }
}
