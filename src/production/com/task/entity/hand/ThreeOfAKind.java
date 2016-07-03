package com.task.entity.hand;

import com.task.entity.Card;
import com.task.entity.PokerHand;
import com.task.util.Constants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by user on 6/30/2016.
 */
public class ThreeOfAKind extends PokerHand{

    public static final String handType = Constants.PARTIAL_ORDER.THREE_OF_A_KIND.toString();

    public ThreeOfAKind(List<Card> cards) {
        super(cards,handType);
    }

    @Override
    public boolean evaluateRank() {
        Card[] card = getSortedCardsArray();
        for (int idx = 0; idx < card.length; idx++) {
            int count = 0;
            for (int idy = 0; idy < card.length; idy++) {
                if (card[idx].getRankValue() == card[idy].getRankValue())
                    count++;
            }
            if (count == 3)
                return true;
        }
        return false;
    }

}
