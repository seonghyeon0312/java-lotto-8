package lotto.util;

import lotto.exception.InvalidException;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public static int parseInputToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidException("숫자 형식이 잘못되었습니다. 정수를 입력해 주세요.");
        }
    }

    public static List<Integer> parseInputToIntegerList(String numbers) throws InvalidException {
        String[] splitedNumbers = numbers.split(",");
        List<Integer> winningNumber = new ArrayList<>();
        for (String number : splitedNumbers) {
            winningNumber.add(parseInputToInt(number));
        }
        return winningNumber;
    }
}
