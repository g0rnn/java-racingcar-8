package racingcar;

import java.util.List;

public class GameManager {

    private final Game game;

    public GameManager(Game game) {
        this.game = game;
    }

    public void start() {
        while (game.canStart()) {
            game.nextLab();
            String labResult = game.currentLabResult();
            System.out.println(labResult);
        }
    }

    public List<Car> judgeWinners() {
        if (game.canStart()) {
            throw new IllegalArgumentException();
        }
        List<Car> cars = game.getCars();

        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);

        return cars.stream()
                .filter(it -> it.getPosition() == maxPosition)
                .toList();
    }
}
