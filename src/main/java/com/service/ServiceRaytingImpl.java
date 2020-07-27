package com.service;

import com.DAO.RaytingDAO;
import com.Entity.Rayting;

public class ServiceRaytingImpl implements ServiceRayting {

    private RaytingDAO raytingDAO = new RaytingDAO();

    @Override
    public Rayting findById(Long id) {
        return raytingDAO.findById(id);
    }

    @Override
    public void save(Rayting rayting) {
        raytingDAO.save(rayting);
    }

    @Override
    public void delete(Rayting rayting) {
        raytingDAO.delete(rayting);
    }

    @Override
    public void update(Rayting rayting) {
        raytingDAO.update(rayting);
    }
}
