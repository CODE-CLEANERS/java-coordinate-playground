package rent;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    public static class TestCar extends Car {

        public TestCar(int tripDistance, int distancePerLiter) {
            super(tripDistance, distancePerLiter);
        }
    }

    @Test
    @DisplayName("연비_구하기_테스트")
    void getDistancePerLiterTest() {
        // given
        int distancePerLiter = 100;
        Car testCar = new TestCar(10, distancePerLiter);

        // when
        double result = testCar.getDistancePerLiter();

        // then
        assertThat(result).isEqualTo(distancePerLiter);
    }

    @Test
    @DisplayName("여행거리_구하기_테스트")
    void getTripDistanceTest() {
        // given
        int tripDistance = 100;
        Car testCar = new TestCar(tripDistance, 10);

        // when
        double result = testCar.getTripDistance();

        // then
        assertThat(result).isEqualTo(tripDistance);
    }

    @Test
    @DisplayName("차이름_구하기_테스트")
    void getNameTest() {
        // given
        Car testCar = new TestCar(100, 10);

        // when
        String result = testCar.getName();

        // then
        assertThat(result).isEqualTo(testCar.getClass().getSimpleName());
    }

    @Test
    @DisplayName("충전해야할_연료량_구하기")
    void getChargeQuantity() {
        // given
        int tripDistance = 100;
        int distancePerLiter = 10;
        Car testCar = new TestCar(100, 10);
        double chargeQuantity = tripDistance / (double) distancePerLiter;

        // when
        double result = testCar.getChargeQuantity();

        // then
        assertThat(result).isEqualTo(chargeQuantity);
    }
}
