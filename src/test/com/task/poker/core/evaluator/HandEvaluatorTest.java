package com.task.poker.core.evaluator;

import com.task.poker.core.entity.Card;
import com.task.poker.core.entity.Deck;
import com.task.poker.core.entity.hand.*;
import com.task.poker.util.Constants;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 6/25/2016.
 */
public class HandEvaluatorTest {

    @Test
    public void setUpEnvironment() {
        assertEquals(true, true);
    }

    @Test
    public void should_Pass_When_PokerDeckHas52Cards() {
        Deck deck = new Deck();
        assertEquals(deck.getCards().size(), 52);
    }

    @Test
    public void should_Pass_When_PokerHandHasFiveCards() {
        List<Card> cards = new ArrayList<>(5);
        Card card1 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.ACE.toString());
        Card card2 = new Card(Constants.SUITE.HEART.toString(), Constants.RANK.KING.toString());
        Card card3 = new Card(Constants.SUITE.CLUB.toString(), Constants.RANK.JACK.toString());
        Card card4 = new Card(Constants.SUITE.SPADE.toString(), Constants.RANK.TEN.toString());
        Card card5 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.ACE.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        PokerHand pokerHand = new PokerHand(cards);

        assertEquals(pokerHand.getCards().size(), 5);
    }

    @Test
    public void should_Pass_When_PokerHandIsStraightFlush() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.ACE.toString());
        Card card2 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.KING.toString());
        Card card3 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.TEN.toString());
        Card card4 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.JACK.toString());
        Card card5 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.QUEEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        PokerHand pokerHand = new StraightFlush(cards);

        EvaluationResult evaluationResult = pokerHand.evaluate();
        boolean isStraightFlushHand = evaluationResult.isPartialOrder();
        int primaryValue = evaluationResult.getPrimary();
        int secondaryValue = evaluationResult.getSecondary();
        int tertiaryValue = evaluationResult.getTertiary();
        int quaternaryValue = evaluationResult.getQuaternary();
        int quinaryValue = evaluationResult.getQuinary();

        assertEquals(isStraightFlushHand, true);
        assertEquals(primaryValue, Constants.RANK.ACE.getValue());
        assertEquals(secondaryValue, Constants.RANK.KING.getValue());
        assertEquals(tertiaryValue, Constants.RANK.QUEEN.getValue());
        assertEquals(quaternaryValue, Constants.RANK.JACK.getValue());
        assertEquals(quinaryValue, Constants.RANK.TEN.getValue());
    }

    @Test
    public void should_Pass_When_PokerHandIsFlush() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.FOUR.toString());
        Card card2 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.EIGHT.toString());
        Card card3 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.TEN.toString());
        Card card4 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.SEVEN.toString());
        Card card5 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.QUEEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        PokerHand pokerHand = new Flush(cards);

        EvaluationResult evaluationResult = pokerHand.evaluate();
        boolean isFlushHand = evaluationResult.isPartialOrder();
        int primaryValue = evaluationResult.getPrimary();
        int secondaryValue = evaluationResult.getSecondary();
        int tertiaryValue = evaluationResult.getTertiary();
        int quaternaryValue = evaluationResult.getQuaternary();
        int quinaryValue = evaluationResult.getQuinary();

        assertEquals(isFlushHand, true);
        assertEquals(primaryValue, Constants.RANK.QUEEN.getValue());
        assertEquals(secondaryValue, Constants.RANK.TEN.getValue());
        assertEquals(tertiaryValue, Constants.RANK.EIGHT.getValue());
        assertEquals(quaternaryValue, Constants.RANK.SEVEN.getValue());
        assertEquals(quinaryValue, Constants.RANK.FOUR.getValue());

    }

    @Test
    public void should_Pass_When_PokerHandHasFourOfAKindCards() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.NINE.toString());
        Card card2 = new Card(Constants.SUITE.HEART.toString(), Constants.RANK.NINE.toString());
        Card card3 = new Card(Constants.SUITE.CLUB.toString(), Constants.RANK.NINE.toString());
        Card card4 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.QUEEN.toString());
        Card card5 = new Card(Constants.SUITE.SPADE.toString(), Constants.RANK.NINE.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        PokerHand pokerHand = new FourOfAKind(cards);

        EvaluationResult evaluationResult = pokerHand.evaluate();
        boolean isFourOfAKindHand = evaluationResult.isPartialOrder();
        int primaryValue = evaluationResult.getPrimary();
        int secondaryValue = evaluationResult.getSecondary();

        assertEquals(isFourOfAKindHand, true);
        assertEquals(primaryValue, Constants.RANK.NINE.getValue());
        assertEquals(secondaryValue, Constants.RANK.QUEEN.getValue());
    }

    @Test
    public void should_Pass_When_PokerHandHasThreeOfAKindCards() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.QUEEN.toString());
        Card card2 = new Card(Constants.SUITE.HEART.toString(), Constants.RANK.FIVE.toString());
        Card card3 = new Card(Constants.SUITE.CLUB.toString(), Constants.RANK.QUEEN.toString());
        Card card4 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.QUEEN.toString());
        Card card5 = new Card(Constants.SUITE.SPADE.toString(), Constants.RANK.TEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        PokerHand pokerHand = new ThreeOfAKind(cards);

        EvaluationResult evaluationResult = pokerHand.evaluate();
        boolean isThreeOfAKind = evaluationResult.isPartialOrder();
        int primaryValue = evaluationResult.getPrimary();
        int secondaryValue = evaluationResult.getSecondary();
        int tertiaryValue = evaluationResult.getTertiary();

        assertEquals(isThreeOfAKind, true);
        assertEquals(primaryValue, Constants.RANK.QUEEN.getValue());
        assertEquals(secondaryValue, Constants.RANK.TEN.getValue());
        assertEquals(tertiaryValue, Constants.RANK.FIVE.getValue());
    }


    @Test
    public void should_Pass_When_PokerHandIsFullHouse() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.JACK.toString());
        Card card2 = new Card(Constants.SUITE.HEART.toString(), Constants.RANK.JACK.toString());
        Card card3 = new Card(Constants.SUITE.CLUB.toString(), Constants.RANK.QUEEN.toString());
        Card card4 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.QUEEN.toString());
        Card card5 = new Card(Constants.SUITE.SPADE.toString(), Constants.RANK.QUEEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        PokerHand pokerHand = new FullHouse(cards);

        EvaluationResult evaluationResult = pokerHand.evaluate();
        boolean isFullHouseHand = evaluationResult.isPartialOrder();
        int primaryValue = evaluationResult.getPrimary();
        int secondaryValue = evaluationResult.getSecondary();

        assertEquals(isFullHouseHand, true);
        assertEquals(primaryValue, Constants.RANK.QUEEN.getValue());
        assertEquals(secondaryValue, Constants.RANK.JACK.getValue());
    }

    @Test
    public void should_Pass_When_PokerHandIsAPair() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.JACK.toString());
        Card card2 = new Card(Constants.SUITE.HEART.toString(), Constants.RANK.FOUR.toString());
        Card card3 = new Card(Constants.SUITE.CLUB.toString(), Constants.RANK.TEN.toString());
        Card card4 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.JACK.toString());
        Card card5 = new Card(Constants.SUITE.SPADE.toString(), Constants.RANK.SEVEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        PokerHand pokerHand = new Pair(cards);

        EvaluationResult evaluationResult = pokerHand.evaluate();
        int primaryValue = evaluationResult.getPrimary();
        int secondaryValue = evaluationResult.getSecondary();
        int tertiaryValue = evaluationResult.getTertiary();
        int quaternaryValue = evaluationResult.getQuaternary();

        boolean isPair = evaluationResult.isPartialOrder();

        assertEquals(isPair, true);
        assertEquals(primaryValue, Constants.RANK.JACK.getValue());
        assertEquals(secondaryValue, Constants.RANK.TEN.getValue());
        assertEquals(tertiaryValue, Constants.RANK.SEVEN.getValue());
        assertEquals(quaternaryValue, Constants.RANK.FOUR.getValue());
    }

    @Test
    public void should_Pass_When_PokerHandHasTwoPair() {
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
        PokerHand pokerHand = new TwoPair(cards);

        EvaluationResult evaluationResult = pokerHand.evaluate();

        boolean isTwoPair = evaluationResult.isPartialOrder();
        int primaryValue = evaluationResult.getPrimary();
        int secondaryValue = evaluationResult.getSecondary();
        int tertiaryValue = evaluationResult.getTertiary();

        assertEquals(isTwoPair, true);
        assertEquals(primaryValue, Constants.RANK.JACK.getValue());
        assertEquals(secondaryValue, Constants.RANK.FOUR.getValue());
        assertEquals(tertiaryValue, Constants.RANK.TEN.getValue());
    }

    @Test
    public void should_Evaluate_When_PokerHandIsHighCard() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.EIGHT.toString());
        Card card2 = new Card(Constants.SUITE.HEART.toString(), Constants.RANK.KING.toString());
        Card card3 = new Card(Constants.SUITE.CLUB.toString(), Constants.RANK.JACK.toString());
        Card card4 = new Card(Constants.SUITE.SPADE.toString(), Constants.RANK.THREE.toString());
        Card card5 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.QUEEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        PokerHand pokerHand = new HighCard(cards);

        EvaluationResult evaluationResult = pokerHand.evaluate();
        boolean isHighCard = evaluationResult.isPartialOrder();
        int primaryValue = evaluationResult.getPrimary();
        int secondaryValue = evaluationResult.getSecondary();
        int tertiaryValue = evaluationResult.getTertiary();
        int quaternaryValue = evaluationResult.getQuaternary();
        int quinaryValue = evaluationResult.getQuinary();

        assertEquals(isHighCard, true);
        assertEquals(primaryValue, Constants.RANK.KING.getValue());
        assertEquals(secondaryValue, Constants.RANK.QUEEN.getValue());
        assertEquals(tertiaryValue, Constants.RANK.JACK.getValue());
        assertEquals(quaternaryValue, Constants.RANK.EIGHT.getValue());
        assertEquals(quinaryValue, Constants.RANK.THREE.getValue());
    }

    @Test
    public void should_Pass_When_PokerHandIsStraight() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.ACE.toString());
        Card card2 = new Card(Constants.SUITE.HEART.toString(), Constants.RANK.KING.toString());
        Card card3 = new Card(Constants.SUITE.CLUB.toString(), Constants.RANK.TEN.toString());
        Card card4 = new Card(Constants.SUITE.SPADE.toString(), Constants.RANK.JACK.toString());
        Card card5 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.QUEEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        PokerHand pokerHand = new Straight(cards);
        EvaluationResult evaluationResult = pokerHand.evaluate();

        boolean isStraightHand = evaluationResult.isPartialOrder();
        int primaryValue = evaluationResult.getPrimary();
        int secondaryValue = evaluationResult.getSecondary();
        int tertiaryValue = evaluationResult.getTertiary();
        int quaternaryValue = evaluationResult.getQuaternary();
        int quinaryValue = evaluationResult.getQuinary();

        assertEquals(isStraightHand, true);
        assertEquals(primaryValue, Constants.RANK.ACE.getValue());
        assertEquals(secondaryValue, Constants.RANK.KING.getValue());
        assertEquals(tertiaryValue, Constants.RANK.QUEEN.getValue());
        assertEquals(quaternaryValue, Constants.RANK.JACK.getValue());
        assertEquals(quinaryValue, Constants.RANK.TEN.getValue());
    }

    @Test
    public void should_Pass_When_StraightFlushHand_IsDetected() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.ACE.toString());
        Card card2 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.KING.toString());
        Card card3 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.TEN.toString());
        Card card4 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.JACK.toString());
        Card card5 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.QUEEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        PokerHand pokerHand = new PokerHand(cards);

        HandEvaluator handEvaluator = new HandEvaluator(pokerHand);
        EvaluationResult evaluationResult = handEvaluator.evaluate();

        int typeOfHand = evaluationResult.getPartialOrder();
        assertEquals(typeOfHand, Constants.PARTIAL_ORDER.STRAIGHT_FLUSH.getValue());
    }

    @Test
    public void should_Pass_When_FourOfAKindHand_IsDetected() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.ACE.toString());
        Card card2 = new Card(Constants.SUITE.HEART.toString(), Constants.RANK.ACE.toString());
        Card card3 = new Card(Constants.SUITE.CLUB.toString(), Constants.RANK.ACE.toString());
        Card card4 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.QUEEN.toString());
        Card card5 = new Card(Constants.SUITE.SPADE.toString(), Constants.RANK.ACE.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        PokerHand pokerHand = new PokerHand(cards);

        HandEvaluator handEvaluator = new HandEvaluator(pokerHand);
        EvaluationResult evaluationResult = handEvaluator.evaluate();
        int typeOfHand = evaluationResult.getPartialOrder();
        int primaryValue = evaluationResult.getPrimary();
        int secondaryValue = evaluationResult.getSecondary();

        assertEquals(typeOfHand, Constants.PARTIAL_ORDER.FOUR_OF_A_KIND.getValue());
        assertEquals(primaryValue, Constants.RANK.ACE.getValue());
        assertEquals(secondaryValue, Constants.RANK.QUEEN.getValue());

    }

    @Test
    public void should_Pass_When_StraightHand_IsDetected() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.ACE.toString());
        Card card2 = new Card(Constants.SUITE.HEART.toString(), Constants.RANK.KING.toString());
        Card card3 = new Card(Constants.SUITE.CLUB.toString(), Constants.RANK.TEN.toString());
        Card card4 = new Card(Constants.SUITE.SPADE.toString(), Constants.RANK.JACK.toString());
        Card card5 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.QUEEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        PokerHand pokerHand = new PokerHand(cards);

        HandEvaluator handEvaluator = new HandEvaluator(pokerHand);
        EvaluationResult evaluationResult = handEvaluator.evaluate();
        int typeOfHand = evaluationResult.getPartialOrder();
        assertEquals(typeOfHand, Constants.PARTIAL_ORDER.STRAIGHT.getValue());
    }

    @Test
    public void should_Pass_When_FlushHand_IsDetected() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.ACE.toString());
        Card card2 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.KING.toString());
        Card card3 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.TEN.toString());
        Card card4 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.TWO.toString());
        Card card5 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.QUEEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        PokerHand pokerHand = new PokerHand(cards);

        HandEvaluator handEvaluator = new HandEvaluator(pokerHand);
        EvaluationResult evaluationResult = handEvaluator.evaluate();
        int typeOfHand = evaluationResult.getPartialOrder();
        assertEquals(typeOfHand, Constants.PARTIAL_ORDER.FLUSH.getValue());
    }

    @Test
    public void should_Pass_When_FullHouseHand_IsDetected() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.JACK.toString());
        Card card2 = new Card(Constants.SUITE.HEART.toString(), Constants.RANK.JACK.toString());
        Card card3 = new Card(Constants.SUITE.CLUB.toString(), Constants.RANK.QUEEN.toString());
        Card card4 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.QUEEN.toString());
        Card card5 = new Card(Constants.SUITE.SPADE.toString(), Constants.RANK.QUEEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        PokerHand pokerHand = new PokerHand(cards);

        HandEvaluator handEvaluator = new HandEvaluator(pokerHand);
        EvaluationResult evaluationResult = handEvaluator.evaluate();
        int typeOfHand = evaluationResult.getPartialOrder();
        assertEquals(typeOfHand, Constants.PARTIAL_ORDER.FULL_HOUSE.getValue());
    }

    @Test
    public void should_Pass_When_ThreeOfAKindHand_IsDetected() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.QUEEN.toString());
        Card card2 = new Card(Constants.SUITE.HEART.toString(), Constants.RANK.FOUR.toString());
        Card card3 = new Card(Constants.SUITE.CLUB.toString(), Constants.RANK.FOUR.toString());
        Card card4 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.FIVE.toString());
        Card card5 = new Card(Constants.SUITE.SPADE.toString(), Constants.RANK.FOUR.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        PokerHand pokerHand = new PokerHand(cards);

        HandEvaluator handEvaluator = new HandEvaluator(pokerHand);
        EvaluationResult evaluationResult = handEvaluator.evaluate();
        int typeOfHand = evaluationResult.getPartialOrder();
        assertEquals(typeOfHand, Constants.PARTIAL_ORDER.THREE_OF_A_KIND.getValue());
    }

    @Test
    public void should_Pass_When_TwoPairsHand_IsDetected() {
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

        PokerHand pokerHand = new PokerHand(cards);

        HandEvaluator handEvaluator = new HandEvaluator(pokerHand);
        EvaluationResult evaluationResult = handEvaluator.evaluate();
        int typeOfHand = evaluationResult.getPartialOrder();
        assertEquals(typeOfHand, Constants.PARTIAL_ORDER.TWO_PAIRS.getValue());
    }

    @Test
    public void should_Pass_When_PairHand_IsDetected() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.JACK.toString());
        Card card2 = new Card(Constants.SUITE.HEART.toString(), Constants.RANK.FOUR.toString());
        Card card3 = new Card(Constants.SUITE.CLUB.toString(), Constants.RANK.TEN.toString());
        Card card4 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.JACK.toString());
        Card card5 = new Card(Constants.SUITE.SPADE.toString(), Constants.RANK.SEVEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        PokerHand pokerHand = new PokerHand(cards);

        HandEvaluator handEvaluator = new HandEvaluator(pokerHand);
        EvaluationResult evaluationResult = handEvaluator.evaluate();
        int typeOfHand = evaluationResult.getPartialOrder();
        assertEquals(typeOfHand, Constants.PARTIAL_ORDER.PAIR.getValue());
    }

    @Test
    public void should_Pass_When_HighCardHand_IsDetected() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.ACE.toString());
        Card card2 = new Card(Constants.SUITE.HEART.toString(), Constants.RANK.KING.toString());
        Card card3 = new Card(Constants.SUITE.CLUB.toString(), Constants.RANK.FOUR.toString());
        Card card4 = new Card(Constants.SUITE.SPADE.toString(), Constants.RANK.TEN.toString());
        Card card5 = new Card(Constants.SUITE.DIAMOND.toString(), Constants.RANK.QUEEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        PokerHand pokerHand = new PokerHand(cards);

        HandEvaluator handEvaluator = new HandEvaluator(pokerHand);
        EvaluationResult evaluationResult = handEvaluator.evaluate();
        int typeOfHand = evaluationResult.getPartialOrder();
        assertEquals(typeOfHand, Constants.PARTIAL_ORDER.HIGH_CARD.getValue());
    }
}
