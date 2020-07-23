/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OS.dao;

import ECUtils.BaseDAO;
import static ECUtils.BaseDAO.closeCon;
import static ECUtils.BaseDAO.getCon;
import OS.bean.client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author user
 */
public class ClientDao extends BaseDAO {
    
    public static LinkedList<client> search(String sc, String si) {
        LinkedList<client> res = new LinkedList<>();
        Connection con = null;
        try {
            con = getCon();
            String sql = "select * from client where " + sc + " like ? ";
            int i = 1;
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(i++, "%" + si + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                client c1 = new client();
                c1.setId(rs.getString("id"));
                c1.setClient_name(rs.getString("client_name"));
                c1.setPt_name(rs.getString("pt_name"));
                c1.setFocus(rs.getString("focus"));
                c1.setEmail(rs.getString("email"));
                c1.setPass(rs.getString("pass"));
                c1.setTime(rs.getString("time"));
                c1.setDuration(rs.getString("duration"));
                c1.setDate(rs.getString("date"));
                res.add(c1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return res;
    }
    
    
    
    
    
    
    public static void insert(client c1) {
        Connection con = null;
        try {
           // Date obj =new Date();
            con = getCon();
            //client_name varchar(45), pass varchar(45), pt_name varchar(45),email varchar(20), date varchar(20), time varchar(20), duration varchar(30), focus varchar(40),  PRIMARY KEY (id))",
            String sql = "insert into client (client_name , pt_name , pass , email ,date, time ,duration, focus) values (?, ?, ?,?, ?,?,?,?)";
            int i = 1;
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(i++, c1.getClient_name());
            st.setString(i++, c1.getPt_name());
            st.setString(i++, c1.getPass());
            st.setString(i++, c1.getEmail());
            st.setString(i++, c1.getDate());  
            st.setString(i++, c1.getTime());
            st.setString(i++, c1.getDuration());
            st.setString(i++, c1.getFocus());
            
            
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
            String sql = "delete from client where id = ? ";
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
    
    
    
     
     
     public static void update(client c1) {
        Connection con = null;
        try {
           // Date obj =new Date();
            con = getCon();
            String sql = "update client set client_name  = ?, pt_name =? , pass=? , email=?, focus=? , time=? ,duration=?,date=? where id =?";
            int i = 1;
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(i++, c1.getClient_name());
            st.setString(i++, c1.getPt_name());
            st.setString(i++, c1.getPass());
            st.setString(i++, c1.getEmail());
            st.setString(i++, c1.getFocus());
            st.setString(i++, c1.getTime());
            st.setString(i++, c1.getDuration());
            st.setString(i++, c1.getDate());
            st.setString(i++, c1.getId());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
    }
    
    
     
     
     
     public static  client searchById(String id) {
        client res = null;
        Connection con = null;
        try {
            con = getCon();
            String sql = "select * from client where id = ? ";
            PreparedStatement st = con.prepareStatement(sql);
            int i = 1;
            st.setString(i++, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                client c1 = new client();
                c1.setId(rs.getString("id"));
                c1.setClient_name(rs.getString("client_name"));
                c1.setPt_name(rs.getString("pt_name"));
                c1.setFocus(rs.getString("focus"));
                c1.setEmail(rs.getString("email"));
                c1.setPass(rs.getString("pass"));
                c1.setTime(rs.getString("time"));
                c1.setDate(rs.getString("date"));
                c1.setDuration(rs.getString("duration"));
                res = c1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return res;
    }
    
     
     
     public static client searchUser(String name,String pass){
        Connection con=null;
       client res=null;
        try {
            con= BaseDAO.getCon();
            String sql="select * from client where client_name=? and pass=?";
            PreparedStatement st= con.prepareStatement(sql);
            st.setString(1,name );
            st.setString(2, pass);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                client c1= new client();
                c1.setId(rs.getString("id"));
                c1.setClient_name(rs.getString("client_name"));
                c1.setPt_name(rs.getString("pt_name"));
                c1.setFocus(rs.getString("focus"));
                c1.setEmail(rs.getString("email"));
                c1.setPass(rs.getString("pass"));
                c1.setTime(rs.getString("time"));
                c1.setDate(rs.getString("date"));
                c1.setDuration(rs.getString("duration"));
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
     
     
     
     public static client searchByFocus(String Pt_name, String time){
        Connection con=null;
       client res=null;
        try {
            con= BaseDAO.getCon();
            String sql = "select * from client where pt_name=? and time=?";
            PreparedStatement st= con.prepareStatement(sql);
            st.setString(1,Pt_name );
            st.setString(2, time);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                client c1= new client();
                c1.setId(rs.getString("id"));
                c1.setClient_name(rs.getString("client_name"));
                c1.setPt_name(rs.getString("pt_name"));
                c1.setFocus(rs.getString("focus"));
                c1.setEmail(rs.getString("email"));
                c1.setPass(rs.getString("pass"));
                c1.setTime(rs.getString("time"));
                c1.setDate(rs.getString("date"));
                c1.setDuration(rs.getString("duration"));
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
