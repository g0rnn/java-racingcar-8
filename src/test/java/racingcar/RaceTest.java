package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RaceTest {

    @ParameterizedTest
    @ValueSource(ints = {100_001, Integer.MAX_VALUE})
    void 최대_랩_수를_넘으면_예외를_던진다(int labs) {
        Set<Car> cars = Set.of(new Car("gyun"));
        assertThrows(IllegalArgumentException.class, () -> new Race(labs, cars));
    }

    @Test
    void 게임에_참여하는_자동차는_1대보다_작으면_예외를_던진다() {
        Set<Car> cars = Collections.emptySet();
        assertThrows(IllegalArgumentException.class, () -> new Race(1, cars));
    }

    @Test
    void 게임에_참여하는_자동차는_1대_이상이다() {
        Set<Car> cars = Set.of(new Car("gyun"));
        assertDoesNotThrow(() -> new Race(1, cars));
    }

    @Test
    void 랩이_끝나면_랩_수가_갱신된다() {
        int labs = 1;
        Race race = new Race(labs, Set.of(new Car("gyun")));
        race.nextLab();

        assertEquals(labs - 1, race.getRemainingLaps());
    }

    @Test
    void 전진하는_조건은_값이_4_이상일_경우이다() {
        int labs = 10;
        Car car1 = new Car("gyun");
        Car car2 = new Car("ho");
        Set<Car> cars = Set.of(car1, car2);
        Race race = new Race(labs, cars);

        assertRandomNumberInRangeTest(() -> {
            race.nextLab();
            assertEquals(1, car1.getPosition());
            assertEquals(1, car2.getPosition());
        }, 4);
    }
}
