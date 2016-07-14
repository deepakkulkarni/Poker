package com.task.poker.core.entity.hand;

import com.task.poker.core.entity.Card;
import com.task.poker.util.Constants;
import com.task.poker.core.evaluator.EvaluationResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 6/30/2016.
 */
public class FourOfAKind extends PokerHand {

    public static final String handType = Constants.PARTIAL_ORDER.FOUR_OF_A_KIND.toString();

    public FourOfAKind(List<Card> cards) {
        super(cards, handType);
    }

    @Override
    public EvaluationResult evaluate() {
        EvaluationResult evaluationResult = new EvaluationResult();
        List<Card> quadrant = new ArrayList<>();
        Card[] card = getSortedCardsArray();
        for (int idx = 0; idx < card.length; idx++) {
            int count = 0;
            quadrant.clear();
            for (int idy = 0; idy < card.length; idy++) {
                if (card[idx].getRankValue() == card[idy].getRankValue()) {
                    quadrant.add(card[idy]);
                    count++;
                }

                if (count == 4) {
                    evaluationResult.setPartialOrder(true);
                    setCardRankOrder(evaluationResult, quadrant);
                    return evaluationResult;
                }
            }
        }
        evaluationResult.setPartialOrder(false);
        return evaluationResult;
    }

    private void setCardRankOrder(EvaluationResult evaluationResult, List<Card> quadrant) {
        getCards().removeAll(quadrant);
        evaluationResult.setPrimary(Constants.RANK.valueOf(quadrant.get(0).getRank()).getValue());
        evaluationResult.setSecondary(Constants.RANK.valueOf(getCards().get(0).getRank()).getValue());
    }
}
