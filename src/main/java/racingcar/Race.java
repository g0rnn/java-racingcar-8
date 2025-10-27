package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Set;

public class Race {

    private static final int MIN_LABS = 1;
    private static final int MAX_LABS = 100_000;
    private static final int MAX_CARS_SIZE = 100_000;

    private final Set<Car> cars;
    private int labs;

    public Race(int labs, Set<Car> cars) {
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

    public Set<Car> getCars() {
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
        if (labs < MIN_LABS || labs > MAX_LABS) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCars(Set<Car> cars) {
        if (cars == null) {
            throw new IllegalArgumentException();
        }

        if (cars.isEmpty() || cars.size() > MAX_CARS_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
