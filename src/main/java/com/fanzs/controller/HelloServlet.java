package com.fanzs.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        String currentTime = dateFormat.format(new Date());
        req.setAttribute("currentTime", currentTime);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp");
        requestDispatcher.forward(req, resp);
        return;
    }
}
