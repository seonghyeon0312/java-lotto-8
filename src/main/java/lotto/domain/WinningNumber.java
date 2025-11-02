package lotto.domain;

public class WinningNumber {
    private final Lotto winningNumber;
    private final int bonusNumber;

    public WinningNumber(Lotto lotto, int bonus) {
        this.bonusNumber = bonus;
        this.winningNumber = lotto;
    }

    public Lotto getWinningNumber() {
        return this.winningNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
