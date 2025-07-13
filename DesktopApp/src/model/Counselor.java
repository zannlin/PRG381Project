package model;

public class Counselor {
    private int id;
    private String name;
    private String specialization;
    private String availability;

    public Counselor(int Id, String Name, String Specialization, String Availability) {
        this.id = Id;
        this.name = Name;
        this.specialization = Specialization;
        this.availability = Availability;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

}
