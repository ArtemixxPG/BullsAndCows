package com.Filters;

import com.DAO.PlayerDAO;
import com.Entity.Player;
import com.service.ServicePlayer;
import com.service.ServicePlayerImpl;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;
//Фильтр авторизации
@WebFilter("/auth")
public class FilterAuthorization implements Filter {

    ServicePlayer servicePlayer = new ServicePlayerImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
         HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
         HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
         //Получение логина и пароля из строки запроса
         String login = httpServletRequest.getParameter("login");
         String password = httpServletRequest.getParameter("password");
         //Шифрование пароля
         password = DigestUtils.md5Hex(password);

         @SuppressWarnings("unchecked")

        HttpSession session = httpServletRequest.getSession();
//Проверка существует ли сессия с данным пользователем
        if(nonNull(session)&&nonNull(session.getAttribute("login"))&&nonNull(session.getAttribute("password"))){
// Если да, то переход на домашную страницу
            Player.ROLE role = (Player.ROLE) session.getAttribute("role");

            jump(httpServletRequest, httpServletResponse, role);


        }
        // если не существуют, поиск пользователяв базе, если найден переход на домашнюю страницу
        else if(servicePlayer.playerIsExist(login, password)){
            Player player = servicePlayer.findByLoginAndPassword(login, password);
            System.out.println(player);
            httpServletRequest.getSession().setAttribute("player", player);

            jump(httpServletRequest, httpServletResponse, player.getRole());

        }
        else {
            jump(httpServletRequest, httpServletResponse, Player.ROLE.UNKNOWN);
        }
    }

    @Override
    public void destroy() {

    }

//Реализация перехода между страницами
    private void jump(HttpServletRequest request, HttpServletResponse response, Player.ROLE role) throws
            ServletException, IOException{
        if(role.equals(Player.ROLE.USER)){
            request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
        }
        if(role.equals(Player.ROLE.UNKNOWN)){
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
        }
    }
}
