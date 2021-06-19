package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    /**
     * 요구사항 1
     * - "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
     * - "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     */
    @Test
    void seperate() {
        String given = "1,2";
        String[] actual = given.split(",");
        String[] expected = {"1", "2"};

        // 배열로 반환하는 값의 경우 테스트
        assertThat(actual).contains(expected).containsExactly(expected);
    }

    /**
     * 요구사항 2
     * - "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
     */
    @Test
    void substring() {
        String given = "(1,2)";
        String actual = given.substring(1, given.length() - 1);
        String expected = "1,2";

        assertEquals(expected, actual);
    }

    /**
     * 요구사항 3
     * - "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
     * - String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
     * - JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     */
    @Test
    @DisplayName("요구사항3 테스트하기 위한 메소드")
    void charAt() {
        String given = "abc";

        assertThatThrownBy(() -> given.charAt(4))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("range: 4");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> given.charAt(4))
                .withMessageMatching("String index out of range: 4");
        /**
         * 자주 발생하는 Exception의 경우 Exception별 메서드 제공하고 있음
         * - assertThatIllegalArgumentException()
         * - assertThatIllegalStateException()
         * - assertThatIOException()
         * - assertThatNullPointerException()
         */
    }


}
