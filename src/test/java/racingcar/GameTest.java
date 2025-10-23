package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameTest {

    @ParameterizedTest
    @ValueSource(ints = {100_001, Integer.MAX_VALUE})
    void 최대_랩_수를_넘으면_예외를_던진다(int labs) {
        List<Car> cars = List.of(new Car("gyun"));
        assertThrows(IllegalArgumentException.class, () -> new Game(labs, cars));
    }

    @Test
    void 게임에_참여하는_자동차는_1대보다_작으면_예외를_던진다() {
        List<Car> cars = Collections.emptyList();
        assertThrows(IllegalArgumentException.class, () -> new Game(1, cars));
    }

    @Test
    void 게임에_참여하는_자동차는_1대_이상이다() {
        List<Car> cars = List.of(new Car("gyun"));
        assertDoesNotThrow(() -> new Game(1, cars));
    }

    @Test
    void 랩이_끝나면_랩_수가_갱신된다() {
        int labs = 1;
        Game game = new Game(labs, List.of(new Car("gyun")));
        game.nextLab();

        assertEquals(labs - 1, game.getRemainingLaps());
    }

    @Test
    void 전진하는_조건은_값이_4_이상일_경우이다() {
        int labs = 10;
        Car car1 = new Car("gyun");
        Car car2 = new Car("ho");
        List<Car> cars = List.of(car1, car2);
        Game game = new Game(labs, cars);

        assertRandomNumberInRangeTest(() -> {
            game.nextLab();
            assertEquals(1, car1.getPosition());
            assertEquals(1, car2.getPosition());
        }, 4);
    }
}