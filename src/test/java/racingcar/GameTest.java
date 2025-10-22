package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameTest {

    @ParameterizedTest
    @ValueSource(ints = {100_001, 1_000_001, Integer.MAX_VALUE})
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
}