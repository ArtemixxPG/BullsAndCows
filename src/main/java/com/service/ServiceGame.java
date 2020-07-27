package com.service;

import com.Entity.Attempt;
import com.Entity.Game;
import com.Entity.Player;

import java.util.ArrayList;
import java.util.List;

public interface ServiceGame {
    Game getGame(Long id);
    Long getScore(Long id);
    List<Game> getGames(Long id);
    List<Attempt> getAttempts(Long id);
    void save(Game game);
    void delete(Long id);
    void update(Game game);

}
