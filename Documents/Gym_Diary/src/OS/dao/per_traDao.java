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
import OS.bean.per_tra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author user
 */
public class per_traDao extends BaseDAO {
    
    public static LinkedList<per_tra> search(String sc, String si) {
        LinkedList<per_tra> res = new LinkedList<>();
        Connection con = null;
        try {
            con = getCon();
            String sql = "select * from per_tra where " + sc + " like ? ";
            int i = 1;
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(i++, "%" + si + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                per_tra c1 = new per_tra();
                c1.setId(rs.getString("id")); 
                c1.setPt_name(rs.getString("pt_name"));
                c1.setPass(rs.getString("pass"));
                c1.setEmail(rs.getString("email"));
                c1.setExpertise(rs.getString("expertise"));
                c1.setAvail_time(rs.getString("Avail_time"));
               
                res.add(c1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return res;
    }
    
    
    public static void insert(per_tra c1) {
        Connection con = null;
        try {
           // Date obj =new Date();
            con = getCon();
            //pt_name varchar(45), pass varchar(45),  expertise varchar(100), Avail_time varchar(30) 
            String sql = "insert into per_tra ( pt_name , email,pass , expertise, Avail_time) values (?, ?, ?, ?, ?)";
            int i = 1;
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(i++, c1.getPt_name());
            
            st.setString(i++, c1.getEmail());
            st.setString(i++, c1.getPass());
            st.setString(i++, c1.getExpertise());
            st.setString(i++, c1.getAvail_time());
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
            String sql = "delete from per_tra where id = ? ";
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
    
    
     public static void update(per_tra c1) {
        Connection con = null;
        try {
            Date obj =new Date();
            con = getCon();
            String sql = "update per_tra set  pt_name =? , pass=? ,email=?, expertise=?, Avail_time=? where id =?";
            int i = 1;
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(i++, c1.getPt_name());
            st.setString(i++, c1.getPass());
            st.setString(i++, c1.getEmail());
            st.setString(i++, c1.getExpertise());
            st.setString(i++, c1.getAvail_time());
            
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
    }
    
    
     
     
     public static  per_tra searchById(String id) {
        per_tra res = null;
        Connection con = null;
        try {
            con = getCon();
            String sql = "select * from per_tra where id = ? ";
            PreparedStatement st = con.prepareStatement(sql);
            int i = 1;
            st.setString(i++, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                per_tra c1 = new per_tra();
                c1.setId(rs.getString("id"));
                
                c1.setPt_name(rs.getString("pt_name"));
                c1.setPass(rs.getString("pass"));
                c1.setEmail(rs.getString("email"));
                c1.setAvail_time(rs.getString("Avail_time"));
                c1.setExpertise(rs.getString("expertise"));
                res = c1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return res;
    }
    
    
     
     
     
     public static per_tra searchUser(String name,String pass){
        Connection con=null;
       per_tra res=null;
        try {
            con= BaseDAO.getCon();
            String sql="select * from per_tra where pt_name=? and pass=?";
            PreparedStatement st= con.prepareStatement(sql);
            st.setString(1,name );
            st.setString(2, pass);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                per_tra c1 = new per_tra();
                c1.setId(rs.getString("id"));
                
                c1.setPt_name(rs.getString("pt_name"));
                c1.setPass(rs.getString("pass"));
                c1.setEmail(rs.getString("email"));
                c1.setAvail_time(rs.getString("Avail_time"));
                c1.setExpertise(rs.getString("expertise"));
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
     
     
     
     
     public static  LinkedList<String>  searchByFocus(String focus, String time) {
        LinkedList<String> res = new LinkedList<String>();
        Connection con = null;
        
        try {
            con = getCon();
            String sql = "select distinct(pt_name) from per_tra where expertise=? and Avail_time=?";
            PreparedStatement st = con.prepareStatement(sql);
            //int i=1;
            st.setString(1, focus);
            st.setString(2, time);
            
           // st.setString(i++, "%" + focus + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                res.add(rs.getString("pt_name"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return res;
    }
     
    
}
