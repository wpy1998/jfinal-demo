package com.example.wpy;

import com.example.wpy.Controller.HelloController;
import com.example.wpy.Controller.LoginController;
import com.example.wpy.Controller.NewsController;
import com.example.wpy.Controller.RegisterController;
import com.jfinal.config.*;
import com.jfinal.template.Engine;

public class DemoConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        constants.setDevMode(true);
        constants.setEncoding("utf-8");
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add("/hello", HelloController.class);
        routes.add("/register", RegisterController.class);
        routes.add("/login", LoginController.class);
        routes.add("/getNews", NewsController.class);
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {

    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
