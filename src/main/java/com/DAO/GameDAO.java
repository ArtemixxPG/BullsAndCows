package com.DAO;

import com.Entity.Game;
import com.Entity.Player;
import com.dbconnection.HibernetConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
//DAO игры
public class GameDAO {
    public Game findByID(Long id){
        return HibernetConnection.getSessionFactory().openSession().get(Game.class, id);
    }

//сохранение
    public void save(Game game){
        Session session = HibernetConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(game);
        transaction.commit();
        session.close();
    }
//измение
    public void update(Game game){
        Session session = HibernetConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(game);
        transaction.commit();
        session.close();
    }
//удаление
    public void delete(Long id){
        Session session = HibernetConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.get(Game.class, id));
        transaction.commit();
        session.close();
    }
//получение всех игр, которые сыграл игрок
    public List<Game> getAll(Long id){
        List<Game> games = (List<Game>)HibernetConnection.getSessionFactory().openSession().
                createQuery("select g from Game as g join  g.player as p where p.id =:id").setParameter("id", id).list();

        return games;
    }
}
