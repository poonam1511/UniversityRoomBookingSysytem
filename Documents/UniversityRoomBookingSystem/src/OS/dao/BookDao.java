/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OS.dao;

import ECUtils.BaseDAO;
import OS.bean.booking_detail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author user
 */
public class BookDao extends BaseDAO{
    public static LinkedList<booking_detail> search(String sc, String si) {
        LinkedList<booking_detail> res = new LinkedList<>();
        Connection con = null;
        try {
            con = getCon();
            String sql = "select * from booking_detail where " + sc + " like ? ";
            int i = 1;
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(i++, "%" + si + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
// lec_name,email,  time, duration,date,type_of_room,room_no,attendee_no,reason_for_booking ,status 
                booking_detail c1 = new booking_detail();
                c1.setId(rs.getString("id")); 
                c1.setLec_name(rs.getString("lec_name"));
                c1.setEmail(rs.getString("email"));
                c1.setTime(rs.getString("time"));
                c1.setDuration(rs.getString("duration"));
                c1.setDate(rs.getString("date"));
                c1.setType_of_room(rs.getString("type_of_room"));
                c1.setAttendee_no(rs.getString("attendee_no"));
                c1.setReason(rs.getString("reason_for_booking"));
                c1.setRoom_no(rs.getString("room_no"));
                c1.setStatus(rs.getString("status"));
                c1.setRoom_cap(rs.getString("room_cap"));
                c1.setBookingId(rs.getString("booking_id"));
                
                
                
                res.add(c1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return res;
    }
    
    
    
    
    
     public static void insert(booking_detail c1) {
         Connection con = null;
        try {
           // Date obj =new Date();
            con = getCon();
            //id INT NOT NULL AUTO_INCREMENT, lec_name,email,  time, duration,date,type_of_room,room_no,attendee_no,reason_for_booking ,status 
            String sql = "insert into booking_detail (lec_name , email, time, duration , date , type_of_room , room_no, attendee_no,reason_for_booking , status,room_cap) values (?, ?, ?,?,?,?,?,?,?,?,?)";
            int i = 1;
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(i++, c1.getLec_name());
            st.setString(i++, c1.getEmail());
            st.setString(i++, c1.getTime());
            st.setString(i++, c1.getDuration());  
            st.setString(i++, c1.getDate());
            st.setString(i++, c1.getType_of_room());
            st.setString(i++, c1.getRoom_no());
            st.setString(i++, c1.getAttendee_no());
            st.setString(i++, c1.getReason());
            st.setString(i++, c1.getStatus());
             st.setString(i++, c1.getRoom_cap());
           // st.setString(i++, c1.getId());
            
            
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
    }
    
     
     public static void delete(String id) {
        Connection con = null;
        try {
            con = getCon();
            String sql = "delete from booking_detail where id = ? ";
            int i = 1;
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(i++, id);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
    }
     
     
     
     
     
     
     
     
     
     public static booking_detail searchUser(String name,String email){
        Connection con=null;
       booking_detail res=null;
        try {
            con= BaseDAO.getCon();
            String sql="select * from booking_detail where lec_name=? and email=?";
            PreparedStatement st= con.prepareStatement(sql);
            st.setString(1,name );
            st.setString(2, email);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                booking_detail c1= new booking_detail();
                c1.setId(rs.getString("id"));
                c1.setLec_name(rs.getString("lec_name"));
                c1.setEmail(rs.getString("email"));
                c1.setTime(rs.getString("time"));
                c1.setDuration(rs.getString("duration"));
                c1.setDate(rs.getString("date"));
                c1.setType_of_room(rs.getString("type_of_room"));
                c1.setAttendee_no(rs.getString("attendee_no"));
                c1.setReason(rs.getString("reason_for_booking"));
                c1.setRoom_no(rs.getString("room_no"));
                c1.setStatus(rs.getString("status"));
                c1.setRoom_cap(rs.getString("room_cap"));
                c1.setBookingId(rs.getString("booking_id"));
                
                res = c1;
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDAO.closeCon(con);
        }
        return res;
    }
     
     
     
     
     
     
     public static void update(booking_detail c1) {
        Connection con = null;
        try {
            //Date obj =new Date();
            con = getCon();
            String sql = "update booking_detail set   booking_id=?, room_no =? , status=? where id =?";
            int i = 1;
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(i++, c1.getBookingId());
            st.setString(i++, c1.getRoom_no());
            st.setString(i++, c1.getStatus());
            
           // st.setString(i++, c1.getEmail());
           // st.setString(i++, c1.getExpertise());
           // st.setString(i++, c1.getAvail_time());
            st.setString(i++, c1.getId());
            
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
    }
    
     
     
     
     
     
     
     
     
     
     public static  booking_detail searchById(String id) {
        booking_detail res = null;
        Connection con = null;
        try {
            con = getCon();
            String sql = "select * from booking_detail where id = ? ";
            PreparedStatement st = con.prepareStatement(sql);
            int i = 1;
            st.setString(i++, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                booking_detail c1 = new booking_detail();
                c1.setId(rs.getString("id")); 
                c1.setLec_name(rs.getString("lec_name"));
                c1.setEmail(rs.getString("email"));
                c1.setTime(rs.getString("time"));
                c1.setDuration(rs.getString("duration"));
                c1.setDate(rs.getString("date"));
                c1.setType_of_room(rs.getString("type_of_room"));
                c1.setAttendee_no(rs.getString("attendee_no"));
                c1.setReason(rs.getString("reason_for_booking"));
                c1.setRoom_no(rs.getString("room_no"));
                c1.setStatus(rs.getString("status"));
                c1.setRoom_cap(rs.getString("room_cap"));
                c1.setBookingId(rs.getString("booking_id"));
                                res = c1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return res;
    }
    
     
     
     public static booking_detail searchForPending(String type, String time,String date,String status){
        Connection con=null;
       booking_detail res=null;
        try {
            con= BaseDAO.getCon();
            String sql = "select * from booking_detail where type_of_room=? and time=? and date=? and status=?";
            PreparedStatement st= con.prepareStatement(sql);
            st.setString(1,type );
            st.setString(2, time);
            st.setString(3, date);
            st.setString(4, status);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                booking_detail c1= new booking_detail();
                c1.setId(rs.getString("id"));
                c1.setLec_name(rs.getString("lec_name"));
                c1.setEmail(rs.getString("email"));
                c1.setTime(rs.getString("time"));
                c1.setDuration(rs.getString("duration"));
                c1.setDate(rs.getString("date"));
                c1.setType_of_room(rs.getString("type_of_room"));
                c1.setAttendee_no(rs.getString("attendee_no"));
                c1.setReason(rs.getString("reason_for_booking"));
                c1.setRoom_no(rs.getString("room_no"));
                c1.setStatus(rs.getString("status"));
                c1.setRoom_cap(rs.getString("room_cap"));
                c1.setBookingId(rs.getString("booking_id"));
                                res = c1;
              
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDAO.closeCon(con);
        }
        return res;
    }
     
     
     
     public static booking_detail searchForApproved(String roomNo, String time,String date){
        Connection con=null;
       booking_detail res=null;
        try {
            con= BaseDAO.getCon();
            String sql = "select * from booking_detail where room_no=? and time=? and date=?";
            PreparedStatement st= con.prepareStatement(sql);
            st.setString(1,roomNo );
            st.setString(2, time);
            st.setString(3, date);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                booking_detail c1= new booking_detail();
                c1.setId(rs.getString("id"));
                c1.setLec_name(rs.getString("lec_name"));
                c1.setEmail(rs.getString("email"));
                c1.setTime(rs.getString("time"));
                c1.setDuration(rs.getString("duration"));
                c1.setDate(rs.getString("date"));
                c1.setType_of_room(rs.getString("type_of_room"));
                c1.setAttendee_no(rs.getString("attendee_no"));
                c1.setReason(rs.getString("reason_for_booking"));
                c1.setRoom_no(rs.getString("room_no"));
                c1.setStatus(rs.getString("status"));
                c1.setRoom_cap(rs.getString("room_cap"));
                c1.setBookingId(rs.getString("booking_id"));
                                res = c1;
              
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDAO.closeCon(con);
        }
        return res;
    }
     
     
     
    
}
