package com.task.poker.core.evaluator;

import com.task.poker.core.entity.hand.*;
import com.task.poker.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 6/25/2016.
 */
public final class HandEvaluator {

    private final PokerHand pokerHand;
    private final List<PokerHand> typeOfHands = new ArrayList<>();

    public HandEvaluator(final PokerHand pokerHand) {
        this.pokerHand = pokerHand;
        typeOfHands.add(new StraightFlush(this.pokerHand.getCards()));
        typeOfHands.add(new FourOfAKind(this.pokerHand.getCards()));
        typeOfHands.add(new FullHouse(this.pokerHand.getCards()));
        typeOfHands.add(new Flush(this.pokerHand.getCards()));
        typeOfHands.add(new Straight(this.pokerHand.getCards()));
        typeOfHands.add(new ThreeOfAKind(this.pokerHand.getCards()));
        typeOfHands.add(new TwoPair(this.pokerHand.getCards()));
        typeOfHands.add(new Pair(this.pokerHand.getCards()));
        typeOfHands.add(new HighCard(this.pokerHand.getCards()));
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