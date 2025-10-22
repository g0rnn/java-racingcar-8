package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"abcdef", "", "toooooo long name"})
    void 유효하지_않은_이름이_전달되면_예외를_던진다(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }
}