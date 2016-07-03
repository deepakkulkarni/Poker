package com.task.entity.hand;

import com.task.entity.Card;
import com.task.entity.PokerHand;
import com.task.util.Constants;

import java.util.Comparator;
import java.util.List;

/**
 * Created by user on 6/30/2016.
 */
public class HighCard extends PokerHand{

    public static final String handType = Constants.PARTIAL_ORDER.HIGH_CARD.toString();
    public static final Comparator<Card> byRank = (c1, c2) -> Integer.compare(Constants.RANK.valueOf(c1.getRank()).getValue(), Constants.RANK.valueOf(c2.getRank()).getValue());

    public HighCard(List<Card> cards) {
        super(cards,handType);
    }

    @Override
    public boolean evaluateRank() {
        return true;
    }
}
