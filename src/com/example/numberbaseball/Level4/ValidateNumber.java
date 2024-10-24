package com.example.numberbaseball.Level4;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.regex.Pattern;

public class ValidateNumber {

    protected boolean validateInput(String input, boolean flag, int digit) {
        ArrayList<Integer> inputList = new ArrayList<>();
        LinkedHashSet<Integer> tmpSet = new LinkedHashSet<Integer>();

        try {
            // 문자열, 0 확인
            parseOperandInteger(input);
        } catch (Exception e) {
            if(flag == false){
                System.out.println("올바르지 않은 숫자입니다");
                System.out.println("------------------------------------------------------");
            }
            return false;
        }

        // 3자리 숫자인지 확인
        if(input.length()!=digit){
            if(flag == false){
                System.out.println(digit+ "자리 숫자로 입력해주세요.");
                System.out.println("------------------------------------------------------");
            }
            return false;
        }

        // 중복 확인
        for (int i = 0; i < input.length(); i++) {
            inputList.add(Character.getNumericValue(input.charAt(i)));
            tmpSet.add(inputList.get(i));
        }
        if (input.length() != tmpSet.size()) {
            if(flag == false){
                System.out.println("올바르지 않은 숫자입니다");
                System.out.println("------------------------------------------------------");
            }
            return false;
        }

        return true;
    }

    public static void parseOperandInteger(String strParse) throws Exception {
        final String NUMBER_REQ = "^[1-9]*$";

        boolean regex = Pattern.matches(NUMBER_REQ, strParse);
        if (!regex) {
            throw new NumberFormatException("정수");
        }
    }
}
