package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        if (names == null || names.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (!names.matches("[a-zA-Z가-힣]+[0-9]*(,[a-zA-Z가-힣]+[0-9]*)*")) {
            throw new IllegalArgumentException();
        }
        String[] carNames = names.split(",");

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String count = Console.readLine();
        if (!count.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
        int labs = Integer.parseInt(count);
        Race race = new Race(labs, cars);
        RaceManager raceManager = new RaceManager(race);

        System.out.println("실행 결과");
        raceManager.start();

        List<Car> winners = raceManager.judgeWinners();
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);

        Console.close();
    }
}
