package model;

public class TheaterDTO {
    
    
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public TheaterDTO() {
        
        
    }
    
    public TheaterDTO(TheaterDTO t) {
        this.id = t.id;
        this.name = t.name;
        this.address = t.address;
        this.phoneNumber = t.phoneNumber;
        
    }
    
    public boolean equals(Object o) {
        if (o instanceof TheaterDTO) {
            TheaterDTO t = (TheaterDTO) o;
            return id == t.id;
        }
        return false;
    }
    
    
    
}
