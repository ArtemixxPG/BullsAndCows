package com.service;

import com.DAO.AttemptDAO;
import com.Entity.Attempt;

import java.util.List;

public class ServiceAttemptImpl implements ServiceAttempt {

    private AttemptDAO attemptDAO = new AttemptDAO();
    @Override
    public Attempt findById(Long id) {
        return attemptDAO.findById(id);
    }

    @Override
    public void save(Attempt attempt) {
        attemptDAO.save(attempt);
    }

    @Override
    public void delete(Attempt attempt) {
        attemptDAO.delete(attempt);
    }

    @Override
    public void update(Attempt attempt) {
        attemptDAO.update(attempt);
    }

    @Override
    public List<Attempt> getAllForGame(Long id) {
        return attemptDAO.getAllForGame(id);
    }
}
