package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private static final int MIN_LABS = 1;
    private static final int MAX_LABS = 100_000;

    private final Cars cars;
    private final List<String> labResults = new ArrayList<>();
    private int labs;

    public Race(int labs, Cars cars) {
        validateLabs(labs);
        validateCars(cars);
        this.labs = labs;
        this.cars = cars;
    }

    public boolean canStart() {
        return labs != 0;
    }

    public void nextLab() {
        this.cars.sprint();
        this.labs -= 1;
        labResults.add(cars.getCurrentStatus());
    }

    public int getRemainingLaps() {
        return this.labs;
    }

    public Cars getCars() {
        return this.cars;
    }

    public List<String> getLabResults() {
        return this.labResults;
    }

    private void validateLabs(int labs) {
        if (labs < MIN_LABS || labs > MAX_LABS) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCars(Cars cars) {
        if (cars == null) {
            throw new IllegalArgumentException();
        }
        if (!cars.isAvailableSize()) {
            throw new IllegalArgumentException();
        }
    }
}
