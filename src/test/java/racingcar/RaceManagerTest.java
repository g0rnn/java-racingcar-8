package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class RaceManagerTest {

    @Test
    void 경기_우승자를_결정한다() {
        // given
        Car car = new Car("gyun");
        Race race = new Race(1, Set.of(car));
        RaceManager raceManager = new RaceManager(race);

        // when
        raceManager.start();
        List<Car> winners = raceManager.judgeWinners();

        // then
        assertThat(winners).containsExactly(car);
    }

    @Test
    void 게임이_진행가능할_때_우승자를_결정하려고_하면_예외를_던진다() {
        // given
        Car car = new Car("gyun");
        Race race = new Race(1, Set.of(car));
        RaceManager raceManager = new RaceManager(race);

        // when

        // DO NOT start race
        // raceManager.start();
        assertThrows(IllegalArgumentException.class, raceManager::judgeWinners);
    }
}
