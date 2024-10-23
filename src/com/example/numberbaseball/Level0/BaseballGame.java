package com.example.numberbaseball.Level0;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BaseballGame {
    // 정답
    private ArrayList<Integer> answerGame = new ArrayList<Integer>();
    private ArrayList<Integer> inputGame = new ArrayList<Integer>();

    public BaseballGame() {

    }

    public int play() {
        int countPlay = 0;
        int countStrike = 0;
        int countBall = 0;
        BaseballGameDisplay baseballGameDisplay = new BaseballGameDisplay();
        // 정답 생성
        generateAnswer();
        System.out.println(answerGame.toString());
        Scanner scanner = new Scanner(System.in);
        System.out.println("<게임을 시작합니다>");
        while (true) {
            // 1. 유저에게 입력을 받음
            System.out.println("숫자를 입력하세요");
            String inputUser = scanner.nextLine();
            // 2. 올바른 입력값을 받았는지 검증
            if (validateInput(inputUser) == false) {
                continue;
            }
            // 3. 게임 진행 횟수 증가
            countPlay++;
            // 4. 스트라이크 개수 계산
            countStrike = countStrike(inputUser);
            // 5. 정답 여부 확인, 만약 정답이면 break를 이용해 반복문 탈출
            if (countStrike == 3) {
                System.out.println("정답입니다!");
                break;
            }
            // 6. 볼 개수 계산
            countBall = countBall(inputUser);
            // 7. 힌트 출력
            baseballGameDisplay.displayHint(countStrike, countBall);

            // 초기화
            countStrike = 0;
            countBall = 0;
            inputGame.clear();
        }
        // 게임 진행 횟수 반환
        return countPlay;
    }

    private void generateAnswer() {
        Random random = new Random();
        int firstNumber = random.nextInt(1, 999);
        int secondNumber;
        int thirdNumber;

        this.answerGame.add(firstNumber);

        while (true) {
            secondNumber = random.nextInt(1, 9);
            if (firstNumber != secondNumber) {
                this.answerGame.add(secondNumber);
                break;
            }
        }

        while (true) {
            thirdNumber = random.nextInt(1, 9);
            if (firstNumber != secondNumber && firstNumber != thirdNumber && secondNumber != thirdNumber) {
                this.answerGame.add(thirdNumber);
                break;
            }
        }

    }

    protected boolean validateInput(String input) {
        LinkedHashSet<Integer> tmpSet = new LinkedHashSet<Integer>();
        try {
            // 문자열, 0 확인
            parseOperandInteger(input);
        } catch (Exception e) {
            System.out.println("올바르지 않은 숫자입니다");
            return false;
        }
        if(input.length()<3){
            System.out.println("올바르지 않은 숫자입니다");
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            this.inputGame.add(Character.getNumericValue(input.charAt(i)));
            tmpSet.add(this.inputGame.get(i));
        }

        // 중복 확인
        if (input.length() != tmpSet.size()) {
            System.out.println("올바르지 않은 숫자입니다");
            inputGame.clear();
            return false;
        }

        return true;
    }

    private int countStrike(String input) {
        int count = 0;
        for (int i = 0; i < answerGame.size(); i++) {
            if (answerGame.get(i) == inputGame.get(i)) {
                count++;
            }
        }
        return count;
    }

    private int countBall(String input) {
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

    public static void parseOperandInteger(String strParse) throws Exception {
        final String NUMBER_REQ = "^[1-9]*$";

        boolean regex = Pattern.matches(NUMBER_REQ, strParse);
        if (!regex) {
            throw new NumberFormatException("정수");
        }
    }
}
