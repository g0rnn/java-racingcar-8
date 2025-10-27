package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private static final int MAX_CARS_SIZE = 100_000;

    private final Set<Car> cars;

    public Cars(Collection<Car> cars) {
        validateCars(cars);
        this.cars = Collections.unmodifiableSet(new LinkedHashSet<>(cars));
    }

    public static Cars of(String[] carNames) {
        Set<Car> distinctCars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        return new Cars(distinctCars);
    }

    public void sprint() {
        for (Car car : cars) {
            int condition = Randoms.pickNumberInRange(0, 9);
            car.move(condition);
        }
    }

    public Cars filterMaxPosition() {
        List<Car> winners = new ArrayList<>();
        int max = -1;

        for (Car car : cars) {
            int p = car.getPosition();
            if (max < p) {
                max = p;
                winners.clear();
                winners.add(car);
            } else if (max == p) {
                winners.add(car);
            }
        }

        return new Cars(winners);
    }

    public String getNames() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    public String getCurrentStatus() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getCurrentPosition());
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean isAvailableSize() {
        if (cars.isEmpty() || cars.size() > MAX_CARS_SIZE) {
            return false;
        }
        return true;
    }

    public Set<Car> getCars() {
        return this.cars;
    }

    private void validateCars(Collection<Car> cars) {
        if (cars == null) {
            throw new IllegalArgumentException();
        }

        Set<Car> distinctCars = new HashSet<>(cars);
        if (distinctCars.size() != cars.size()) {
            throw new IllegalArgumentException();
        }
    }
}
