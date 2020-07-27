package com.service;

import com.Entity.Game;
import com.Entity.Player;

import java.util.ArrayList;
import java.util.List;

public interface ServicePlayer {
    Player getPlayer(Long id);
    Long getScore(Long id);
    ArrayList<Game> getGames(Long id);
    void save(Player player);
    void delete(Long id);
    void update(Player player);
    List<Player> getAllRayting();
    boolean playerIsExist(String login, String password);
    Player findByLoginAndPassword(String login, String password);
}
