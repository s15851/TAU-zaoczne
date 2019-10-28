package pl.szczepanik.tau_labs.interfaces;

import pl.szczepanik.tau_labs.domain.Boat;

import java.util.List;

public interface BoatInterface {

    Boat create(Boat boat);
    Boat read(int id);
    List<Boat> readAll();
    Boat update(Boat boat);
    void delete(int id);

    long getCurrentDate();
}
