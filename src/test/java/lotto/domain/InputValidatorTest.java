package lotto.domain;

import lotto.exception.InvalidException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    @DisplayName("구입금액은 0원 이상")
    public void 구입금액은_0원_이상() throws Exception{
        //given
        int validPrice = 1000;
        int invalidPrice = -1;

        //then
        assertThrows(InvalidException.class, () -> InputValidator.validateInputPrice(invalidPrice));
        assertDoesNotThrow(()->InputValidator.validateInputPrice(validPrice));
    }

    @Test
    @DisplayName("구입 금액은 1,000원 단위")
    public void 구입금액은_1000원_단위() throws Exception{
        //given
        int validPrice= 16000;
        int invalidPrice = 14934;

        //then
        assertThrows(InvalidException.class, () -> InputValidator.validateInputPrice(invalidPrice));
        assertDoesNotThrow(()->InputValidator.validateInputPrice(validPrice));
    }

}