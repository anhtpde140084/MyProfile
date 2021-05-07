package com.laptrinhjava.myinfor.DAO;

import com.laptrinhjava.myinfor.model.InforAccount;

import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class InforAccountDAO extends BaseDAO {

    public InforAccount GetInfor() {
        InforAccount acc = null;
        try {

            PreparedStatement ps = connection.prepareStatement("select * from InforAcc");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idAcc = rs.getInt(1);
                String name = rs.getString(2);
                String birthday = rs.getString(3);
                int age = rs.getInt(4);
                String country = rs.getString(5);
                String city = rs.getString(6);
                String email = rs.getString(7);
                acc = new InforAccount(idAcc, name, age, country, city, email, birthday);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return acc;
    }

    public InforAccount GetAccout(String username) {
        InforAccount acc = null;
        try {

            PreparedStatement ps = connection.prepareStatement("select * from InforAcc where username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idAcc = rs.getInt(1);
                String name = rs.getString(2);
                String birthday = rs.getString(3);
                int age = rs.getInt(4);
                String country = rs.getString(5);
                String city = rs.getString(6);
                String email = rs.getString(7);
                acc = new InforAccount(idAcc, name, age, country, city, email, birthday);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return acc;
    }

    public int checkLogin(String username, String password) {

        PreparedStatement stm = null;
        ResultSet rs = null;
        InforAccount ad = null;
        int rc = 0;
        String sql = "Select * from InforAcc where username=? and password=?";
        try {

            stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if (rs.next()) {
                rc=1;
            }
            stm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rc;
    }

    public static void main(String[] args) throws Exception {
        InforAccountDAO dao = new InforAccountDAO();
        InforAccount acc = dao.GetInfor();
        System.out.println(acc.toString());
        int r = dao.checkLogin("tranphianh", "anhanh11");
        if(r>0){
            System.out.println("ok");
        }
    }
}
