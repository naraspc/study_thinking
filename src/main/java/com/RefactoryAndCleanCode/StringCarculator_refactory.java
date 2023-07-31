package com.RefactoryAndCleanCode;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCarculator_refactory {


    int add(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return getSum(extractNumbers(split(text)));
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();


    }

    private String[] split(String text) {
        Matcher CreateSeparator = Pattern.compile("//(.)\n(.*)").matcher(text);
        String[] tokens = text.split(",|:");

        if (CreateSeparator.find()) {
            String customSeparator = CreateSeparator.group(1);
            tokens = CreateSeparator.group(2).split(customSeparator);
        }

        return tokens;

    }


    /*if 문으로 token 수정할곳 split절
    Matcher CreateSeparator = Pattern.compile("//(.)\n(.*)").matcher(text);


    if (CreateSeparator.find()) {
        String customSeparator = CreateSeparator.group(1);
        tokens = CreateSeparator.group(2).split(customSeparator);
    }
    */
    private int[] extractNumbers(String[] tokens) {
        int[] Result = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            Result[i] = Integer.parseInt(tokens[i]);


        }
        return Result;
    }

    //숫자들의 합 리턴
    private int getSum(int[] Result) {
        int sum = 0;
        for (int price : Result) {
            sum += price;
        }
        return sum;
    }


}

