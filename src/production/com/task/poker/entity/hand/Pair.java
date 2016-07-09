package com.task.poker.entity.hand;

import com.task.poker.entity.Card;
import com.task.poker.entity.PokerHand;
import com.task.poker.evaluator.EvaluationResult;
import com.task.poker.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 6/30/2016.
 */
public class Pair extends PokerHand {

    public static final String handType = Constants.PARTIAL_ORDER.PAIR.toString();

    public Pair(List<Card> cards) {
        super(cards, handType);
    }

    @Override
    public EvaluationResult evaluate() {
        EvaluationResult evaluationResult = new EvaluationResult();
        Card[] card = getSortedCardsArray();
        List<Card> pair = new ArrayList<>(2);
        for (int idx = 0; idx < card.length; idx++) {
            int count = 0;
            for (int idy = 0; idy < card.length; idy++) {
                if (card[idx].getRankValue() == card[idy].getRankValue())
                    count++;

                if (count == 2) {
                    evaluationResult.setPartialOrder(true);
                    pair.add(card[idx]);
                    pair.add(card[idy]);
                    setCardRankOrder(evaluationResult, pair);
                    return evaluationResult;
                }
            }
        }

        evaluationResult.setPartialOrder(false);
        return evaluationResult;
    }

    private void setCardRankOrder(EvaluationResult evaluationResult, List<Card> pair) {
        getCards().removeAll(pair);
        sortCardsByRank();

        evaluationResult.setPrimary(Constants.RANK.valueOf(pair.get(0).getRank()).getValue());
        evaluationResult.setSecondary(Constants.RANK.valueOf(getCards().get(2).getRank()).getValue());
        evaluationResult.setTertiary(Constants.RANK.valueOf(getCards().get(1).getRank()).getValue());
        evaluationResult.setQuaternary(Constants.RANK.valueOf(getCards().get(0).getRank()).getValue());

    }

}
