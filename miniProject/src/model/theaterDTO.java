package model;

public class theaterDTO {
    
    
    private int id;
    private int name;
    private String location;
    


    private int callNum;
    

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getName() {
        return name;
    }


    public void setName(int name) {
        this.name = name;
    }



    public int getCallNum() {
        return callNum;
    }


    public void setCallNum(int callNum) {
        this.callNum = callNum;
    }
    
    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
    }


    public theaterDTO() {
        
        
    }
    
    public theaterDTO(theaterDTO t) {
        this.id = t.id;
        this.name = t.name;
        this.location = t.location;
        this.callNum = t.callNum;
        
        
    }
    
    public boolean equals(Object o) {
        if (o instanceof theaterDTO) {
            theaterDTO t = (theaterDTO) o;
            return id == t.id;
        }
        return false;
    }
    
    
    
}
