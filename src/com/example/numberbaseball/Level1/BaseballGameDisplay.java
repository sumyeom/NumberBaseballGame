package com.example.numberbaseball.Level1;

public class BaseballGameDisplay {
    public void displayHint(int Strike, int ball){
        if(Strike == 0 && ball == 0){
            System.out.println("아웃입니다");
        }else{
            System.out.println(Strike + "스트라이크 " + ball + "볼");
        }
    }
}
