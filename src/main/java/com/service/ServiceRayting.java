package com.service;

import com.Entity.Player;
import com.Entity.Rayting;
import com.dbconnection.HibernetConnection;

public interface ServiceRayting {
    Rayting findById(Long id);
    void save(Rayting rayting);
    void delete(Rayting rayting);
    void update(Rayting rayting);

}
