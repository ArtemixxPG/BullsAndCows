package com.Entity;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "RAYTING")
@JsonPropertyOrder({"players", "date"})
public class Rayting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

//Наименьшее количество попыток для рейтинга
    @Column(name = "SCORE")
    private Long score;
//Игрок, чей рейтинг определяется
    @Transient
    @OneToOne
    @JoinColumn(name = "ID_PLAYER")
    private Player player;

    public Rayting(){
        this.score = (long)0;
    }
}
