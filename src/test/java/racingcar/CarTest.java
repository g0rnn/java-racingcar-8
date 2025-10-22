package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 9, 100})
    void 전진_조건을_만족하면_움직인다(int condition) {
        //given
        Car car = new Car("gyun");

        //when
        car.move(condition);

        //then
        assertEquals(1, car.getPosition());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"abcdef", "", "toooooo long name"})
    void 유효하지_않은_이름이_전달되면_예외를_던진다(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }
}