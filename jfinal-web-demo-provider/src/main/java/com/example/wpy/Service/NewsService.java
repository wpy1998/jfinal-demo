package com.example.wpy.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class NewsService {
    /*
create table newsTable(
id int auto_increment primary key,
title varchar(50) NOT NULL,
content varchar(500) NOT NULL
);
    * */
    public void find(JSONArray jsonArray){
        try {
            Connection connection = ConnectionService.getConnection();
            String sql = "select * from newsTable";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("title", rs.getString("title"));
                jsonObject.put("content", rs.getString("content"));
                jsonArray.add(jsonObject);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
