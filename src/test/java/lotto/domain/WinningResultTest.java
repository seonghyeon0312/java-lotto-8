package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WinningResultTest {
    @Test
    @DisplayName("로또 결과에 따른 수익률을 정확히 계산해야 한다")
    void calculateProfit_shouldReturnCorrectProfit() {
        // given
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        result.put(Rank.FIRST, 1);   // 2,000,000,000원
        result.put(Rank.SECOND, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.FIFTH, 0);


        WinningResult winningResult = new WinningResult(result);

        int purchasePrice = 10_000; // 1만 원치 구매

        // when
        winningResult.calculateProfit(purchasePrice);

        // then
        assertEquals(winningResult.getProfit(), 20_000_000.0);

    }

    @Test
    @DisplayName("당첨이 없는 경우 수익률은 0.0% 이어야 한다")
    void calculateProfit_whenNoWinning_thenZeroProfit() {
        // given
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        WinningResult winningResult = new WinningResult(result);

        int purchasePrice = 5_000;

        // when
        winningResult.calculateProfit(purchasePrice);

        // then
        assertEquals(winningResult.getProfit(), 0.0);

    }

}