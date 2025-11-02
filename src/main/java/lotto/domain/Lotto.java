package lotto.domain;

import lotto.exception.InvalidException;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InvalidException("로또 번호는 6개여야 합니다.");
        }

        if (InputValidator.validateDuplicateNumbers(numbers)) {
            throw new InvalidException("로또 번호는 중복되지 않아야 합니다.");
        }

        if (InputValidator.validateInvalidNumbers(numbers)) {
            throw new InvalidException("로또 번호는 1에서 45사이의 번호여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
