package com.controller;


import com.DAO.GameDAO;
import com.Entity.Game;
import com.Entity.Player;
import com.logic.GameLogic;
import javafx.print.PageLayout;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//Контроллер для создания новой игры
@WebServlet("/newgame")
public class NewGameServlet extends HttpServlet {
    private static String index = "/WEB-INF/view/mainactivity.jsp";
    private GameDAO gameDAO = new GameDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(index);

        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GameLogic logic = new GameLogic();
        String input = logic.createInput();
        HttpSession session = req.getSession();
        session.removeAttribute("attempts");
        session.removeAttribute("input");
        if(session.getAttribute("game")!=null){
            session.removeAttribute("game");
        }
        Game game = new Game();
        game.setPlayer((Player)session.getAttribute("player"));
        gameDAO.save(game);
        session.setAttribute("game", game);
        session.setAttribute("input", input);
        doGet(req, resp);
    }
}
