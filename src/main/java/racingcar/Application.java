package racingcar;

public class Application {
    public static void main(String[] args) {
        try {
            ConsoleView view = new ConsoleView();

            String names = view.readNames();
            String[] carNames = names.split(",");

            int labs = view.readTryCount();
            Race race = new Race(labs, Cars.of(carNames));
            RaceManager raceManager = new RaceManager(race);

            String results = raceManager.start();
            view.writeResults(results);

            Cars winners = raceManager.judgeWinners();
            String winnerNames = winners.getNames();
            view.writeWinners(winnerNames);
        } finally {
            ConsoleView.release();
        }
    }
}
