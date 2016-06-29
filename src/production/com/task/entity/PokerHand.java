package com.task.entity;

import java.util.List;

/**
 * Created by user on 6/25/2016.
 */
public class PokerHand {

    private List<Card> cards = null;
    private String partialOrder = null;
    private int finalRank = -1;

    public PokerHand(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setPartialOrder(String partialOrder) {
        this.partialOrder = partialOrder;
    }

    public void setFinalRank(int finalRank) {
        this.finalRank = finalRank;
    }

    public String getPartialOrder() {
        return partialOrder;
    }

    public int getFinalRank() {
        return finalRank;
    }


}
