package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        String[] carNames = names.split(",");

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String count = Console.readLine();
        int labs = Integer.parseInt(count);
        Game game = new Game(labs, cars);
        GameManager gameManager = new GameManager(game);

        System.out.println("실행 결과");
        gameManager.start();

        List<Car> winners = gameManager.judgeWinners();
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);

        Console.close();
    }
}
