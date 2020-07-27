package com.service;

import com.DAO.GameDAO;
import com.Entity.Attempt;
import com.Entity.Game;

import java.util.ArrayList;
import java.util.List;

public class ServiceGameImpl implements ServiceGame {

    private GameDAO gameDAO = new GameDAO();
    private ServiceAttempt serviceAttempt = new ServiceAttemptImpl();

    @Override
    public Game getGame(Long id) {
        return gameDAO.findByID(id);
    }

    @Override
    public Long getScore(Long id) {
        long score = 0;
        List<Attempt> attempts = serviceAttempt.getAllForGame(id);
        return Long.valueOf(attempts.size());
    }

    @Override
    public List<Game> getGames(Long id) {
        return gameDAO.getAll(id);
    }

    @Override
    public List<Attempt> getAttempts(Long id) {
        return null;
    }

    @Override
    public void save(Game game) {
        gameDAO.save(game);
    }

    @Override
    public void delete(Long id) {
        gameDAO.delete(id);
    }

    @Override
    public void update(Game game) {
        gameDAO.update(game);
    }
}
