package racingcar;

import java.util.List;

public class RaceManager {

    private final Race race;

    public RaceManager(Race race) {
        this.race = race;
    }

    public void start() {
        while (race.canStart()) {
            race.nextLab();
            String labResult = race.currentLabResult();
            System.out.println(labResult);
        }
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
