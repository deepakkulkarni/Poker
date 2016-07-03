package com.task.entity.hand;

import com.task.entity.Card;
import com.task.entity.PokerHand;
import com.task.evaluator.EvaluationResult;
import com.task.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 6/30/2016.
 */
public class ThreeOfAKind extends PokerHand {

    public static final String handType = Constants.PARTIAL_ORDER.THREE_OF_A_KIND.toString();

    public ThreeOfAKind(List<Card> cards) {
        super(cards, handType);
    }

    @Override
    public EvaluationResult evaluate() {
        EvaluationResult evaluationResult = new EvaluationResult();
        Card[] card = getSortedCardsArray();
        List<Card> triplet = new ArrayList<>();
        for (int idx = 0; idx < card.length; idx++) {
            int count = 0;
            triplet.clear();
            for (int idy = 1; idy < card.length; idy++) {
                if (card[idx].getRankValue() == card[idy].getRankValue()) {
                    count++;
                    triplet.add(card[idy]);
                }

                if (count == 3) {
                    evaluationResult.setPartialOrder(true);
                    setCardRankOrder(evaluationResult, triplet);
                    return evaluationResult;
                }
            }
        }
        evaluationResult.setPartialOrder(false);
        return evaluationResult;
    }

    private void setCardRankOrder(EvaluationResult evaluationResult, List<Card> triplet) {
        getCards().removeAll(triplet);
        sortCardsByRank();
        evaluationResult.setPrimary(Constants.RANK.valueOf(triplet.get(0).getRank()).getValue());

        evaluationResult.setSecondary(Constants.RANK.valueOf(getCards().get(1).getRank()).getValue());
        evaluationResult.setTertiary(Constants.RANK.valueOf(getCards().get(0).getRank()).getValue());
    }

}
