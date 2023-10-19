package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> playerNumbers;

    public Player(String input) {
        this.playerNumbers = generatePlayerNumbers(input);
    }

    private List<Integer> generatePlayerNumbers(String input) {
        validateNotZero(input);
        validateNumberDigit(input);
        List<Integer> numbers = new ArrayList<>();
        for (char num : input.toCharArray()) {
            int number = num - '0';
            validateRedundantNumber(numbers, number);
            numbers.add(number);
        }
        return numbers;
    }

    private void validateNotZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberDigit(String input) {
        if(input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRedundantNumber(List<Integer> numbers, int number) {
        if(numbers.contains(number)){
            throw new IllegalArgumentException();
        }
    }
}
