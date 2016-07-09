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
public class TwoPair extends PokerHand {

    public static final String handType = Constants.PARTIAL_ORDER.TWO_PAIRS.toString();

    public TwoPair(List<Card> cards) {
        super(cards, handType);
    }

    @Override
    public EvaluationResult evaluate() {
        EvaluationResult evaluationResult = new EvaluationResult();
        Card[] card = getSortedCardsArray();
        List<Card> pair1 = new ArrayList<>(2);
        List<Card> pair2 = new ArrayList<>(2);

        for (int idx = 0; idx < card.length; idx++) {
            for (int idy = 0; idy < card.length; idy++) {
                if (idx != idy && card[idx].getRankValue() == card[idy].getRankValue()) {
                    if (pair1.size() != 2) {
                        pair1.add(card[idx]);
                        pair1.add(card[idy]);
                        break;
                    }
                    if (pair2.size() != 2 && !pair1.contains(card[idx])) {
                        pair2.add(card[idx]);
                        pair2.add(card[idy]);
                        break;
                    }
                }
            }
            if (pair1.size() == 2 && pair2.size() == 2) {
                evaluationResult.setPartialOrder(true);
                setCardRankOrder(evaluationResult, pair1, pair2);
                return evaluationResult;
            }
        }
        evaluationResult.setPartialOrder(false);
        return evaluationResult;
    }

    private void setCardRankOrder(EvaluationResult evaluationResult, List<Card> pair1, List<Card> pair2) {
        getCards().removeAll(pair1);
        getCards().removeAll(pair2);
        sortCardsByRank();

        if (Constants.RANK.valueOf(pair1.get(0).getRank()).getValue() > Constants.RANK.valueOf(pair2.get(0).getRank()).getValue()) {
            evaluationResult.setPrimary(Constants.RANK.valueOf(pair1.get(0).getRank()).getValue());
            evaluationResult.setSecondary(Constants.RANK.valueOf(pair2.get(0).getRank()).getValue());
        } else {
            evaluationResult.setPrimary(Constants.RANK.valueOf(pair2.get(0).getRank()).getValue());
            evaluationResult.setSecondary(Constants.RANK.valueOf(pair1.get(0).getRank()).getValue());
        }
        evaluationResult.setTertiary(Constants.RANK.valueOf(getCards().get(0).getRank()).getValue());
    }

}
