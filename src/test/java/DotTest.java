import calculator.Dot;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DotTest {
    //- 사용자가 점에 대한 좌표 정보를 입력하는 메뉴를 구성한다.
    //- 좌표 정보는 괄호"(", ")"로 둘러쌓여 있으며 쉼표(,)로 x값과 y값을 구분한다.
    //- X, Y좌표 모두 최대 24까지만 입력할 수 있다.

    //- 정상적인 좌표값을 입력한 경우, 해당 좌표에 특수문자를 표시한다.
    //- 좌표값을 두 개 입력한 경우, 두 점을 있는 직선으로 가정한다. 좌표값과 좌표값 사이는 '-' 문자로 구분한다.
    //- 직선인 경우는 두 점 사이 거리를 계산해서 출력한다.

    @Test
    void dotInit_test() {
        Dot dot = new Dot(1, 1);
        assertThat(dot).isEqualTo(new Dot(1, 1));
    }

    @Test
    void dot_validation_test() { //- 입력 범위를 초과할 경우 에러 문구를 출력하고 다시 입력을 받는다. 중요!
        assertThatThrownBy(() -> new Dot(25, 25)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void string_input_test() {
        String input = "(1,1)";
        Dot dot = new Dot(input);
        assertThat(dot).isEqualTo(new Dot(1,1));
    }

    @Test
    void validate_input_test() {
        String input = "(25,25)";
        assertThatThrownBy(() -> new Dot(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void get_dot_distance() {
        Dot dot = new Dot(10,10);
        Dot secondDot = new Dot(14,15);
        assertThat(dot.getDistanceBetween(secondDot)).isEqualTo(6.4, offset(0.1));
    }

    @Test
    void is_x_parallel() {
        Dot dot = new Dot(10, 10);
        Dot dot2 = new Dot(15, 10);
        assertThat(dot.isXParallel(dot2)).isTrue();
    }

    @Test
    void is_y_parallel() {
        Dot dot = new Dot(10, 10);
        Dot dot2 = new Dot(10, 15);
        assertThat(dot.isYParallel(dot2)).isTrue();
    }
}
