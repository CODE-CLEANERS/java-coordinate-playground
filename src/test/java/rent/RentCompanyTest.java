package rent;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RentCompanyTest {
    private static final String NEWLINE = System.getProperty("line.separator");

    @Test
    @DisplayName("리포트_테스트")
    public void report() {
        RentCompany company = RentCompany.create(); // factory method를 사용해 생성
        company.addCar(new Sonata(150));
        company.addCar(new K5(260));
        company.addCar(new Sonata(120));
        company.addCar(new Avante(300));
        company.addCar(new K5(390));

        String report = company.generateReport();
        assertThat(report).isEqualTo(
                "Sonata : 15리터" + NEWLINE +
                        "K5 : 20리터" + NEWLINE +
                        "Sonata : 12리터" + NEWLINE +
                        "Avante : 20리터" + NEWLINE +
                        "K5 : 30리터" + NEWLINE
        );
    }

    @Test
    @DisplayName("종류별_차량_생성_테스트")
    void createCar() {
        // given
        RentCompany company = RentCompany.create();
        Car sonata_1 = new Sonata(150);
        Car sonata_2 = new Sonata(120);
        Car avante = new Avante(300);
        Car k5_1 = new K5(260);
        Car k5_2 = new K5(390);

        // when
        company.addCar(sonata_1);
        company.addCar(k5_1);
        company.addCar(sonata_2);
        company.addCar(avante);
        company.addCar(k5_2);
        List<Car> cars = company.getCars();

        // then
        assertThat(cars).contains(sonata_1, sonata_2);
        assertThat(cars).contains(avante);
        assertThat(cars).contains(k5_1, k5_2);
    }
}
