package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StringCalculatorTest {

    private List<String> numbers;

    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>();
        numbers.add("0");
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        numbers.add("4");
        numbers.add("5");
        numbers.add("6");
        numbers.add("7");
        numbers.add("8");
        numbers.add("9");
    }

    @BeforeEach
    void initInput() {
        String input = "2 + 3 * 4 / 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    /**
     * 요구사항
     * - 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
     * - 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
     * - 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
     */
    @Test
    void stringCalculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("문자열을 띄워서 입력하셈: ex> 2 + 3 * 4 / 2");
        String value = scanner.nextLine();
        String[] values = value.split(" ");

        int a = -1;
        int b = -1;
        String operator = "";
        int result = -1;

        for (String v : values) {

            if (!numbers.contains(v)) {
                operator = v;
                continue;
            }

            int i = Integer.parseInt(v);
            if (a == -1) {
                a = i;
                continue;
            }

            b = i;
            reset(calculate(a, operator, b), a, b, operator);
        }
    }

    private int calculate(int a, String operator, int b) {
        switch (operator) {
            case "/":
                return a / b;
            case "*":
                return a * b;
            case "+":
                return a + b;
            case "-":
                return a - b;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void reset(int result, int a, int b, String operator) {
        a = result;
        b = -1;
        operator = "";
        result = -1;
    }
}
