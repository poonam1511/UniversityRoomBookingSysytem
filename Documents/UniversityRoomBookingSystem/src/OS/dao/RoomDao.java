/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OS.dao;

import ECUtils.BaseDAO;
import static ECUtils.BaseDAO.closeCon;
import static ECUtils.BaseDAO.getCon;
import OS.bean.room_detail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author user
 */
public class RoomDao extends BaseDAO {
    public static LinkedList<room_detail> search(String sc, String si) {
        LinkedList<room_detail> res = new LinkedList<>();
        Connection con = null;
        try {
            con = getCon();
            String sql = "select * from room_detail where " + sc + " like ? ";
            int i = 1;
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(i++, "%" + si + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                room_detail c1 = new room_detail();
                c1.setId(rs.getString("id")); 
                c1.setRoom_no(rs.getString("room_no"));
                c1.setType_of_room(rs.getString("type_of_room"));
                c1.setRoom_cap(rs.getString("room_cap"));
                
                res.add(c1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return res;
    }
    
    
    
    
    
    
    
       public static void insert(room_detail c1) {
        Connection con = null;
        try {
           // Date obj =new Date();
            con = getCon();
            //pt_name varchar(45), pass varchar(45),  expertise varchar(100), Avail_time varchar(30) 
            String sql = "insert into room_detail (room_no ,type_of_room,room_cap) values (?, ?, ?)";
            int i = 1;
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(i++, c1.getRoom_no());  
            st.setString(i++, c1.getType_of_room());
            st.setString(i++, c1.getRoom_cap());
           // st.setString(i++, c1.getId());
            
            
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
    }
       
       
        public static  LinkedList<String>  searchForRoomNo(String type, String cap) {
        LinkedList<String> res = new LinkedList<String>();
        Connection con = null;
        
        try {
            con = getCon();
            String sql = "select distinct(room_no) from room_detail where type_of_room=? and room_cap=?";
            PreparedStatement st = con.prepareStatement(sql);
            //int i=1;
            st.setString(1, type);
            st.setString(2, cap);
            
           // st.setString(i++, "%" + focus + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                res.add(rs.getString("room_no"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return res;
    }
    
    
    
    
    
        
        
        public static  room_detail searchByRoomNo(String RoomNo) {
        room_detail res = null;
        Connection con = null;
        try {
            con = getCon();
            String sql = "select * from room_detail where room_no = ? ";
            PreparedStatement st = con.prepareStatement(sql);
            int i = 1;
            st.setString(i++, RoomNo);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                room_detail c1 = new room_detail();
                c1.setId(rs.getString("id")); 
                c1.setRoom_no(rs.getString("room_no"));
                c1.setType_of_room(rs.getString("type_of_room"));
                c1.setRoom_cap(rs.getString("room_cap"));                                
                res = c1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return res;
    }
    
    
    
         public static void delete(String id) {
        Connection con = null;
        try {
            con = getCon();
            String sql = "delete from room_detail where id = ? ";
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
         
         
         public static  room_detail searchById(String id) {
        room_detail res = null;
        Connection con = null;
        try {
            con = getCon();
            String sql = "select * from room_detail where id = ? ";
            PreparedStatement st = con.prepareStatement(sql);
            int i = 1;
            st.setString(i++, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                room_detail c1 = new room_detail();
                c1.setId(rs.getString("id")); 
                
                c1.setType_of_room(rs.getString("type_of_room"));
                
                c1.setRoom_no(rs.getString("room_no"));
                
                c1.setRoom_cap(rs.getString("room_cap"));
                
                                res = c1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return res;
    }
         
         
         
         
         
         
         
         
         
         
         
         
         public static void update(room_detail c1) {
        Connection con = null;
        try {
            //Date obj =new Date();
            con = getCon();
            String sql = "update room_detail set   room_no =? , room_cap=? ,type_of_room=? where id =?";
            int i = 1;
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(i++, c1.getRoom_no());
            st.setString(i++, c1.getRoom_cap());
            st.setString(i++, c1.getType_of_room());
            
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
        
        
        
        
    
    
    
}
