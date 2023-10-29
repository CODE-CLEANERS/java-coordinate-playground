package rent;

public class Avante extends Car {
    private static final int DISTANCE_PER_LITER = 15;

    public Avante(int tripDistance) {
        super(tripDistance, DISTANCE_PER_LITER);
    }
}
