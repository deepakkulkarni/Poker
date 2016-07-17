package com.task.poker.core.entity.hand;

import com.task.poker.core.entity.Card;
import com.task.poker.core.evaluator.EvaluationResult;
import com.task.poker.util.Constants;

import java.util.List;

/**
 * Created by user on 6/30/2016.
 */
public final class HighCard extends PokerHand {

    public static final String handType = Constants.PARTIAL_ORDER.HIGH_CARD.toString();

    public HighCard(final List<Card> cards) {
        super(cards, handType);
    }

    @Override
    public EvaluationResult evaluate() {
        EvaluationResult evaluationResult = new EvaluationResult();
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
