package com.Entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data()
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name = "PLAYER")
@JsonPropertyOrder({ "nickName", "password"})
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
//Ник
    @Column(name = "NICKNAME")
    private String nickName;
//Пароль
    @Column(name = "PASSWORD")
    private String password;
//Роль: Пользователь, либо Неизвестный, необходимо для авторизации
    @Column(name = "ROLE")
    private ROLE role;

//Рейтинг
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RAYTING")
    private Rayting rayting;
//Игры, которые были сыграны
    @Transient
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "player")
    private List<Game> games;
    public Player() {
        id = null;
        nickName = "";
        password = "";
        rayting = null;
    }
    public enum ROLE{
        USER, UNKNOWN
    }
}
