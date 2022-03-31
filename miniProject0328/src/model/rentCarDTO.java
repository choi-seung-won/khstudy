package model;

public class rentCarDTO {

    private int id;
    private int carId;
    private String type;
    private String color;

    private boolean reserved;
    private int reservedUserId;
    
    public int getReservedUserId() {
        return reservedUserId;
    }

    public void setReservedUserId(int reservedUserId) {
        this.reservedUserId = reservedUserId;
    }

    public boolean getReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean equals(Object o) {
        if (o instanceof rentCarDTO) {
            rentCarDTO r = (rentCarDTO) o;
            return this.id == r.id;
        }
        return false;
    }

    public rentCarDTO() {
    }

    public rentCarDTO(rentCarDTO r) {
        this.id = r.id;
        this.carId = r.carId;
        this.color = r.color;
        this.type = r.type;
        this.reserved = r.reserved;
        this.reservedUserId = r.reservedUserId;
    }

}
