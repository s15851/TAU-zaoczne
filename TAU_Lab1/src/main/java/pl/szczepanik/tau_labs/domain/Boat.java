package pl.szczepanik.tau_labs.domain;

import java.util.Date;

public class Boat {

    private int id;
    private String boatModel;
    private int yearOfProduction;
    private Date creationTime;
	private Date modificationTime;
	private Date readTime;

    public Boat(int id, String boatModel, int yearOfProduction) {
        this.id = id;
        this.boatModel = boatModel;
        this.yearOfProduction = yearOfProduction;
    }

    public Boat(int id, String boatModel, int yearOfProduction, Date creationTime, Date modificationTime, Date readTime) {
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

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

}
