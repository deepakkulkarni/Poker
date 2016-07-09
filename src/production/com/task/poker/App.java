package com.task.poker;

import com.task.poker.entity.Card;
import com.task.poker.entity.PokerHand;
import com.task.poker.evaluator.EvaluationResult;
import com.task.poker.evaluator.HandEvaluator;
import com.task.poker.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 7/3/2016.
 */
public class App {

    public static void main(String... args) {
        List<PokerHand> pokerHands = composeInput();
        List<EvaluationResult> evaluationResults = new ArrayList<>();

        for (PokerHand pokerHand : pokerHands) {
            HandEvaluator handEvaluator = new HandEvaluator(pokerHand);
            EvaluationResult evaluationResult = handEvaluator.evaluate();
            evaluationResult.setPokerHand(pokerHand);
            evaluationResults.add(evaluationResult);
        }

        EvaluationResult evaluationResult = new EvaluationResult();
        EvaluationResult winner = evaluationResult.getWinner(evaluationResults);

        winner.getPokerHand().listCards();
        System.out.println(winner.getPartialOrder());
        System.out.println(Constants.PARTIAL_ORDER.values()[winner.getPartialOrder() - 1]);
        System.out.println(winner.getPrimary());
        System.out.println(winner.getSecondary());
        System.out.println(winner.getTertiary());
        System.out.println(winner.getQuaternary());
        System.out.println(winner.getQuinary());
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
