package com.controller;

import com.Entity.Player;
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
//Контроллер для измения информации пользователя
@WebServlet("/update")
public class UpdateController extends HttpServlet {
    private ServicePlayer servicePlayer = new ServicePlayerImpl();
    // public SavePlayerController(ServicePlayer servicePlayer){
//        this.servicePlayer = servicePlayer;
//    }
    private static String indexHome = "/WEB-INF/view/home.jsp";
    private static String indexLogin = "/WEB-INF/view/login.jsp";
    private static String indexPrivateAccount = "/WEB-INF/view/privateaccount.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Player player = (Player)session.getAttribute("player");
        session.removeAttribute("player");
        final String name = req.getParameter("name");
        final String password = req.getParameter("password");
        player.setPassword(password);
        player.setNickName(name);
        servicePlayer.update(player);
        session.setAttribute("player", player);
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(indexPrivateAccount);

        requestDispatcher.forward(req, resp);
    }
}
