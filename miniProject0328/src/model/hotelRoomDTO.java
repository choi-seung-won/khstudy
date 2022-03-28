package model;

public class hotelRoomDTO {

    private int id;
    private int hotelId;
    private String roomNum;
    private String bookingPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getBookingPrice() {
        return bookingPrice;
    }

    public void setBookingPrice(String bookingPrice) {
        this.bookingPrice = bookingPrice;
    }

    public boolean equals(Object o) {
        if (o instanceof hotelRoomDTO) {
            hotelRoomDTO h = (hotelRoomDTO) o;
            return this.id == h.id;
        }
        return false;
    }

    public hotelRoomDTO() {

    }

    public hotelRoomDTO(hotelRoomDTO h) {
        this.id = h.id;
        this.bookingPrice = h.bookingPrice;
        this.hotelId = this.hotelId;
        this.roomNum = this.roomNum;
    }

}
