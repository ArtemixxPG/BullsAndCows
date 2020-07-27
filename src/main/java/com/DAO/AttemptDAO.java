package com.DAO;

import com.Entity.Attempt;
import com.dbconnection.HibernetConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
//DAO попытки
public class AttemptDAO {
    //Получение попытки по ID
    public Attempt findById(Long id){
        return HibernetConnection.getSessionFactory().openSession().get(Attempt.class, id);
    }
    //сохранение
    public void save(Attempt attempt){
        //Открытие сессии коннекта с базой данных
        Session session = HibernetConnection.getSessionFactory().openSession();
        //Начало тразакции
        Transaction transaction = session.beginTransaction();
        //Основное действие, в данном случае сохранение
        session.save(attempt);
        // Подтверждение действия
        transaction.commit();
        //Закрытие сессии
        session.close();
    }
    //удаление
    public void delete(Attempt attempt){
        Session session = HibernetConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(attempt);
        transaction.commit();
        session.close();
    }
    //измение
    public void update(Attempt attempt){
        Session session = HibernetConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(attempt);
        transaction.commit();
        session.close();
    }
    //получение всех попыток определённой игры
    public List<Attempt> getAllForGame(Long id){
        List<Attempt> attempts = (List<Attempt>)HibernetConnection.getSessionFactory().openSession().
                createQuery("select a from Attempt as a join a.game as g where g.id =:id").setParameter("id", id).list();
        return attempts;
    }
}
