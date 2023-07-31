package com.RefactoryAndCleanCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCarculator {


    int add(String text) {
        if (text == null || text.isEmpty()) { //null 컨트롤
            return 0;

        }
        int numberOne = 1; //변수는 가장 위에 선언
        String[] tokens = text.split(",|:");
        Matcher CreateSeparator = Pattern.compile("//(.)\n(.*)").matcher(text);

        //if 문으로 token 수정할곳
        if (CreateSeparator.find()) {
            String customSeparator = CreateSeparator.group(1);
            tokens = CreateSeparator.group(2).split(customSeparator);
        }

        //숫자들의 합 리턴
        String[] separatedNumbers = tokens;
        int sum = 0;
        for (int i = 0; i < separatedNumbers.length; i++) {
            sum += Integer.parseInt(separatedNumbers[i]);
        }

      /* 이부분에서 tokens 값이 text 에 들어가면서 NumberFormatException을 뿜는다
      이 부분을 살리려면 text 에 ',' 나 ':' 같은 구분자를 넣으면 안된다. 즉 더하기가 불가능. 논리적으로 불가능한 코딩이었음 수정필요
      클린코드 & 리팩토링 구조의 특징상 구분자가 들어가기 전 숫자1만 들어왔을때 1을 리턴하는 이 로직에서, 리팩토링 이후 추가기능을 추가했어야 한다.

      즉 해당 로직을 리팩토링하기전에 새로운 기능인 숫자들의 합을 구하는 로직을 작성하면 안됐다.
      이부분을 놓쳐서 두가지 기능이 계속 충돌났다.

      코딩을 할땐 항상 조그마한 기능을 만들고, 리팩토링 하여 최적화 한뒤 새로운 기능을 추가하자.

        try {
            if (numberOne == Integer.parseInt(text)) {
                return numberOne;
            }
        }catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        */


        return sum;

    }
}
