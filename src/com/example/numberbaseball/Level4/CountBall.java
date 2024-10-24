package com.example.numberbaseball.Level4;

import java.util.ArrayList;

public class CountBall extends Count {
    @Override
    public int countAnswer(ArrayList<Integer> answerGame, ArrayList<Integer> inputGame) {
        int count = 0;
        for (int i = 0; i < answerGame.size(); i++) {
            for (int j = 0; j < inputGame.size(); j++) {
                if (answerGame.get(i) == inputGame.get(j)){
                    if(i == j)
                        continue;
                    count++;
                }
            }
        }
        return count;
    }
}
