package model;

public class hotelDTO {

    private int id;
    private String name;
    private String location;
    private int grade;
    private String callNum;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getCallNum() {
        return callNum;
    }

    public void setCallNum(String callNum) {
        this.callNum = callNum;
    }

    public boolean equals(Object o) {
        if (o instanceof hotelDTO) {
            hotelDTO h = (hotelDTO) o;
            return this.id == h.id;
        }
        return false;
    }

    public hotelDTO() {
    }

    public hotelDTO(hotelDTO h) {
        this.id = h.id;
        this.name = h.name;
        this.location = h.location;
        this.callNum = h.callNum;
        this.grade = h.grade;

    }

}
