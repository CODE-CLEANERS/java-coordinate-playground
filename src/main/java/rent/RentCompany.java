package rent;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    List<Car> cars = new ArrayList<>();

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        String newLine = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName());
            sb.append(" : ");
            sb.append(Math.round(car.getChargeQuantity()));
            sb.append("리터");
            sb.append(newLine);
        }

        return sb.toString();
    }

    protected List<Car> getCars() {
        return this.cars;
    }
}
