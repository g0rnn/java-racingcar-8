package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class GameManagerTest {

    @Test
    void 경기_우승자를_결정한다() {
        // given
        Car car = new Car("gyun");
        Game game = new Game(1, List.of(car));
        GameManager gameManager = new GameManager(game);

        // when
        gameManager.start();
        List<Car> winners = gameManager.judgeWinners();

        // then
        assertThat(winners).containsExactly(car);
    }

    @Test
    void 게임이_진행가능할_때_우승자를_결정하려고_하면_예외를_던진다() {
        // given
        Car car = new Car("gyun");
        Game game = new Game(1, List.of(car));
        GameManager gameManager = new GameManager(game);

        // when

        // DO NOT start game
        // gameManager.start();
        assertThrows(IllegalArgumentException.class, gameManager::judgeWinners);
    }
}