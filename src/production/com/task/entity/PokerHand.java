package com.task.entity;

import com.task.evaluator.EvaluationResult;
import com.task.evaluator.Evaluator;
import com.task.util.Constants;

import java.util.Comparator;
import java.util.List;

/**
 * Created by user on 6/25/2016.
 */
public class PokerHand implements Evaluator {

    private final List<Card> cards;
    private String handType;
    private EvaluationResult evaluationResult;
    private int finalRank;
    private final Comparator<Card> byRank = (c1, c2) -> Integer.compare(Constants.RANK.valueOf(c1.getRank()).getValue(), Constants.RANK.valueOf(c2.getRank()).getValue());

    public PokerHand(List<Card> cards, String handType) {
        this.cards = cards;
        this.handType = handType;
    }

    protected Card[] getSortedCardsArray() {
        List<Card> cards = Card.sortByRank(this.getCards());
        Card card[] = new Card[cards.size()];
        card = cards.toArray(card);
        return card;
    }

    public String getHandType() {
        return handType;
    }

    public PokerHand(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getFinalRank() {
        return finalRank;
    }

    public void setFinalRank(int finalRank) {
        this.finalRank = finalRank;
    }

    public EvaluationResult getEvaluationResult() {
        return evaluationResult;
    }

    protected void sortCardsByRank() {
        getCards().sort(byRank);
    }

    public void setEvaluationResult(EvaluationResult evaluationResult) {
        this.evaluationResult = evaluationResult;
    }
}
