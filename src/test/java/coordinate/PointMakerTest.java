package coordinate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static coordinate.PointConverter.getPoints;
import static org.assertj.core.api.Assertions.assertThat;

public class PointMakerTest {

    @ParameterizedTest
    @ValueSource(strings = {"(25,10)-(10,25)", "(0,13)-(23,0)", "(-1,17)-(8,-1)"})
    void 좌표_입력_테스트_범위_초과(String input) {
        // when
        // then
        IllegalArgumentException result = Assertions.assertThrows(IllegalArgumentException.class, () -> PointMaker.toPoints(input));

        assertThat(result.getMessage()).contains("input is from 1 to 24");
    }

    @ParameterizedTest
    @ValueSource(strings = {"(ㄱ,10)-(10,3)", "(4,A)-(23,5)", "(10,17)-(8,$)"})
    void 좌표_입력_테스트_숫자가_아님(String input) {
        // when
        // then
        ArithmeticException result = Assertions.assertThrows(ArithmeticException.class, () -> PointMaker.toPoints(input));

        assertThat(result.getMessage()).contains("The input is not a number");
    }

    @ParameterizedTest
    @ValueSource(strings = {"(,3)-(5,2)", "(4,1)-(2,)", "(4,1)-( ,5)", "(5, )-(2,3)"})
    void 좌표_입력_테스트_공백_입력됨(String input) {
        // when
        // then
        ArithmeticException result = Assertions.assertThrows(ArithmeticException.class, () -> PointMaker.toPoints(input));

        assertThat(result.getMessage()).contains("The input is not a two dimension point.");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "(10,10)-(14,15):[10,14]:[10,15]",
            "(24,10)-(10,24):[24,10]:[10,24]",
            "(1,5)-(5,1):[1,5]:[5,1]"
    }, delimiter = ':')
    void 좌표_입력_테스트(String input, String xStr, String yStr) {
        // given
        Point[] points = getPoints(xStr, yStr);

        // when
        Point[] result = PointMaker.toPoints(input);

        // then
        assertThat(result).containsExactly(points);
    }
}