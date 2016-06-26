package production;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by user on 6/25/2016.
 */
public class Card {

    private final String suite;
    private final String rank;

    public Card(String suite, String rank) {
        this.suite = suite;
        this.rank = rank;
    }

    public String getSuite() {
        return suite;
    }

    public String getRank() {
        return rank;
    }

    public static final Comparator<Card> byRank = (c1, c2) -> Integer.compare(Constants.RANK.valueOf(c1.getRank()).getValue(), Constants.RANK.valueOf(c2.getRank()).getValue());

    public static Card evaluateHighestRank(List<Card> cards) {
        return cards.stream().max(byRank).get();
    }

    public static List<Card> sortByRank(List<Card> cards) {
        Collections.sort(cards, byRank);
        return cards;
    }

    public int getRankValue() {
        return Constants.RANK.valueOf(this.rank).getValue();
    }

    public int getSuiteValue() {
        return Constants.SUITE.valueOf(this.suite).getValue();
    }

    @Override
    public String toString() {
        return "Card{" +
                "suite='" + suite + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }


}
