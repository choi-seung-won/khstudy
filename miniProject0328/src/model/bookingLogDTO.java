package model;

public class bookingLogDTO {

    private int id;
    private int roomId;
    private String startDate;
    private String endDate;
    private int hotelId;

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean equals(Object o) {
        if (o instanceof bookingLogDTO) {
            bookingLogDTO h = (bookingLogDTO) o;
            return this.id == h.id;
        }
        return false;
    }

    public bookingLogDTO() {

    }

    public bookingLogDTO(bookingLogDTO b) {

        this.id = b.id;
        this.roomId = b.roomId;
        this.startDate = b.startDate;
        this.endDate = b.endDate;
        this.hotelId = b.hotelId;

    }

}
