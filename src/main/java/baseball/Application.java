package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final String GAME_QUIT = "2";

    public static void main(String[] args) {
        Printer.printGameStart();

        boolean gameQuit;
        do {
            runGame();
            Printer.printGameWin();

            Printer.printGameRestartOrQuit();
            String input = Console.readLine();
            GameRestartOrQuit gameRestartOrQuit = new GameRestartOrQuit(input);
            gameQuit = isGameQuit(gameRestartOrQuit.getRestartOrQuitNumber());
        } while(!gameQuit);
    }

    private static void runGame() {
        Computer computerNumbers = new Computer();

        boolean threeStrike;
        do {
            Printer.printInputNumber();
            String input = Console.readLine();
            Player playerNumbers = new Player(input);

            Hint hint = new Hint(computerNumbers.getComputer(), playerNumbers.getPlayerNumbers());
            Printer.printHint(hint);
            threeStrike = isThreeStrike(hint.getStrike());
        } while(!threeStrike);
    }

    private static boolean isThreeStrike(int strike) {
        return strike == 3;
    }

    private static boolean isGameQuit(String number) {
        return number.equals(GAME_QUIT);
    }
}
