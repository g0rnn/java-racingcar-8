package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        Set<Car> cars = race.getCars();
        return filterMaxPosition(cars);
    }

    private List<Car> filterMaxPosition(Set<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int max = -1;

        for (Car car : cars) {
            int p = car.getPosition();
            if (max < p) {
                max = p;
                winners.clear();
                winners.add(car);
            } else if (max == p) {
                winners.add(car);
            }
        }

        return winners;
    }
}
