package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 자동차는_중복될_수_없다() {
        List<Car> cars = List.of(new Car("gyun"), new Car("gyun"));

        assertThrows(IllegalArgumentException.class, () -> new Cars(cars));
    }

    @Test
    void 위치가_가장_먼_자동차를_찾는다() {
        //given
        Car winner = new Car("gyun");
        List<Car> carList = List.of(winner, new Car("ho"), new Car("kim"));
        Cars cars = new Cars(carList);

        //then
        assertRandomNumberInRangeTest(() -> {
            cars.sprint();
            Set<Car> winners = cars.filterMaxPosition().getCars();
            assertThat(winners).containsExactly(winner);
        }, 4, 3, 3);
    }
}
