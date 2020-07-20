/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OS.dao;

import ECUtils.BaseDAO;
import static ECUtils.BaseDAO.closeCon;
import static ECUtils.BaseDAO.getCon;
import OS.bean.staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author user
 */
public class StaffDao extends BaseDAO {
    public static staff validate(String uname, String pass){
        staff res = null;
        Connection con = null;
        try {
            con = getCon();
            String sql = "select * from staff where user_name = ? and pass = ?";
            int i = 1;
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(i++, uname);
            st.setString(i++, pass);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                staff s1 = new staff();
                s1.setUname(rs.getString("user_name"));
                s1.setUname(rs.getString("id"));
                s1.setUname(rs.getString("pass"));
                res=s1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            closeCon(con);
        }
        return res;
    }
    
}
