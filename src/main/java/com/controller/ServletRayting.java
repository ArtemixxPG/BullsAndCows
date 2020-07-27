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
import java.util.List;
//Контроллер для работы с рейтингом
@WebServlet("/rayting")
public class ServletRayting extends HttpServlet{
    private static String index = "/WEB-INF/view/rayting.jsp";


    ServicePlayer servicePlayer = new ServicePlayerImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(index);

        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Player player = (Player) session.getAttribute("player");
        Player player1 = servicePlayer.getPlayer(player.getId());
        List<Player> rayting = servicePlayer.getAllRayting();
        session.setAttribute("rayting", rayting);
        doGet(req, resp);
    }

}
