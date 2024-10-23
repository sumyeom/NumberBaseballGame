package com.example.numberbaseball.Level2;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseballGame {
    // 필드 선언
    private ArrayList<Integer> answerGame = new ArrayList<Integer>();
    private ArrayList<Integer> inputGame = new ArrayList<Integer>();
    // 정답 숫자 생성 객체
    GenerationAnswer generationAnswer = new GenerationAnswer();

    public BaseballGame() {
        generationAnswer.generateAnswer();
        this.answerGame = generationAnswer.getAnswerGame();
    }

    public int play() {
        Scanner scanner = new Scanner(System.in);
        BaseballGameDisplay baseballGameDisplay = new BaseballGameDisplay();
        ValidateNumber validateNumber = new ValidateNumber();
        Count countStrike = new CountStrike();
        Count countBall = new CountBall();
        int strike = 0;
        int ball = 0;
        int countPlay = 0;

        System.out.println(answerGame.toString());
        System.out.println("<게임을 시작합니다>");
        while (true) {
            // 1. 유저에게 입력을 받음
            System.out.println("숫자를 입력하세요");
            String inputUser = scanner.nextLine();
            // 2. 올바른 입력값을 받았는지 검증
            if (validateNumber.validateInput(inputUser, false) == false) {
                continue;
            } else {
                for (char ch : inputUser.toCharArray()) {
                    this.inputGame.add(Character.getNumericValue(ch));
                }
            }
            // 3. 게임 진행 횟수 증가
            countPlay++;
            // 4. 스트라이크 개수 계산
            strike = countStrike.countAnswer(answerGame, inputGame);
            // 5. 정답 여부 확인, 만약 정답이면 break를 이용해 반복문 탈출
            if (strike == 3) {
                System.out.println("정답입니다!");
                System.out.println("------------------------------------------------------");
                break;
            }
            // 6. 볼 개수 계산
            ball = countBall.countAnswer(answerGame, inputGame);
            // 7. 힌트 출력
            baseballGameDisplay.displayHint(strike, ball);

            // 초기화
            strike = 0;
            ball = 0;
            inputGame.clear();
        }
        // 게임 진행 횟수 반환
        return countPlay;
    }
}
