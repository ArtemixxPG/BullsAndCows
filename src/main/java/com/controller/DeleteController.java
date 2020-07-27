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

//Контроллер для удаления пользователя
@WebServlet("/delete")
public class DeleteController extends HttpServlet {

    private ServicePlayer servicePlayer = new ServicePlayerImpl();

    private static String indexLogin = "/WEB-INF/view/login.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Player player = (Player)session.getAttribute("player");
        servicePlayer.delete(player.getId());
        session.invalidate();
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(indexLogin);
        requestDispatcher.forward(req, resp);
    }
}
