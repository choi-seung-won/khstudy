package model;

public class rentCarLogDTO {
    private int id;
    private int userId;
    private int rentCarId;
    private String rentStartDate;
    private String rentEndDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRentCarId() {
        return rentCarId;
    }

    public void setRentCarId(int rentCarId) {
        this.rentCarId = rentCarId;
    }

    public String getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(String rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public String getRentEndDate() {
        return rentEndDate;
    }

    public void setRentEndDate(String rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    public rentCarLogDTO() {
    }

    public rentCarLogDTO(rentCarLogDTO r) {

        this.id = r.id;
        this.rentCarId = r.rentCarId;
        this.rentEndDate = r.rentEndDate;
        this.rentStartDate = r.rentStartDate;
        this.userId = r.userId;
    }

    public boolean equals(Object o) {
        if (o instanceof rentCarLogDTO) {
            rentCarLogDTO r = (rentCarLogDTO) o;
            
            return this.id == r.id;

        }

        return false;
    }

}
