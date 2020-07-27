/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OS.bean;

/**
 *
 * @author user
 */
public class booking_detail {
  private String id;
    private String room_no;
    private String type_of_room;
    private String room_cap;
    private String lec_name;
     private String email;
     private String date;
     private String time;
     private String duration;
     private String attendee_no;
     private String reason;
     private String status;
     private String BookingId;

    public String getRoom_cap() {
        return room_cap;
    }

    public void setRoom_cap(String room_cap) {
        this.room_cap = room_cap;
    }

    public String getBookingId() {
        return BookingId;
    }

    public void setBookingId(String BookingId) {
        this.BookingId = BookingId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public String getType_of_room() {
        return type_of_room;
    }

    public void setType_of_room(String type_of_room) {
        this.type_of_room = type_of_room;
    }

    public String getLec_name() {
        return lec_name;
    }

    public void setLec_name(String lec_name) {
        this.lec_name = lec_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAttendee_no() {
        return attendee_no;
    }

    public void setAttendee_no(String attendee_no) {
        this.attendee_no = attendee_no;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     

}
