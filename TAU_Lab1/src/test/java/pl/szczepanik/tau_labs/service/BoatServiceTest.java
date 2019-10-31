package pl.szczepanik.tau_labs.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.szczepanik.tau_labs.domain.Boat;
import pl.szczepanik.tau_labs.interfaces.TimeSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

//@RunWith(JUnit4.class)
@RunWith(MockitoJUnitRunner.class)
public class BoatServiceTest {

    @Mock
    TimeSource timeSource;

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
        assertEquals(BoatService.db.size() ,newBoatList.size());
        assertEquals(BoatService.db.get(0), newBoatList.get(0));
        assertEquals(BoatService.db.get(1), newBoatList.get(1));
        assertEquals(BoatService.db.get(2), newBoatList.get(2));

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

    @Test
    public void checkTimeStampAfterReadOneRecord() {
        when(timeSource.getCurrentDate()).thenReturn((long) 123456);
        Boat boat = new Boat(10, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.create(boat);
        db.setTimeSource(timeSource.getCurrentDate());
        db.read(10);
        long time = 123456;
        assertEquals(time, db.read(10).getReadTime());
    }

    @Test
    public void checkTimeStampAfterReadAllRecords() {

        long time = 123456789;

        when(timeSource.getCurrentDate()).thenReturn(time);
        Boat boat1 = new Boat(21, "Antila 27", 2009);
        Boat boat2 = new Boat(22, "Tango 780", 2017);
        Boat boat3 = new Boat(23, "Twister", 2010);
        BoatService db = new BoatService();
        db.create(boat1);
        db.create(boat2);
        db.create(boat3);
        db.setTimeSource(timeSource.getCurrentDate());

        assertEquals(time, db.readAll().get(0).getReadTime());
        assertEquals(time, db.readAll().get(1).getReadTime());
        assertEquals(time, db.readAll().get(2).getReadTime());
    }

    @Test
    public void checkTimeStampAfterAddNewBoat() {
        long time = 1234567891;
        when(timeSource.getCurrentDate()).thenReturn(time);
        Boat boat1 = new Boat(31, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.setTimeSource(timeSource.getCurrentDate());
        db.create(boat1);
        assertEquals(time, db.read(31).getCreationTime());
    }

    @Test
    public void checkCreationTimeDisabled() {
        long time = 1234567891;
        when(timeSource.getCurrentDate()).thenReturn(time);
        Boat boat1 = new Boat(32, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.setTimeSource(timeSource.getCurrentDate());
        db.setCreationTimeDisabled();
        db.create(boat1);
        assertEquals(0, db.read(32).getCreationTime());
    }

    @Test
    public void checkCreationTimeEnabled() {
        long time = 1234567891;
        when(timeSource.getCurrentDate()).thenReturn(time);
        Boat boat1 = new Boat(33, "Antila 27", 2009);
        Boat boat2 = new Boat(34, "Tango 780", 2017);
        BoatService db = new BoatService();
        db.setTimeSource(timeSource.getCurrentDate());
        db.setCreationTimeDisabled();
        db.create(boat1);
        db.setCreationTimeEnabled();
        db.create(boat2);
        assertEquals(0, db.read(33).getCreationTime());
        assertEquals(time, db.read(34).getCreationTime());
    }

    @Test
    public void checkTimeStampAfterUpdateBoat() {
        long time = 1234567892;
        when(timeSource.getCurrentDate()).thenReturn(time);
        Boat boat = new Boat(35, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.create(boat);
        db.setTimeSource(timeSource.getCurrentDate());
        Boat boat1 = db.read(boat.getId());
        boat1.setBoatModel("Phila");
        boat1.setYearOfProduction(2016);
        db.update(boat1);
        assertEquals(time, db.read(35).getModificationTime());
    }

    @Test
    public void checkGetAllTimeStampsForBoatById() {
        long time = 987654321;
        when(timeSource.getCurrentDate()).thenReturn(time);
        Boat boat1 = new Boat(36, "Antila 27", 2009);
        BoatService db = new BoatService();
        db.setTimeSource(timeSource.getCurrentDate());
        db.create(boat1);
        Boat boat2 = db.read(boat1.getId());
        boat2.setBoatModel("Phila");
        db.update(boat2);
        Map<String, Long> timeStamps = new HashMap<String, Long>();
        timeStamps.put("creationTime", time);
        timeStamps.put("modificationTime", time);
        timeStamps.put("readTime", time);
        Map<String, Long> timeStampsOfBoat = db.getAllTimeStampsForBoatById(36);
        assertEquals(timeStamps, timeStampsOfBoat);
    }





}
