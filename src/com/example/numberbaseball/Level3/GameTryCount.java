package com.example.numberbaseball.Level3;

import java.util.ArrayList;

public class GameTryCount {
    // 게임 기록 저장
    private ArrayList<Integer> gameTryCount = new ArrayList<>();

    public void setGameTryCount(int count){
        gameTryCount.add(count);
    }

    public ArrayList<Integer> getGameTryCount(){
        return this.gameTryCount;
    }
}
