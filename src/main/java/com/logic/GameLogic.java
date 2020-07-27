package com.logic;

import lombok.Data;

import java.util.Random;

//логика игры
public class GameLogic {


    private int bulls;
    private int cows;
    private String answer;

    public GameLogic(){

        bulls = 0;
        cows = 0;
    }
    //генерация числа с учётом провекрки того, чтобы в нём не было одинаковых цифр
    public String createInput(){
        String s = createChislo();
        while (notDubl(s)){
            s = createChislo();
        }
        return s;
    }
    //создание числа
public String createChislo(){
    String s = null;
    int min = 1000;
    int max = 10000;
    int answ = 0;
    int dif = max - min;
    Random random = new Random();
    answ = random.nextInt(dif);
    answ+=min;
    s = Integer.toString(answ);
    return s;
}
//логика получения ответа
    public String getAnswer(String inComputer, String inPlayer){
        for(int i = 0; i < inComputer.length(); i++){
            for(int j = 0; j < inPlayer.length(); j++){
                if(inComputer.charAt(i) == inPlayer.charAt(j)){
                    if(i == j){
                        bulls++;
                        break;
                    }
                    else{
                        cows++;
                        break;
                    }
                }
            }
        }
        if(bulls == 4){
            cows = 0;
        }
        answer = bulls +"Б"+cows+"К";
        bulls = 0;
        cows = 0;
        return answer;
    }
    //проверка на то, чтобы не было одинаковых цифр в числе
    public boolean notDubl(String s){
        boolean isDouble = false;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < s.length(); j++){
                if(i == j){
                    j++;
                    if(j == 4){
                        break;
                    }
                }
                if(s.charAt(i) == s.charAt(j)){
                    isDouble = true;
                }
            }
        }
        return isDouble;
    }
}
