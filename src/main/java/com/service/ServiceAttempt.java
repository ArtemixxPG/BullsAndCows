package com.service;

import com.Entity.Attempt;

import java.util.List;

public interface ServiceAttempt {
    public  Attempt findById(Long id);
    public void save(Attempt attempt);
    public void delete(Attempt attempt);
    public void update(Attempt attempt);
    public List<Attempt> getAllForGame(Long id);
}
