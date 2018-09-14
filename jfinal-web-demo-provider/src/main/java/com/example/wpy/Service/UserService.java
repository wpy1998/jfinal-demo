package com.example.wpy.Service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UserService {
/*
create table userTable(
  id int auto_increment primary key ,
  name varchar(20),
  password varchar(20) NOT NULL ,
  age int,
  registerTime date,
  birthday date,
  gender varchar(5),
  phone varchar(20) NOT NULL
)
*/
    public String name;
    public String password;
    public int age;
    public java.sql.Date registerTime;
    public java.sql.Date birthday;
    public String phone;
    public String gender;
    public int id;

    private int userNumber;

    public boolean insert(){
        if (find("phone", phone)){
            return false;
        }

        Connection connection = ConnectionService.getConnection();
        String sql = "insert into userTable(name,password,age,registerTime,birthday,phone,gender) " +
                "value(?,?,?,?,?,?,?)";
        try {
            java.util.Date utilDate = new Date();
            registerTime = new java.sql.Date(utilDate.getTime());

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setInt(3, age);
            ps.setDate(4, registerTime);
            ps.setDate(5, birthday);
            ps.setString(6, phone);
            ps.setString(7, gender);
            ps.execute();
            ps.close();
            connection.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean find(String dataName, String data){
        try {
            Connection connection = ConnectionService.getConnection();
            String sql = "select * from userTable where " + dataName + "='" + data + "'";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            userNumber = 0;
            while (rs.next()){
                userNumber++;
            }
            rs.close();
            stmt.close();
            connection.close();
            if (userNumber > 0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(String dataName, String data){
        return false;
    }

    public boolean delete(){
        return false;
    }
}
