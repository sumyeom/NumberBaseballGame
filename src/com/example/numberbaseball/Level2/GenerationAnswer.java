package com.example.numberbaseball.Level2;

import java.util.ArrayList;
import java.util.Random;

public class GenerationAnswer {
    private ArrayList<Integer> answerGame = new ArrayList<Integer>();

    public int generateRandom(){
        Random random = new Random();
        int randomNumber = random.nextInt(888)+111;
        return randomNumber;
    }
    public void generateAnswer() {
        ValidateNumber validateNumber = new ValidateNumber();
        int answerNumber = generateRandom();
        String answerString = String.valueOf(answerNumber);
        while(true){
            if(validateNumber.validateInput(answerString, true)) {
                for(char str : answerString.toCharArray()){
                    this.answerGame.add(Character.getNumericValue(str));
                }
                break;
            }else {
                answerNumber = generateRandom();
                answerString = String.valueOf(answerNumber);
            }
        }
    }

    public ArrayList<Integer> getAnswerGame(){
        return this.answerGame;
    }
}
