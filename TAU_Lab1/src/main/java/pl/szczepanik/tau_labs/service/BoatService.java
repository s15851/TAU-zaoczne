package pl.szczepanik.tau_labs.service;

import pl.szczepanik.tau_labs.domain.Boat;

import java.util.ArrayList;

public class BoatService {
    private ArrayList<Boat> boats;

    public BoatService(){

    }

    public BoatService(ArrayList<Boat> boats) {
        this.boats = boats;
        Boat boat1 = new Boat(1, "Antila 27", 2009);
        boats.add(boat1);
    }

    public Boat create(){
        return new Boat();
    }

    public Boat read(){
        return new Boat();
    }

    public Boat update(){
        return new Boat();
    }

    public Boat delete(){
        return new Boat();
    }
}
