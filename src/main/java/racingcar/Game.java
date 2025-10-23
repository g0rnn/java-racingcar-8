package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {

    private static final int MAX_LABS = 100_000;
    private static final int MAX_CARS_SIZE = 100_000;

    private final List<Car> cars;
    private int labs;

    public Game(int labs, List<Car> cars) {
        validateLabs(labs);
        validateCars(cars);
        this.labs = labs;
        this.cars = cars;
    }

    public boolean canStart() {
        return labs != 0;
    }

    public void nextLab() {
        for (Car car : cars) {
            int condition = Randoms.pickNumberInRange(0, 9);
            car.move(condition);
        }
        this.labs -= 1;
    }

    public int getRemainingLaps() {
        return this.labs;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public String currentLabResult() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getCurrentPosition());
            sb.append("\n");
        }
        return sb.toString();
    }

    private void validateLabs(int labs) {
        if (labs > MAX_LABS) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCars(List<Car> cars) {
        if (cars == null) {
            throw new IllegalArgumentException();
        }

        if (cars.isEmpty() || cars.size() > MAX_CARS_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
