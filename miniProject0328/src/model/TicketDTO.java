package model;

public class TicketDTO {

    private int id;
    private String departure;
    private String departureTime;
    private String destination;
    private String arrivalTime;
    private String seat;
    
    
    private boolean reserved = false;//예약여부체크
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

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public boolean equals(Object o) {
        if (o instanceof TicketDTO) {
            TicketDTO t = (TicketDTO) o;
            return this.id == t.id;
        }
        return false;
    }

    public TicketDTO() {

    }

    public TicketDTO(TicketDTO t) {
        this.id = t.id;
        this.departure = t.departure;
        this.departureTime = t.departureTime;
        this.destination = t.destination;
        this.arrivalTime = t.arrivalTime;
        this.seat = t.seat;
        this.reserved = t.reserved;
        this.reservedUserId = t.reservedUserId;

    }

}
