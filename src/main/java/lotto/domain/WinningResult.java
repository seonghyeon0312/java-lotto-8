package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {

    private Map<Rank, Integer> lottoResult;
    private Double profit;

    public WinningResult(Map<Rank, Integer> result) {
        this.lottoResult = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            this.lottoResult.put(rank, result.getOrDefault(rank, 0));
        }
        profit = 0.0;
    }

    public Map<Rank, Integer> getLottoResult() {
        return this.lottoResult;
    }

    public Double getProfit() {
        return this.profit;
    }

    public void calculateProfit(int price) {
        int totalPrize = 0;

        for (Map.Entry<Rank, Integer> entry : lottoResult.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += rank.getPrize() * count;
        }

        this.profit = Math.round(((double) totalPrize / price) * 1000) / 10.0;
    }
}
