package com.example.wpy.Controller;

import com.alibaba.fastjson.JSONArray;
import com.example.wpy.Service.NewsService;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;

@Before(GET.class)
public class NewsController extends Controller {
    public void index(){
        get();
    }

    public void get(){
        NewsService service = new NewsService();
        JSONArray array = new JSONArray();
        service.find(array);
        renderText(array.toString());
    }
}
