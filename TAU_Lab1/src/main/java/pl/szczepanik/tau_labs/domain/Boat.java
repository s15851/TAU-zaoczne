package pl.szczepanik.tau_labs.domain;

public class Boat {

    private int id;
    private String boatModel;
    private int yearOfProduction;

    public Boat() {
    }

    public Boat(int id, String boatModel, int yearOfProduction) {
        this.id = id;
        this.boatModel = boatModel;
        this.yearOfProduction = yearOfProduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBoatModel() {
        return boatModel;
    }

    public void setBoatModel(String boatModel) {
        this.boatModel = boatModel;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

}
