package com.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="GAME")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

//Попытки, сделанные в ппроцессе этой игры
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ATTEMPT")
    private List<Attempt> attempts;
//Игрок, чей сеанс игры сейчас идёт
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PLAYER")
    private Player player;


    public Game(){
        player = null;


    }
}
