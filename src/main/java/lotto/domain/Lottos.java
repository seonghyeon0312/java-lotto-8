package lotto.domain;

import java.util.*;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public WinningResult match(WinningNumber winningNumber) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);

        for (Lotto lotto : lottos) {
            Rank rank = matchLotto(lotto, winningNumber);
            if (rank != null) {
                result.put(rank, result.getOrDefault(rank, 0) + 1);
            }
        }

        return new WinningResult(result);
    }

    private Rank matchLotto(Lotto genLotto, WinningNumber winningLotto) {
        Lotto target = winningLotto.getWinningNumber();
        Integer bonus = winningLotto.getBonusNumber();

        Set<Integer> targetNumbers = new HashSet<>(genLotto.getNumbers());
        int matchCount = 0;
        for (Integer lottoNumber : target.getNumbers()) {
            if (targetNumbers.contains(lottoNumber)) {
                matchCount++;
            }
        }

        boolean hasBonus = targetNumbers.contains(bonus);
        return Rank.valueOf(matchCount, hasBonus);
    }
}