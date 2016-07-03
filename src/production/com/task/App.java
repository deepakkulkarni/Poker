package com.task;

import com.task.entity.Card;
import com.task.entity.PokerHand;
import com.task.evaluator.EvaluationResult;
import com.task.evaluator.PokerHandEvaluator;
import com.task.util.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by user on 7/3/2016.
 */
public class App {

    public static void main(String... args) {
        List<PokerHand> pokerHands = composeInput();
        List<EvaluationResult> evaluationResults = new ArrayList<>();

        for (PokerHand pokerHand : pokerHands) {
            PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator(pokerHand);
            EvaluationResult evaluationResult = pokerHandEvaluator.evaluate();
            pokerHand.setEvaluationResult(evaluationResult);
            evaluationResults.add(evaluationResult);
        }

        Collections.sort(evaluationResults, EvaluationResult.byPartialOrder);

        if (evaluationResults.get(0).getPartialOrder() != evaluationResults.get(1).getPartialOrder()) {
            EvaluationResult evaluationResult = evaluationResults.get(0);
            System.out.println(evaluationResult.getPartialOrder());
            System.out.println(Constants.PARTIAL_ORDER.values()[evaluationResult.getPartialOrder() - 1]);
        } else {
            Collections.sort(evaluationResults, EvaluationResult.byPrimary);
            EvaluationResult evaluationResult = evaluationResults.get(1);
            System.out.println(evaluationResult.getPartialOrder());
            System.out.println(Constants.PARTIAL_ORDER.values()[evaluationResult.getPartialOrder() - 1]);
            System.out.println(evaluationResult.getPrimary());
        }
    }

    private static List<PokerHand> composeInput() {
        List<PokerHand> pokerHands = new ArrayList<>();
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.JACK.toString());
        Card card2 = new Card(Constants.SUITE.HEART.toString(), Constants.RANK.FOUR.toString());
        Card card3 = new Card(Constants.SUITE.CLUB.toString(), Constants.RANK.TEN.toString());
        Card card4 = new Card(Constants.SUITE.CLUB.toString(), Constants.RANK.JACK.toString());
        Card card5 = new Card(Constants.SUITE.SPADE.toString(), Constants.RANK.FOUR.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        PokerHand pokerHand1 = new PokerHand(cards);

        List<Card> cards1 = new ArrayList<>();

        Card card11 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.JACK.toString());
        Card card12 = new Card(Constants.SUITE.HEART.toString(), Constants.RANK.FOUR.toString());
        Card card13 = new Card(Constants.SUITE.CLUB.toString(), Constants.RANK.ACE.toString());
        Card card14 = new Card(Constants.SUITE.CLUB.toString(), Constants.RANK.JACK.toString());
        Card card15 = new Card(Constants.SUITE.SPADE.toString(), Constants.RANK.FOUR.toString());
        cards1.add(card11);
        cards1.add(card12);
        cards1.add(card13);
        cards1.add(card14);
        cards1.add(card15);

        PokerHand pokerHand2 = new PokerHand(cards1);

        pokerHands.add(pokerHand1);
        pokerHands.add(pokerHand2);
        return pokerHands;
    }
}
