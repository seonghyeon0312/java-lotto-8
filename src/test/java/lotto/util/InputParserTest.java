package lotto.util;

import lotto.exception.InvalidException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    @DisplayName("숫자 형식이 아닐때는 에러 반환")
    public void 숫자_형식이_아닐때는_에러() throws Exception{
        //given
        String input = "2300.";
        String validInput = "23000";
        //when
        final int result = InputParser.parseInputToInt(validInput);

        //then
        assertThrows(InvalidException.class, ()-> InputParser.parseInputToInt(input));
        assertEquals(result, 23000);
    }
}