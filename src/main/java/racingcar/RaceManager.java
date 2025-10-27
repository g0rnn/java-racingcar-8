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

    public Cars judgeWinners() {
        if (race.canStart()) {
            throw new IllegalArgumentException();
        }
        Cars cars = race.getCars();
        return cars.filterMaxPosition();
    }
}
