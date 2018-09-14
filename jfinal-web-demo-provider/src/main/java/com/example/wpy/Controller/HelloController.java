package com.example.wpy.Controller;

import com.jfinal.core.Controller;

public class HelloController extends Controller {
    public void index(){
        renderText("hello world!");
    }
}
