package model;

public class TicketingLogDTO {

    private int id;
    private int ticketId;
    private int userId;
    private String ticketingDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTicketingDate() {
        return ticketingDate;
    }

    public void setTicketingDate(String ticketingDate) {
        this.ticketingDate = ticketingDate;
    }

    public boolean equals(Object o) {
        if (o instanceof TicketingLogDTO) {
            TicketingLogDTO t = (TicketingLogDTO) o;
            return this.id == t.id;
        }

        return false;
    }
    
    public TicketingLogDTO() {
    }
    
    public TicketingLogDTO(TicketingLogDTO t) {
        this.id = t.id;
        this.ticketId = t.ticketId;
        this.ticketingDate = t.ticketingDate;
        this.userId = t.userId;
    }

}
