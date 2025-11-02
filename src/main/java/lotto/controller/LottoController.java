package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.util.InputParser;

import java.util.List;

public class LottoController {


    public void run() {
        try {
            Integer price = InputParser.parseInputToInt(InputView.inputPrice());
            InputValidator.validateInputPrice(price);
            Lottos lottos = LottoGenerator.generateLottos(price);
            OutputView.outputGenerateLottos(lottos);
            List<Integer> winningNumbers = InputParser.parseInputToIntegerList(InputView.inputWinningNumbers());
            Lotto winningLotto = new Lotto(winningNumbers);
            int bonusNumber = InputParser.parseInputToInt(InputView.inputBonusNumber());
            WinningNumber win = new WinningNumber(winningLotto, bonusNumber);
            WinningResult result = lottos.match(win);
            result.calculateProfit(price);
            OutputView.outputLottoResult(result);
        } catch (IllegalArgumentException err) {
            throw err;
        }
    }
}
