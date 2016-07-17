package com.task.poker.core.entity.hand;

import com.task.poker.core.entity.Card;
import com.task.poker.util.Constants;
import com.task.poker.core.evaluator.EvaluationResult;

import java.util.List;

/**
 * Created by user on 6/30/2016.
 */
public final class StraightFlush extends PokerHand {

    public static final String handType = Constants.PARTIAL_ORDER.STRAIGHT_FLUSH.toString();

    public StraightFlush(final List<Card> cards) {
        super(cards, handType);
    }

    public EvaluationResult evaluate() {
        EvaluationResult evaluationResult = new EvaluationResult();
        Card[] card = getSortedCardsArray();
        for (int idx = 1; idx < card.length; idx++) {
            if (card[idx].getSuiteValue() != card[idx - 1].getSuiteValue() || card[idx].getRankValue() - card[idx - 1].getRankValue() != 1) {
                evaluationResult.setPartialOrder(false);
                return evaluationResult;
            }
        }
        evaluationResult.setPartialOrder(true);
        setCardRankOrder(evaluationResult);
        return evaluationResult;
    }

    private void setCardRankOrder(final EvaluationResult evaluationResult) {
        sortCardsByRank();
        evaluationResult.setPrimary(Constants.RANK.valueOf(getCards().get(4).getRank()).getValue());
        evaluationResult.setSecondary(Constants.RANK.valueOf(getCards().get(3).getRank()).getValue());
        evaluationResult.setTertiary(Constants.RANK.valueOf(getCards().get(2).getRank()).getValue());
        evaluationResult.setQuaternary(Constants.RANK.valueOf(getCards().get(1).getRank()).getValue());
        evaluationResult.setQuinary(Constants.RANK.valueOf(getCards().get(0).getRank()).getValue());
    }
}
