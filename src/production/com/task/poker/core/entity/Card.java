package com.task.poker.core.entity;

import com.task.poker.util.Constants;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by user on 6/25/2016.
 */
public class Card {

    public static final Comparator<Card> byRank = (c1, c2) -> Integer.compare(Constants.RANK.valueOf(c1.getRank()).getValue(), Constants.RANK.valueOf(c2.getRank()).getValue());
    private final String suite;
    private final String rank;

    public Card(String suite, String rank) {
        this.suite = suite;
        this.rank = rank;
    }

    public static List<Card> sortByRank(List<Card> cards) {
        Collections.sort(cards, byRank);
        return cards;
    }

    public int getRankValue() {
        return Constants.RANK.valueOf(this.rank).getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (!suite.equals(card.suite)) return false;
        return rank.equals(card.rank);

    }

    @Override
    public int hashCode() {
        int result = suite.hashCode();
        result = 31 * result + rank.hashCode();
        return result;
    }

    public int getSuiteValue() {
        return Constants.SUITE.valueOf(this.suite).getValue();
    }

    @Override
    public String toString() {
        return Constants.SUITE.valueOf(this.suite).getAbbreviation() + Constants.RANK.valueOf(this.rank).getAbbreviation();
    }

    public String getSuite() {
        return suite;
    }

    public String getRank() {
        return rank;
    }
}
