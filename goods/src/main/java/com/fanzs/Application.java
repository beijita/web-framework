package com.fanzs;

import com.fanzs.service.SpuService;
import com.fanzs.service.impl.SpuServiceImpl;

public class Application {

    public static void main(String[] args) {
        SpuService spuService = new SpuServiceImpl();
        System.out.println(spuService);
    }
}
