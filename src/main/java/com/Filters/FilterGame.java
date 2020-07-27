package com.Filters;

import com.DAO.AttemptDAO;
import com.Entity.Attempt;
import com.Entity.Game;
import com.Entity.Player;
import com.Entity.Rayting;
import com.logic.GameLogic;
import com.service.*;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//Обработка игры
@WebFilter("/game")
public class FilterGame implements Filter {

    private static String pathContinious = "/WEB-INF/view/mainactivity.jsp";
    private static String pathGameOver = "/WEB-INF/view/congratulation.jsp";

    ServiceAttempt serviceAttempt = new ServiceAttemptImpl();
    ServiceGame serviceGame = new ServiceGameImpl();
    ServicePlayer servicePlayer = new ServicePlayerImpl();
    ServiceRayting serviceRayting = new ServiceRaytingImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        HttpSession session = httpServletRequest.getSession();
        //Определение попыток, если не было, то создаётся новая, иначе берутся параметры из старой
        if(session.getAttribute("attempt")==null){
            GameLogic gameLogic = new GameLogic();
            Attempt attempt = new Attempt();
            attempt.setInput((String)session.getAttribute("input"));
            attempt.setInputPlayer(httpServletRequest.getParameter("answer"));
            attempt.setGame((Game)session.getAttribute("game"));

            attempt.setOutput(gameLogic.getAnswer(attempt.getInput(),
                    attempt.getInputPlayer()));

            serviceAttempt.save(attempt);
            session.setAttribute("attempt", attempt);
        } else {
            GameLogic gameLogic = new GameLogic();
            Attempt attempt = new Attempt();
            Attempt oldAttempt = (Attempt)session.getAttribute("attempt");
            attempt.setInput(oldAttempt.getInput());
            attempt.setInputPlayer(httpServletRequest.getParameter("answer"));
            attempt.setGame((Game)session.getAttribute("game"));

            attempt.setOutput(gameLogic.getAnswer(attempt.getInput(),
                    attempt.getInputPlayer()));

            session.removeAttribute("attempt");
            serviceAttempt.save(attempt);
            session.setAttribute("attempt", attempt);
        }
        //Взависимости от попытки: либо игра продолжается, либо переход на страницу победы
        Game game = (Game)session.getAttribute("game");
        session.setAttribute("attempts", serviceAttempt.getAllForGame(game.getId()));
        jump(httpServletRequest, httpServletResponse);
    }
// реализация пекрехода на страницу и обновление рейтинга
    private void jump(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Attempt attempt = (Attempt)session.getAttribute("attempt");
        if(attempt.getInput().equals(attempt.getInputPlayer())){
            Game game = (Game) session.getAttribute("game");
            long rayting = serviceGame.getScore(game.getId());
            Player player = (Player) session.getAttribute("player");
            if(player.getRayting().getScore()==0 || player.getRayting().getScore()>rayting) {
                player.getRayting().setScore(rayting);
                servicePlayer.update(player);
                serviceRayting.update(player.getRayting());
                Player player1 = servicePlayer.getPlayer(((Player) session.getAttribute("player")).getId());
//
                session.removeAttribute("player");
                session.setAttribute("player", player1);
            }
            request.getRequestDispatcher(pathGameOver).forward(request, response);
        } else {

            request.getRequestDispatcher(pathContinious).forward(request, response);

        }
        session.removeAttribute("attempt");
    }

    @Override
    public void destroy() {

    }
}
