package racingcar;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final Set<Car> cars;

    public Cars(Collection<Car> cars) {
        validateCars(cars);
        this.cars = Set.copyOf(cars);
    }

    public static Cars of(String[] carNames) {
        Set<Car> distinctCars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toUnmodifiableSet());

        return new Cars(distinctCars);
    }

    private void validateCars(Collection<Car> cars) {
        Set<Car> distinctCars = new HashSet<>(cars);
        if (distinctCars.size() != cars.size()) {
            throw new IllegalArgumentException();
        }
    }
}
