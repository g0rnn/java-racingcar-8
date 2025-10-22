package racingcar;

import java.util.List;

public class Game {

    private static final int MAX_LABS = 100_000;
    private static final int MAX_CARS_SIZE = 100_000;

    private final int labs;
    private final List<Car> cars;

    Game(int labs, List<Car> cars) {
        validateLabs(labs);
        validateCars(cars);
        this.labs = labs;
        this.cars = cars;
    }

    private void validateLabs(int labs) {
        if (labs > MAX_LABS) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCars(List<Car> cars) {
        if (cars.isEmpty() || cars.size() > MAX_CARS_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
