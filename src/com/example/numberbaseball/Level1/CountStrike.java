package com.example.numberbaseball.Level1;

import java.util.ArrayList;

public class CountStrike extends Count{
    @Override
    public int countAnswer(ArrayList<Integer> answerGame, ArrayList<Integer> inputGame) {
        int count = 0;
        for (int i = 0; i < answerGame.size(); i++) {
            if (answerGame.get(i) == inputGame.get(i)) {
                count++;
            }
        }
        return count;
    }
}
