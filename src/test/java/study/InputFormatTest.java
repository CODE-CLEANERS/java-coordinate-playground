package study;

import domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Constants;
import view.InputView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputFormatTest {

    // 좌표 정보는 괄호"(", ")"로 둘러쌓여 있으며 쉼표(,)로 x값과 y값을 구분
    @Test
    @DisplayName("입력 좌표 포맷 정상 확인")
    void 입력_좌표_포맷_정상_Test() {

        InputView.validInputFormat("(3,4)-(3,5)");

    }

    @Test
    @DisplayName("하나의 입력 좌표 포맷을 확인")
    void 하나의_입력_좌표_포맷_Test() {

        Throwable exception1 = assertThrows(RuntimeException.class, () -> {
            InputView.validInputFormat("(3,4)");
        });

        assertEquals(Constants.INPUT_FORMAT_CHECK, exception1.getMessage());

    }

    @Test
    @DisplayName("여러개의 입력 좌표 포맷을 확인")
    void 여러개_입력_좌표_포맷_Test() {

        Throwable exception3 = assertThrows(RuntimeException.class, () -> {
            InputView.validInputFormat("(3,4)-(3,5)-(3,6)-(3,7)");
        });
        assertEquals(Constants.INPUT_FORMAT_CHECK, exception3.getMessage());

    }

    @Test
    @DisplayName("입력 좌표(x,y) 포맷을 확인")
    void 입력_좌표_두자리_포맷_Test() {

        Throwable exception4 = assertThrows(RuntimeException.class, () -> {
            InputView.validInputFormat("(3,4)-(3,5,8)");
        });
        assertEquals(Constants.INPUT_FORMAT_CHECK, exception4.getMessage());

    }

    @Test
    @DisplayName("입력 좌표 숫자 포맷을 확인")
    void 입력_좌표_숫자_포맷_Test() {

        Throwable exception5 = assertThrows(RuntimeException.class, () -> {
            InputView.validInputFormat("(3,4)-(3,g)");
        });
        assertEquals(Constants.INPUT_FORMAT_CHECK, exception5.getMessage());

    }

    @Test
    @DisplayName("입력_좌표_범위_정상_확인")
    void 입력_좌표_정상_범위_Test() {

        Point.newInstance(0, 24);

    }

    @Test
    @DisplayName("입력_좌표X_0_24범위_확인")
    void 입력_좌표X_0_24범위_Test() {

        Throwable exception = assertThrows(RuntimeException.class, () -> {
            Point.newInstance(-1, 24);
        });
        assertEquals(Constants.INPUT_RANGE_CHECK, exception.getMessage());

    }

    @Test
    @DisplayName("입력_좌표Y_0_24범위_확인")
    void 입력_좌표Y_범위_Test() {

        Throwable exception2 = assertThrows(RuntimeException.class, () -> {
            Point.newInstance(0, 25);
        });
        assertEquals(Constants.INPUT_RANGE_CHECK, exception2.getMessage());

    }


}
