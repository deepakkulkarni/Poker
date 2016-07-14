package com.task.poker.core.entity.hand;

import com.task.poker.core.entity.Card;
import com.task.poker.util.Constants;
import com.task.poker.core.evaluator.EvaluationResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 6/30/2016.
 */
public class FullHouse extends PokerHand {

    public static final String handType = Constants.PARTIAL_ORDER.FULL_HOUSE.toString();

    public FullHouse(List<Card> cards) {
        super(cards, handType);
    }

    @Override
    public EvaluationResult evaluate() {
        EvaluationResult evaluationResult = new EvaluationResult();
        Card[] card = getSortedCardsArray();
        List<Card> pair = new ArrayList<>();
        List<Card> triplet = new ArrayList<>();

        for (int idx = 0; idx < card.length; idx++) {
            int count = 0;
            pair.clear();
            triplet.clear();
            for (int idy = 0; idy < card.length; idy++) {
                if (card[idx].getRankValue() == card[idy].getRankValue()) {
                    triplet.add(card[idy]);
                    count++;
                } else
                    pair.add(card[idy]);
            }
            if (count == 3) {
                if (pair.get(0).getRankValue() == pair.get(1).getRankValue()) {
                    evaluationResult.setPartialOrder(true);
                    setCardRankOrder(evaluationResult, pair, triplet);
                }
            }
        }
        return evaluationResult;
    }

    private void setCardRankOrder(EvaluationResult evaluationResult, List<Card> pair, List<Card> triplet) {
        evaluationResult.setPrimary(Constants.RANK.valueOf(triplet.get(0).getRank()).getValue());
        evaluationResult.setSecondary(Constants.RANK.valueOf(pair.get(0).getRank()).getValue());
    }
}
