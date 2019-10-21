package pl.szczepanik.tau_labs.service;

import pl.szczepanik.tau_labs.domain.Boat;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class BoatService {

    public static ArrayList<Boat> db = new ArrayList<>();


    public Boat create(Boat boat) throws IllegalArgumentException {
        for (Boat boatFromDb : db) {
            if (boatFromDb.getId() == boat.getId()) {
                throw new IllegalArgumentException();
            }
        }
        db.add(boat);
        return boat;
    }

    public Boat read(int id) {
        for (Boat boatFromDb : db) {
            if (boatFromDb.getId() == id) {
                return boatFromDb;
            }
        }
        throw new NoSuchElementException("There is no boat in this ID");
    }

    public List<Boat> readAll() {
        return db;
    }

    public Boat update(Boat updateBoat) {
        if(db.contains(updateBoat)){
            db.set(db.indexOf(updateBoat),updateBoat);
            return updateBoat;
        }
        throw  new NoSuchElementException("There is no boat in this ID in database");
    }

    public void delete(int id) {
        Boat boat = read(id);
        db.remove(boat);
    }

}
