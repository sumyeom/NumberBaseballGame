package com.example.numberbaseball.Level4;

import java.util.Scanner;

public class GameStart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BaseballGame baseballGame;
        GameTryCount gameTryCount = new GameTryCount();
        ValidateNumber validateNumber = new ValidateNumber();
		boolean finishFlag = true;
        System.out.print("환영합니다! ");
        while (true) {
            if (finishFlag == false) {
                break;
            }
            System.out.println("원하시는 번호를 입력해주세요.");
            System.out.println("0. 자리수 설정 | 1. 게임 시작하기 | 2. 게임 기록 보기 | 3. 종료");
            String command = scanner.nextLine();
            int digit = 3;
            switch(command){
                case "0" :
                    System.out.println("설정하고자 하는 자리수를 입력하세요.");
                    String digitStr = scanner.nextLine();
                    try{
                        validateNumber.parseOperandInteger(digitStr);
                    }catch (Exception e){
                        if(digitStr.equals("0")){
                            System.out.println("설정할 수 없는 자리수입니다.");
                        } else{
                            System.out.println(e.getMessage()+"로 입력하세요");
                        }
                        break;
                    }
                    digit = Integer.parseInt(digitStr);
                    if(3 > digit || digit > 5){
                        System.out.println("설정할 수 없는 자리수입니다");
                        break;
                    }
                    System.out.println(digitStr +"자리수 난이도로 설정되었습니다.");
                    System.out.println();
                case "1" :
                    baseballGame = new BaseballGame(digit);
                    // 게임 진행 후 정답 입력 횟수 기록
                    gameTryCount.setGameTryCount(baseballGame.play());
                    break;
                case "2" :
                    System.out.println("<게임 기록 보기>");
                    for(int i=0;i<gameTryCount.getGameTryCount().size();i++){
                        System.out.println(i+1 +"번째 게임 : 시도 횟수 - "+gameTryCount.getGameTryCount().get(i));
                    }
                    System.out.println("------------------------------------------------------");
                    break;
                case "3", "종료" :
                    System.out.println("<숫자 야구 게임을 종료합니다.>");
                    finishFlag = false;
                    gameTryCount.getGameTryCount().clear();
                    break;
                default :
                    System.out.println("원하시는 동작이 존재하지 않습니다. 다시 입력해주세요.");
                    System.out.println("------------------------------------------------------");
                    break;
            }
        }

    }
}
