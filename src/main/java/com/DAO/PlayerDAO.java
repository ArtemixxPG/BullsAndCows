package com.DAO;

import com.Entity.Player;
import com.dbconnection.HibernetConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//DAO пользователя
public class PlayerDAO {
//поиск по ID
    public Player findByID(Long id){

        return HibernetConnection.getSessionFactory().openSession().get(Player.class, id);
    }
//поиск по логину и паролю
    public Player findByLoginAndPassword(String login, String password){
        Player player = (Player) HibernetConnection.getSessionFactory().openSession().
                createQuery("select p from Player as p where p.nickName=:login and p.password=:password").
                setParameter("login", login).setParameter("password", password).uniqueResult();
        System.out.println(player);
        return player;
    }
//сохранение
    public void save(Player player){
        Session session = HibernetConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(player);
        transaction.commit();
        session.close();
    }
//редактирование
    public void update(Player player){
        Session session = HibernetConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(player);
        transaction.commit();
        session.close();
    }
//удаление
    public void delete(Long id){
        Session session = HibernetConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.get(Player.class, id));
        transaction.commit();
        session.close();
    }
//получение всех пользователей
    public List<Player> getAll(){
        Session session = HibernetConnection.getSessionFactory().openSession();

        List<Player> players = (ArrayList<Player>)HibernetConnection.getSessionFactory().openSession().
                createQuery("from Player").list();
        return players;
    }
//составление списка на основе рейтинга
    public List<Player> getAllRayting(){
        List<Player> players = (ArrayList<Player>)HibernetConnection.getSessionFactory().openSession().
                createQuery("from Player").list();
        //создание массива рейтинга
        List<Player> rayting = new ArrayList<>();
        //включение в него элементов, которые не содержат null поле рейтинга
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).getRayting().getScore()!=(long)0 || players.get(i).getRayting() != null){
                System.out.println(players.get(i));
                rayting.add(players.get(i));

            }
        }
        //сортировка списка рейтинга
            rayting.sort(new Comparator<Player>() {
                @Override
                public int compare(Player o1, Player o2) {
                    if (o1.getRayting().getScore() == o2.getRayting().getScore())
                        return 0;
                    else if (o1.getRayting().getScore() > o2.getRayting().getScore())
                        return 1;
                    else return -1;
                }
            });

        return rayting;
    }


}
