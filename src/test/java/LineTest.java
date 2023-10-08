import calculator.Dot;
import calculator.Line;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LineTest {
    //- 사용자가 점에 대한 좌표 정보를 입력하는 메뉴를 구성한다.
    //- 좌표 정보는 괄호"(", ")"로 둘러쌓여 있으며 쉼표(,)로 x값과 y값을 구분한다.
    //- X, Y좌표 모두 최대 24까지만 입력할 수 있다.

    //- 정상적인 좌표값을 입력한 경우, 해당 좌표에 특수문자를 표시한다.
    //- 좌표값을 두 개 입력한 경우, 두 점을 있는 직선으로 가정한다. 좌표값과 좌표값 사이는 '-' 문자로 구분한다.
    //- 직선인 경우는 두 점 사이 거리를 계산해서 출력한다.
    @Test
    void lineInput_test() {
        String input = "(1,1)-(5,5)";
        Line line = new Line(input);

        assertThat(line.getFirstDot()).isEqualTo(new Dot(1, 1));
        assertThat(line.getSecondDot()).isEqualTo(new Dot(5, 5));
    }

    @Test
    void invalid_lineInput_test() {
        String input = "(1,1)1(5,5)";
        String input2 = "(1,1)";
        String input3 = "(25,25)-(25,25)";
        assertThatThrownBy(() -> new Line(input)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Line(input2)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Line(input3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lineDistance_test() {
        String input = "(1,1)-(5,5)";
        Line line = new Line(input);
        assertThat(line.getDotsDistance()).isEqualTo(5.65, offset(0.01));
    }
}
