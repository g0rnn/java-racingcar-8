package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            ConsoleView view = new ConsoleView();

            String names = view.readNames();
            String[] carNames = names.split(",");

            List<Car> cars = Arrays.stream(carNames)
                    .map(Car::new)
                    .toList();

            int labs = view.readTryCount();
            Race race = new Race(labs, cars);
            RaceManager raceManager = new RaceManager(race);

            String results = raceManager.start();
            view.writeResults(results);

            List<Car> winners = raceManager.judgeWinners();
            String winnerNames = winners.stream()
                    .map(Car::getName)
                    .collect(Collectors.joining(", "));
            view.writeWinners(winnerNames);
        } finally {
            ConsoleView.release();
        }
    }
}
