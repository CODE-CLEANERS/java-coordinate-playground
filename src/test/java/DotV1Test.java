import calculator.DotV1;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DotV1Test {
    //- 사용자가 점에 대한 좌표 정보를 입력하는 메뉴를 구성한다.
    //- 좌표 정보는 괄호"(", ")"로 둘러쌓여 있으며 쉼표(,)로 x값과 y값을 구분한다.
    //- X, Y좌표 모두 최대 24까지만 입력할 수 있다.

    //- 정상적인 좌표값을 입력한 경우, 해당 좌표에 특수문자를 표시한다.
    //- 좌표값을 두 개 입력한 경우, 두 점을 있는 직선으로 가정한다. 좌표값과 좌표값 사이는 '-' 문자로 구분한다.
    //- 직선인 경우는 두 점 사이 거리를 계산해서 출력한다.

    @Test
    void dotInit_test() {
        DotV1 dotV1 = new DotV1(1, 1);
        assertThat(dotV1).isEqualTo(new DotV1(1, 1));
    }

    @Test
    void dot_validation_test() { //- 입력 범위를 초과할 경우 에러 문구를 출력하고 다시 입력을 받는다. 중요!
        assertThatThrownBy(() -> new DotV1(25, 25)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void string_input_test() {
        String input = "(1,1)";
        DotV1 dotV1 = new DotV1(input);
        assertThat(dotV1).isEqualTo(new DotV1(1,1));
    }

    @Test
    void validate_input_test() {
        String input = "(25,25)";
        assertThatThrownBy(() -> new DotV1(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void get_dot_distance() {
        DotV1 dotV1 = new DotV1(10,10);
        DotV1 secondDotV1 = new DotV1(14,15);
        assertThat(dotV1.getDistanceBetween(secondDotV1)).isEqualTo(6.4, offset(0.1));
    }

    @Test
    void is_x_parallel() {
        DotV1 dotV1 = new DotV1(10, 10);
        DotV1 dotV12 = new DotV1(15, 10);
        assertThat(dotV1.isXParallel(dotV12)).isTrue();
    }

    @Test
    void is_y_parallel() {
        DotV1 dotV1 = new DotV1(10, 10);
        DotV1 dotV12 = new DotV1(10, 15);
        assertThat(dotV1.isYParallel(dotV12)).isTrue();
    }
}
