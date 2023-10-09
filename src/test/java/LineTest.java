import calculator.Dot;
import calculator.Dots;
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

    // getter 매소드를 두는 것이 좋지 않다고 판단됨. lineGetFirstDot() 과 같은 형태는 쓰지 않기로 -

    @Test
    void lineDistance_test() {
        String input = "(1,1)-(5,5)";
        Line line = new Line(new Dots(input));
        assertThat(line.getDotsDistance()).isEqualTo(5.65, offset(0.01));
    }

    @Test
    void is_line_x_parallel() {
        String input = "(1,1)-(5,1)"; // y 값이 같다.
        Line line = new Line(new Dots(input));
        assertThat(line.isXParallel()).isTrue();
    }

    @Test
    void is_line_y_parallel() {
        String input = "(1,1)-(1,5)"; // x 값이 같다.
        Line line = new Line(new Dots(input));
        assertThat(line.isYParallel()).isTrue();
    }
}
