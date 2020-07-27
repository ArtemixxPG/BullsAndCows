package com.dbconnection;

import com.Entity.Attempt;
import com.Entity.Game;
import com.Entity.Player;
//import org.h2.jdbc.JdbcConnection;
import com.Entity.Rayting;
import org.hibernate.SessionFactory;

import javax.security.auth.login.AppConfigurationEntry;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import org.hibernate.service.ServiceRegistry;

import java.io.File;
import java.util.HashMap;
import java.util.Properties;

public class HibernetConnection {
    private static SessionFactory sessionFactory;

    public HibernetConnection(){

    }
    public static SessionFactory getSessionFactory(){
//настройка подключения к БД
        if(sessionFactory == null) {
            try {
               Properties  hibernatePropertys = new Properties();
                hibernatePropertys.put(Environment.HBM2DDL_AUTO,"update");
                hibernatePropertys.put(Environment.DRIVER, "org.h2.Driver");
                hibernatePropertys.put(Environment.URL, "jdbc:h2:file:C:\\.\\..\\resources\\realize;AUTO_SERVER=TRUE");
                hibernatePropertys.put(Environment.USER, "admin");
                hibernatePropertys.put(Environment.PASS, "admin");
                hibernatePropertys.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
                hibernatePropertys.put(Environment.SHOW_SQL, "true");
                hibernatePropertys.put(Environment.GENERATE_STATISTICS, "true");
                hibernatePropertys.put(Environment.FORMAT_SQL, "true");
                hibernatePropertys.put(Environment.USE_SQL_COMMENTS, "true");
                //конфигурация
                Configuration configuration = new Configuration();
                configuration.setProperties(hibernatePropertys);
                configuration.addAnnotatedClass(Player.class);
                configuration.addAnnotatedClass(Game.class);
                configuration.addAnnotatedClass(Rayting.class);
                configuration.addAnnotatedClass(Attempt.class);


                ServiceRegistry builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(builder);
                System.out.println(sessionFactory);
            } catch (Exception e){
                System.out.println("Session is not connection!");
            }
        }
        //System.out.println(sessionFactory);
        return  sessionFactory;
    }

}
