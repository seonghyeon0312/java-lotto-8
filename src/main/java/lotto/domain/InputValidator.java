package lotto.domain;

import lotto.exception.InvalidException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static void validateInputPrice(Integer price) throws IllegalArgumentException {
        validateInputPriceIsMinus(price);
        validateInputPriceDivisibleByThousand(price);
    }

    public static boolean validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> duplicationNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (duplicationNumbers.contains(number)) {
                return true;
            }
            duplicationNumbers.add(number);
        }
        return false;
    }

    public static boolean validateInvalidNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                return true;
            }
        }
        return false;
    }

    private static void validateInputPriceIsMinus(Integer price) {
        if (price < 0) {
            throw new InvalidException("구입 금액은 0원 이상으로 입력해야 합니다.");
        }
    }

    private static void validateInputPriceDivisibleByThousand(Integer price) {
        if (price % 1000 != 0) {
            throw new InvalidException("구입 금액은 1,000원 단위여야 합니다.");
        }
    }

}
