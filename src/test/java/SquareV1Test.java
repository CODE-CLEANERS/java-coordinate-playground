import calculator.Dots;
import calculator.SquareV1;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SquareV1Test {
    //- 좌표값을 두 개 입력한 경우, 두 점을 있는 직선으로 가정한다. 좌표값과 좌표값 사이는 '-' 문자로 구분한다.
    //- 좌표값을 네 개 입력한 경우, 네 점을 연결하는 사각형으로 가정한다.
    //    - 네 점이 뒤틀어진 사다리꼴이나 마름모는 제외하고 직사각형만 허용하도록 검사한다.
    //    - 사각형인 경우 사각형의 넓이를 계산해서 출력한다
    @Test
    void square_area_test() {
        String input = "(10,10)-(22,10)-(22,18)-(10,18)";
        Dots dots = new Dots(input);
        SquareV1 squareV1 = new SquareV1(dots);
        assertThat(squareV1.getArea()).isEqualTo(12 * 8);
    }
}
