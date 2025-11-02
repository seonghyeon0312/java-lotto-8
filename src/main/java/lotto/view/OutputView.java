package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningResult;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void outputGenerateLottos(Lottos lottos) {
        System.out.println(lottos.getLottos().size()+"개를 구매했습니다.");
        for(Lotto lotto : lottos.getLottos()){
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public static void outputLottoResult(WinningResult winningResult){
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Rank, Integer> result = winningResult.getLottoResult();
        Double profit = winningResult.getProfit();

        for(Map.Entry<Rank, Integer> rankCountEntry : result.entrySet()){
            Rank rank = rankCountEntry.getKey();
            Integer count = rankCountEntry.getValue();
            boolean bonus = rank.getBonus();
            if(bonus){
                System.out.println(rank.getMatchCount()+ "개 일치, 보너스 볼 일치 (" +rank.getPrizetoString() + "원) - "+ count +"개");
                continue;
            }
            System.out.println(rank.getMatchCount() + "개 일치 (" +rank.getPrizetoString() + "원) - "+ count +"개");
        }
        System.out.println("총 수익률은 "+profit+"%입니다.");
    }
}
