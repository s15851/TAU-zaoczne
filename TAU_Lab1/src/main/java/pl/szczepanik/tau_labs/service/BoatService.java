package pl.szczepanik.tau_labs.service;

import pl.szczepanik.tau_labs.domain.Boat;
import pl.szczepanik.tau_labs.interfaces.BoatInterface;
import pl.szczepanik.tau_labs.interfaces.TimeSource;

import java.util.*;


public class BoatService implements BoatInterface, TimeSource {

    public static ArrayList<Boat> db = new ArrayList<>();
    private long timeSource;
    private boolean creationTimeEnabled = true;
    private boolean modificationTimeEnabled = true;
    private boolean readTimeEnabled = true;


    public Boat create(Boat boat) throws IllegalArgumentException {
        for (Boat boatFromDb : db) {
            if (boatFromDb.getId() == boat.getId()) {
                throw new IllegalArgumentException();
            }
        }
        if (creationTimeEnabled) {
            boat.setCreationTime(getCurrentDate());
        }
        db.add(boat);
        return boat;
    }

    public Boat read(int id) {
        for (Boat boatFromDb : db) {
            if (boatFromDb.getId() == id) {
                if (readTimeEnabled) {
                    boatFromDb.setReadTime(getCurrentDate());
                }
                return boatFromDb;
            }
        }
        throw new NoSuchElementException("There is no boat in this ID");
    }

    public List<Boat> readAll() {
        for (Boat boatFromDb: db) {
            boatFromDb.setReadTime(getCurrentDate());
        }
        return db;
    }

    public Boat update(Boat updateBoat) {
        if(db.contains(updateBoat)){
            db.set(db.indexOf(updateBoat),updateBoat);
            if (modificationTimeEnabled){
                updateBoat.setModificationTime(getCurrentDate());
            }
            return updateBoat;
        }
        throw  new NoSuchElementException("There is no boat in this ID in database");
    }

    public void delete(int id) {
        Boat boat = read(id);
        db.remove(boat);
    }

    public long getCurrentDate() {
        return this.timeSource;
    }

    public void setTimeSource (long time) {
        this.timeSource = time;
    }

    public boolean setCreationTimeDisabled() {
        return this.creationTimeEnabled = false;
    }

    public boolean setCreationTimeEnabled() {
        return this.creationTimeEnabled = true;
    }

    public Map<String, Long> getAllTimeStampsForBoatById(int id) {
        Map<String, Long> allTimeStamps = new HashMap<String, Long>();
        for(Boat boatFromDb: db) {
            if(boatFromDb.getId() == id) {
                allTimeStamps.put("creationTime", boatFromDb.getCreationTime());
                allTimeStamps.put("modificationTime", boatFromDb.getModificationTime());
                allTimeStamps.put("readTime", boatFromDb.getReadTime());

                return allTimeStamps;
            }
        }
        throw new NoSuchFieldError();
    }

    public boolean setModificationTimeDisabled() {
        return this.modificationTimeEnabled = false;
    }

    public boolean setModificationTimeEnabled() {
        return this.modificationTimeEnabled = true;
    }

    public boolean setReadTimeDisabled() {
        return this.readTimeEnabled = false;
    }
}
