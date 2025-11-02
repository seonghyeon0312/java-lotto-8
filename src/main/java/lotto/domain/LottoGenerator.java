package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static Lottos generateLottos(int price) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = price / 1000;

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> integers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(new Lotto(integers));
        }
        return new Lottos(lottos);
    }
}
