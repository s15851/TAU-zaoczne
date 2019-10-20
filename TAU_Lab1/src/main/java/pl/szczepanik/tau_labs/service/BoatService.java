package pl.szczepanik.tau_labs.service;

import pl.szczepanik.tau_labs.domain.Boat;

import java.util.ArrayList;
import java.util.List;

public class BoatService {

    private List<Boat> db = new ArrayList<Boat>();


    public void addBoat(Boat boat) {
        for (Boat boatFromDb : db) {
            if (boatFromDb.getId() == boat.getId()) {
                throw new IllegalArgumentException();
            }
        }
        db.add(boat);
    }

    public Boat getBoatById(int id) {
        for (Boat boatFromDb : db) {
            if (boatFromDb.getId() == id) {
                return boatFromDb;
            }
        }
        throw new NoSuchFieldError();
    }

}
