package pl.szczepanik.tau_labs.service;

import pl.szczepanik.tau_labs.domain.Boat;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BoatService {

    public static ArrayList<Boat> db = new ArrayList<>();


    public void create(Boat boat) {
        for (Boat boatFromDb : db) {
            if (boatFromDb.getId() == boat.getId()) {
                throw new IllegalArgumentException();
            }
        }
        db.add(boat);
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

}
