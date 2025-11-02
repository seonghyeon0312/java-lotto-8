package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @Test
    @DisplayName("로또 추첨 결과 계산 테스트")
    public void 로또_추첨_결과_계산_테스트() throws Exception{
        //given
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        int bonus = 7;
        WinningNumber winningLotto = new WinningNumber(lotto, bonus);

        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); // 6개 일치
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); // 5개 + 보너스 일치
        Lotto lotto3 = new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15)); // 미당첨

        List<Lotto> lottoList = Arrays.asList(lotto1, lotto2, lotto3);
        Lottos lottos = new Lottos(lottoList);

        // when
        WinningResult result = lottos.match(winningLotto);

        // then
        assertEquals(result.getLottoResult().get(Rank.FIRST), 1);
        assertEquals(result.getLottoResult().get(Rank.SECOND), 1);

    }

}