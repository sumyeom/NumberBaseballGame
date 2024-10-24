package com.example.numberbaseball.Level4;

import java.util.ArrayList;
import java.util.Random;

public class GenerationAnswer {
    private ArrayList<Integer> answerGame = new ArrayList<Integer>();

    public int generateRandom(int digit){
        Random random = new Random();
        int randomNumber = 0;
        if(digit == 3){
            randomNumber = random.nextInt(888)+111;
        } else if (digit == 4){
            randomNumber = random.nextInt(8888)+1111;
        } else if( digit == 5){
            randomNumber = random.nextInt(88888)+11111;
        }
        return randomNumber;
    }
    public void generateAnswer(int digit) {
        ValidateNumber validateNumber = new ValidateNumber();
        int answerNumber = generateRandom(digit);
        String answerString = String.valueOf(answerNumber);
        while(true){
            if(validateNumber.validateInput(answerString, true, digit)) {
                for(char str : answerString.toCharArray()){
                    this.answerGame.add(Character.getNumericValue(str));
                }
                break;
            }else {
                answerNumber = generateRandom(digit);
                answerString = String.valueOf(answerNumber);
            }
        }
    }

    public ArrayList<Integer> getAnswerGame(){
        return this.answerGame;
    }
}
