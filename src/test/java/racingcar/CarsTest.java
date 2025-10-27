package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 자동차는_중복될_수_없다() {
        List<Car> cars = List.of(new Car("gyun"), new Car("gyun"));

        assertThrows(IllegalArgumentException.class, () -> new Cars(cars));
    }
}
