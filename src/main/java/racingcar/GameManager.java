package racingcar;

public class GameManager {

    private final Game game;

    GameManager(Game game) {
        this.game = game;
    }

    public void start() {
        if (game.canStart()) {
            game.nextLab();
        }
    }
}
