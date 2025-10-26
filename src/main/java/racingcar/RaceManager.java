package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {

    private final Race race;

    public RaceManager(Race race) {
        this.race = race;
    }

    public String start() {
        List<String> results = new ArrayList<>();

        while (race.canStart()) {
            race.nextLab();
            String labResult = race.currentLabResult();
            results.add(labResult);
        }

        return String.join("\n", results);
    }

    public List<Car> judgeWinners() {
        if (race.canStart()) {
            throw new IllegalArgumentException();
        }
        List<Car> cars = race.getCars();

        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);

        return cars.stream()
                .filter(it -> it.getPosition() == maxPosition)
                .toList();
    }
}
