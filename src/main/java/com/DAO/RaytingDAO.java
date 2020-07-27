package com.DAO;

import com.Entity.Attempt;
import com.Entity.Rayting;
import com.dbconnection.HibernetConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
//DAO рейтинга
public class RaytingDAO {
    //нахождение элемента по ID
    public Rayting findById(Long id){
        return HibernetConnection.getSessionFactory().openSession().get(Rayting.class, id);
    }
//сохранение
    public void save(Rayting rayting){
        Session session = HibernetConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(rayting);
        transaction.commit();
        session.close();
    }
//удаление
    public void delete(Rayting rayting){
        Session session = HibernetConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(rayting);
        transaction.commit();
        session.close();
    }
//изменение
    public void update(Rayting rayting){
        Session session = HibernetConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(rayting);
        transaction.commit();
        session.close();
    }


}
