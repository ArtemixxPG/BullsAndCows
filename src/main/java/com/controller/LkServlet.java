package com.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Контроллер для перехода на страницу личного кабинета
@WebServlet("/lk")
public class LkServlet extends HttpServlet{
        private static String index = "/WEB-INF/view/privateaccount.jsp";
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(index);

            requestDispatcher.forward(req, resp);
        }
}
