package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {

    public String readNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String names = Console.readLine();
        if (names == null || names.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (!names.matches("[a-zA-Z가-힣]+[0-9]*(,[a-zA-Z가-힣]+[0-9]*)*")) {
            throw new IllegalArgumentException();
        }
        return names;
    }

    public int readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String count = Console.readLine();
        if (!count.matches("\\d+")) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(count);
    }

    public void writeResults(String results) {
        System.out.println("실행 결과\n" + results);
    }

    public void writeWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
