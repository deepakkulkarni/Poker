package com.task.entity;

import com.task.util.Constants;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by user on 6/25/2016.
 */
public class Card {

    private final String suite;
    private final String rank;

    public static final Comparator<Card> byRank = (c1, c2) -> Integer.compare(Constants.RANK.valueOf(c1.getRank()).getValue(), Constants.RANK.valueOf(c2.getRank()).getValue());

    public Card(String suite, String rank) {
        this.suite = suite;
        this.rank = rank;
    }

    public static List<Card> sortByRank(List<Card> cards) {
        Collections.sort(cards, byRank);
        return cards;
    }

    public String getRank() {
        return rank;
    }

    public int getRankValue() {
        return Constants.RANK.valueOf(this.rank).getValue();
    }

    public int getSuiteValue() {
        return Constants.SUITE.valueOf(this.suite).getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return rank.equals(card.rank);

    }

    @Override
    public int hashCode() {
        return rank.hashCode();
    }

    @Override
    public String toString() {
        return "Card{" +
                "suite='" + suite + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
