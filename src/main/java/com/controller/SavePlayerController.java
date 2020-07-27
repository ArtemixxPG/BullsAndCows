package com.controller;

import com.Entity.Player;
import com.Entity.Rayting;
import com.service.ServicePlayer;
import com.service.ServicePlayerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//Контроллер для работы с пользователем
@WebServlet("/")
public class SavePlayerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServicePlayer servicePlayer = new ServicePlayerImpl();

    private static String indexHome = "/WEB-INF/view/home.jsp";
    private static String indexLogin = "/WEB-INF/view/login.jsp";
    private static String indexPrivateAccount = "/WEB-INF/view/privateaccount.jsp";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(indexLogin);

        requestDispatcher.forward(req, resp);

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
            final String name = req.getParameter("name");
            final String password = req.getParameter("password");

            Player player = new Player();
        Rayting rayting = new Rayting();
            player.setPassword(password);
            player.setNickName(name);
            player.setRayting(rayting);
            rayting.setPlayer(player);

            servicePlayer.save(player);
        session.setAttribute("player", player);
        //System.out.println(player);
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(indexHome);

        requestDispatcher.forward(req, resp);
    }




}
