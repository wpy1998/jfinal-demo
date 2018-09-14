package com.example.wpy.Controller;

import com.alibaba.fastjson.JSONObject;
import com.example.wpy.Service.UserService;
import com.jfinal.core.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterController extends Controller {
    public void index() throws ParseException {
        get();
    }

    public void post() throws ParseException {
        UserService userService = new UserService();
        userService.phone = getPara("phone");
        userService.password = getPara("password");
        String birthday = getPara("birthday");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(birthday);
        userService.birthday = new java.sql.Date(date.getTime());
        boolean end = userService.insert();
        if (end){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", "success");
            renderText(jsonObject.toString());
        }else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", "fail");
            renderText(jsonObject.toString());
        }
    }

    public void get() throws ParseException {
        post();
    }
}
