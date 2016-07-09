package com.task.poker.evaluator;

import com.task.poker.entity.PokerHand;
import com.task.poker.entity.hand.*;
import com.task.poker.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 6/25/2016.
 */
public class HandEvaluator {

    private PokerHand pokerHand;
    private List<PokerHand> typeOfHands = new ArrayList();

    public HandEvaluator(PokerHand pokerHand) {
        this.pokerHand = pokerHand;
        typeOfHands.add(new StraightFlush(pokerHand.getCards()));
        typeOfHands.add(new FourOfAKind(pokerHand.getCards()));
        typeOfHands.add(new FullHouse(pokerHand.getCards()));
        typeOfHands.add(new Flush(pokerHand.getCards()));
        typeOfHands.add(new Straight(pokerHand.getCards()));
        typeOfHands.add(new ThreeOfAKind(pokerHand.getCards()));
        typeOfHands.add(new TwoPair(pokerHand.getCards()));
        typeOfHands.add(new Pair(pokerHand.getCards()));
        typeOfHands.add(new HighCard(pokerHand.getCards()));
    }

    public EvaluationResult evaluate() {
        EvaluationResult evaluationResult = null;
        for (PokerHand pokerHand : typeOfHands) {
            evaluationResult = pokerHand.evaluate();
            if (evaluationResult != null && evaluationResult.isPartialOrder()) {
                evaluationResult.setPartialOrder(Constants.PARTIAL_ORDER.valueOf(pokerHand.getHandType()).getValue());
                break;
            }
        }
        return evaluationResult;
    }

}
