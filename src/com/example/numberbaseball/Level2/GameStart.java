package com.example.numberbaseball.Level2;

import java.util.Scanner;

public class GameStart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BaseballGame baseballGame;
        boolean finishFlag = true;
        System.out.print("환영합니다! ");
        while (true) {
            if (finishFlag == false) {
                break;
            }
            System.out.println("원하시는 번호를 입력해주세요.");
            System.out.println("1. 게임 시작하기 | 2. 게임 기록 보기 | 3. 종료");
            String command = scanner.nextLine();
            switch(command){
                case "1" -> {
                    baseballGame = new BaseballGame();
                    baseballGame.play();
                }
                case "2" -> {
                    System.out.println("게임 기록 보기");
                }
                case "3", "종료" ->{
                    finishFlag = false;
                }
            }
        }

    }
}
