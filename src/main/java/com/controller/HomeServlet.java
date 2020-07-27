package com.controller;

import com.service.ServicePlayer;
import com.service.ServicePlayerImpl;
import sun.misc.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


//Контроллер для перехода на домашнюю страницу
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    
    private static String index = "/WEB-INF/view/home.jsp";
    ServicePlayer servicePlayer = new ServicePlayerImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {




        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(index);

        requestDispatcher.forward(req, resp);
    }
}
