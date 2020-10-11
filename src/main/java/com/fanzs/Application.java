package com.fanzs;

public class Application {

    public static void main(String[] args) {
        Class<Application> applicationClass = Application.class;
        Application application = new Application();
        Class<? extends Application> aClass = application.getClass();

        try {
            Class<?> aClass1 = Class.forName("com.fanzs.Application");
            System.out.println(aClass == applicationClass);
            System.out.println(aClass == aClass1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
