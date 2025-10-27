package racingcar;

import java.util.List;

public class RaceManager {

    private final Race race;

    public RaceManager(Race race) {
        this.race = race;
    }

    public String start() {
        while (race.canStart()) {
            race.nextLab();
        }
        List<String> labResults = race.getLabResults();
        return String.join("\n", labResults);
    }

    public Cars judgeWinners() {
        if (race.canStart()) {
            throw new IllegalArgumentException();
        }
        Cars cars = race.getCars();
        return cars.filterMaxPosition();
    }
}
