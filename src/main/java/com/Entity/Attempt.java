package com.Entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.hibernate.hql.internal.ast.tree.UnaryArithmeticNode;

import javax.persistence.*;
import java.util.Random;
//Сущность попытки
@Data
@Entity
@Table(name = "ATTEMPT")
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
//Генерируемое число компьютером
    @Column(name = "INPUT")
    private String input;
//Ответ
    @Column(name = "OUTPUT")
    private String output;
    //Введённое число пользователем
    @Column(name = "INPUTPLAYER")
    private String inputPlayer;

    //Игра, к которой принадлежит попытка
    @ManyToOne(fetch = FetchType.LAZY)
    private Game game;

    public Attempt(){}




}
