package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @DisplayName("Coordinate가 잘 생성되는지 테스트")
    @Test
    void createCoordinate() throws IOException {
    //given
    //when
    Coordinate coordinate = new Coordinate("(14,24)");
    //then
        Assertions.assertThat(coordinate.x).isEqualTo(14);
        Assertions.assertThat(coordinate.y).isEqualTo(24);
    }

    @DisplayName("좌표값은 최대 24까지만 입력해야 한다.")
    @Test
    void validateCoordinateSize() throws IOException {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(()-> new Coordinate("(50,24)")).hasMessage("좌표값은 0부터 24까지만 입력해야합니다.");
    }

}