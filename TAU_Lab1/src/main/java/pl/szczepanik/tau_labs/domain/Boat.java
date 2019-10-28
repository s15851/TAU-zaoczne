package pl.szczepanik.tau_labs.domain;

public class Boat {

    private int id;
    private String boatModel;
    private int yearOfProduction;
    private long creationTime;
    private long modificationTime;
    private long readTime;

    public Boat() {
    }

    public Boat(int id, String boatModel, int yearOfProduction) {
        this.id = id;
        this.boatModel = boatModel;
        this.yearOfProduction = yearOfProduction;
    }

    public Boat(int id, String boatModel, int yearOfProduction, long creationTime, long modificationTime, long readTime) {
        this.id = id;
        this.boatModel = boatModel;
        this.yearOfProduction = yearOfProduction;
        this.creationTime = creationTime;
        this.modificationTime = modificationTime;
        this.readTime = readTime;
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

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public long getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(long modificationTime) {
        this.modificationTime = modificationTime;
    }

    public long getReadTime() {
        return readTime;
    }

    public void setReadTime(long readTime) {
        this.readTime = readTime;
    }

}
