package lotto.domain;

public enum Rank {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean bonus;
    private final int prize;

    Rank(int matchCount, boolean bonus, int prize) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, boolean hasBonus) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && hasBonus) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return null;
    }

    public int getPrize() {
        return prize;
    }
    public boolean getBonus() {
        return bonus;
    }
    public String getPrizetoString(){
        return String.format("%,d", prize);
    }
    public int getMatchCount(){return matchCount;}
}
