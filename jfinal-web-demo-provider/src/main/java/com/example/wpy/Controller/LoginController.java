package com.example.wpy.Controller;

import com.alibaba.fastjson.JSONObject;
import com.example.wpy.Service.UserService;
import com.jfinal.core.Controller;

public class LoginController extends Controller {
    public void index(){
        post();
    }

    public void post(){
        UserService userService = new UserService();
        userService.phone = getPara("phone");
        userService.password = getPara("password");
        if (userService.find("phone", userService.phone) &&
                userService.find("password", userService.password)){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", "success");
            renderText(jsonObject.toString());
        }else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", "fail");
            renderText(jsonObject.toString());
        }
    }
}
