package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    @Test
    @DisplayName("금액에 따른 로또 번호 생성")
    public void 금액에_따른_로또_번호_생성() throws Exception{
        //given
        int price = 15000;
        //when
        final Lottos lottos = LottoGenerator.generateLottos(price);

        //then

        assertEquals(lottos.getLottos().size(), 15);
    }
}
