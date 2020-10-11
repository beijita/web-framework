package com.fanzs.controller;

import com.fanzs.entity.Spu;
import com.fanzs.service.SpuService;
import com.fanzs.service.impl.SpuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/goods/spu")
public class SpuController extends HttpServlet {

    private SpuService spuService;

    @Override
    public void init() throws ServletException {
        spuService = new SpuServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Spu> spuList = spuService.listAllSpu();
        req.setAttribute("spuList", spuList);
        req.getRequestDispatcher("/WEB-INF/jsp/spu.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public List<Spu> listSpu(List<Long> spuCodeList) {
        List<Spu> spuList = new ArrayList<>();
        return spuList;
    }

    public List<Spu> addSpu() {
        List<Spu> spuList = new ArrayList<>();
        return spuList;
    }
}
