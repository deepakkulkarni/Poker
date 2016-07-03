package com.task.evaluator;

import com.task.entity.Card;
import com.task.entity.PokerHand;
import com.task.entity.hand.*;
import com.task.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 6/25/2016.
 */
public class PokerHandEvaluator {

    private PokerHand pokerHand;
    private List<PokerHand> typeOfHands = new ArrayList();

    public PokerHandEvaluator(PokerHand pokerHand) {
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

    public int evaluate() {
        int finalRank = 0;
        for (PokerHand pokerHand : typeOfHands) {
            if (pokerHand.evaluateRank()) {
                finalRank = Constants.PARTIAL_ORDER.valueOf(pokerHand.getHandType()).getValue();
                break;
            }
        }
        return finalRank;
    }

    //Temporary method
    public static void main(String... args) {
        List<PokerHand> pokerHands = composeInput();

        for (PokerHand pokerHand : pokerHands) {
            PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator(pokerHand);
            int finalRank = pokerHandEvaluator.evaluate();
            pokerHand.setFinalRank(finalRank);
        }

        List<PokerHand> result = PokerHand.sortByFinalRank(pokerHands);
        if(result.get(0).getFinalRank() != result.get(1).getFinalRank()) {
            PokerHand winnerPokerHand = result.get(0);
            System.out.println(winnerPokerHand.getFinalRank());
            System.out.println(Constants.PARTIAL_ORDER.values()[winnerPokerHand.getFinalRank() - 1]);
        }
    }

    //Temporary method
    private static List<PokerHand> composeInput() {
        List<PokerHand> pokerHands = new ArrayList<>();
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.ACE.toString());
        Card card2 = new Card(Constants.SUITE.HEART.toString(), Constants.RANK.KING.toString());
        Card card3 = new Card(Constants.SUITE.CLUB.toString(), Constants.RANK.JACK.toString());
        Card card4 = new Card(Constants.SUITE.SPADE.toString(), Constants.RANK.TEN.toString());
        Card card5 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.QUEEN.toString());

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        PokerHand pokerHand1 = new PokerHand(cards);

        List<Card> cards1 = new ArrayList<>();

        Card card11 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.KING.toString());
        Card card12 = new Card(Constants.SUITE.SPADE.toString(), Constants.RANK.THREE.toString());
        Card card13 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.TEN.toString());
        Card card14 = new Card(Constants.SUITE.HEART.toString(), Constants.RANK.JACK.toString());
        Card card15 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.TWO.toString());
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
