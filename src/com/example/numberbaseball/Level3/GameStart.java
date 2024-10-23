package com.example.numberbaseball.Level3;

import java.util.Scanner;

public class GameStart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BaseballGame baseballGame;
        GameTryCount gameTryCount = new GameTryCount();
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
                    // 게임 진행 후 정답 입력 횟수 기록
                    gameTryCount.setGameTryCount(baseballGame.play());
                }
                case "2" -> {
                    System.out.println("<게임 기록 보기>");
                    for(int i=0;i<gameTryCount.getGameTryCount().size();i++){
                        System.out.println(i+1 +"번째 게임 : 시도 횟수 - "+gameTryCount.getGameTryCount().get(i));
                    }
                    System.out.println("------------------------------------------------------");
                }
                case "3", "종료" ->{
                    System.out.println("<숫자 야구 게임을 종료합니다.>");
                    finishFlag = false;
                    gameTryCount.getGameTryCount().clear();
                }
                default -> {
                    System.out.println("원하시는 동작이 존재하지 않습니다. 다시 입력해주세요.");
                    System.out.println("------------------------------------------------------");
                }
            }
        }

    }
}
