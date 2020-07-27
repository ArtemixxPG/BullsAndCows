package com.service;

import com.DAO.PlayerDAO;
import com.Entity.Game;
import com.Entity.Player;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;

public class ServicePlayerImpl implements ServicePlayer{
    private PlayerDAO dao = new PlayerDAO();
    @Override
    public Player getPlayer(Long id) {
        return dao.findByID(id);
    }

    @Override
    public Long getScore(Long id) {
        return null;
    }

    @Override
    public ArrayList<Game> getGames(Long id) {
        return (ArrayList)dao.findByID(id).getGames();
    }

    @Override
    public void save(Player player) {
        player.setPassword(passwordEncoder(player.getPassword()));
        player.setRole(Player.ROLE.USER);
        dao.save(player);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public void update(Player player) {
        player.setPassword(passwordEncoder(player.getPassword()));
        dao.update(player);
    }

    @Override
    public List<Player> getAllRayting() {
        return dao.getAllRayting();
    }


    private static String passwordEncoder(String password){
        String passwordHash = DigestUtils.md5Hex(password);
        return passwordHash;
    }
    //проверка есть ли такой пользователь в системе
    @Override
    public boolean playerIsExist(String login, String password){
        List<Player> players = dao.getAll();
        boolean result = false;
        for(Player player:players){
            if(player.getNickName().equals(login)&&player.getPassword().equals(password)){
                result = true;
            }

        }
        return result;
    }

    @Override
    public Player findByLoginAndPassword(String login, String password) {
        return dao.findByLoginAndPassword(login, password);
    }
}
