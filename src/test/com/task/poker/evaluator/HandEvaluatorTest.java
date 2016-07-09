package com.task.poker.evaluator;

import com.task.poker.entity.Card;
import com.task.poker.entity.Deck;
import com.task.poker.entity.PokerHand;
import com.task.poker.entity.hand.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

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
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.ACE.toString());
        Card card2 = new Card(TestConstants.SUITE.HEART.toString(), TestConstants.RANK.KING.toString());
        Card card3 = new Card(TestConstants.SUITE.CLUB.toString(), TestConstants.RANK.JACK.toString());
        Card card4 = new Card(TestConstants.SUITE.SPADE.toString(), TestConstants.RANK.TEN.toString());
        Card card5 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.ACE.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        PokerHand pokerHand = new Straight(cards);

        assertEquals(pokerHand.getCards().size(), 5);
    }

    @Test
    public void should_Pass_When_PokerHandIsStraightFlush() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.ACE.toString());
        Card card2 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.KING.toString());
        Card card3 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.TEN.toString());
        Card card4 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.JACK.toString());
        Card card5 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.QUEEN.toString());
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
        assertEquals(primaryValue, TestConstants.RANK.ACE.getValue());
        assertEquals(secondaryValue, TestConstants.RANK.KING.getValue());
        assertEquals(tertiaryValue, TestConstants.RANK.QUEEN.getValue());
        assertEquals(quaternaryValue, TestConstants.RANK.JACK.getValue());
        assertEquals(quinaryValue, TestConstants.RANK.TEN.getValue());
    }

    @Test
    public void should_Pass_When_PokerHandIsFlush() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.FOUR.toString());
        Card card2 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.EIGHT.toString());
        Card card3 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.TEN.toString());
        Card card4 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.SEVEN.toString());
        Card card5 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.QUEEN.toString());
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
        assertEquals(primaryValue, TestConstants.RANK.QUEEN.getValue());
        assertEquals(secondaryValue, TestConstants.RANK.TEN.getValue());
        assertEquals(tertiaryValue, TestConstants.RANK.EIGHT.getValue());
        assertEquals(quaternaryValue, TestConstants.RANK.SEVEN.getValue());
        assertEquals(quinaryValue, TestConstants.RANK.FOUR.getValue());

    }

    @Test
    public void should_Pass_When_PokerHandHasFourOfAKindCards() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.NINE.toString());
        Card card2 = new Card(TestConstants.SUITE.HEART.toString(), TestConstants.RANK.NINE.toString());
        Card card3 = new Card(TestConstants.SUITE.CLUB.toString(), TestConstants.RANK.NINE.toString());
        Card card4 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.QUEEN.toString());
        Card card5 = new Card(TestConstants.SUITE.SPADE.toString(), TestConstants.RANK.NINE.toString());
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
        assertEquals(primaryValue, TestConstants.RANK.NINE.getValue());
        assertEquals(secondaryValue, TestConstants.RANK.QUEEN.getValue());
    }

    @Test
    public void should_Pass_When_PokerHandHasThreeOfAKindCards() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.QUEEN.toString());
        Card card2 = new Card(TestConstants.SUITE.HEART.toString(), TestConstants.RANK.FIVE.toString());
        Card card3 = new Card(TestConstants.SUITE.CLUB.toString(), TestConstants.RANK.QUEEN.toString());
        Card card4 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.QUEEN.toString());
        Card card5 = new Card(TestConstants.SUITE.SPADE.toString(), TestConstants.RANK.TEN.toString());
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
        assertEquals(primaryValue, TestConstants.RANK.QUEEN.getValue());
        assertEquals(secondaryValue, TestConstants.RANK.TEN.getValue());
        assertEquals(tertiaryValue, TestConstants.RANK.FIVE.getValue());
    }


    @Test
    public void should_Pass_When_PokerHandIsFullHouse() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.JACK.toString());
        Card card2 = new Card(TestConstants.SUITE.HEART.toString(), TestConstants.RANK.JACK.toString());
        Card card3 = new Card(TestConstants.SUITE.CLUB.toString(), TestConstants.RANK.QUEEN.toString());
        Card card4 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.QUEEN.toString());
        Card card5 = new Card(TestConstants.SUITE.SPADE.toString(), TestConstants.RANK.QUEEN.toString());
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
        assertEquals(primaryValue, TestConstants.RANK.QUEEN.getValue());
        assertEquals(secondaryValue, TestConstants.RANK.JACK.getValue());
    }

    @Test
    public void should_Pass_When_PokerHandIsAPair() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.JACK.toString());
        Card card2 = new Card(TestConstants.SUITE.HEART.toString(), TestConstants.RANK.FOUR.toString());
        Card card3 = new Card(TestConstants.SUITE.CLUB.toString(), TestConstants.RANK.TEN.toString());
        Card card4 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.JACK.toString());
        Card card5 = new Card(TestConstants.SUITE.SPADE.toString(), TestConstants.RANK.SEVEN.toString());
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
        assertEquals(primaryValue, TestConstants.RANK.JACK.getValue());
        assertEquals(secondaryValue, TestConstants.RANK.TEN.getValue());
        assertEquals(tertiaryValue, TestConstants.RANK.SEVEN.getValue());
        assertEquals(quaternaryValue, TestConstants.RANK.FOUR.getValue());
    }

    @Test
    public void should_Pass_When_PokerHandHasTwoPair() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.JACK.toString());
        Card card2 = new Card(TestConstants.SUITE.HEART.toString(), TestConstants.RANK.FOUR.toString());
        Card card3 = new Card(TestConstants.SUITE.CLUB.toString(), TestConstants.RANK.TEN.toString());
        Card card4 = new Card(TestConstants.SUITE.CLUB.toString(), TestConstants.RANK.JACK.toString());
        Card card5 = new Card(TestConstants.SUITE.SPADE.toString(), TestConstants.RANK.FOUR.toString());
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
        assertEquals(primaryValue, TestConstants.RANK.JACK.getValue());
        assertEquals(secondaryValue, TestConstants.RANK.FOUR.getValue());
        assertEquals(tertiaryValue, TestConstants.RANK.TEN.getValue());
    }

    @Test
    public void should_Evaluate_When_PokerHandIsHighCard() {
        List cards = new ArrayList<>();
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.EIGHT.toString());
        Card card2 = new Card(TestConstants.SUITE.HEART.toString(), TestConstants.RANK.KING.toString());
        Card card3 = new Card(TestConstants.SUITE.CLUB.toString(), TestConstants.RANK.JACK.toString());
        Card card4 = new Card(TestConstants.SUITE.SPADE.toString(), TestConstants.RANK.THREE.toString());
        Card card5 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.QUEEN.toString());
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
        assertEquals(primaryValue, TestConstants.RANK.KING.getValue());
        assertEquals(secondaryValue, TestConstants.RANK.QUEEN.getValue());
        assertEquals(tertiaryValue, TestConstants.RANK.JACK.getValue());
        assertEquals(quaternaryValue, TestConstants.RANK.EIGHT.getValue());
        assertEquals(quinaryValue, TestConstants.RANK.THREE.getValue());
    }

    @Test
    public void should_Pass_When_PokerHandIsStraight() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.ACE.toString());
        Card card2 = new Card(TestConstants.SUITE.HEART.toString(), TestConstants.RANK.KING.toString());
        Card card3 = new Card(TestConstants.SUITE.CLUB.toString(), TestConstants.RANK.TEN.toString());
        Card card4 = new Card(TestConstants.SUITE.SPADE.toString(), TestConstants.RANK.JACK.toString());
        Card card5 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.QUEEN.toString());
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
        assertEquals(primaryValue, TestConstants.RANK.ACE.getValue());
        assertEquals(secondaryValue, TestConstants.RANK.KING.getValue());
        assertEquals(tertiaryValue, TestConstants.RANK.QUEEN.getValue());
        assertEquals(quaternaryValue, TestConstants.RANK.JACK.getValue());
        assertEquals(quinaryValue, TestConstants.RANK.TEN.getValue());
    }

    @Test
    public void should_Pass_When_StraightFlushHand_IsDetected() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.ACE.toString());
        Card card2 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.KING.toString());
        Card card3 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.TEN.toString());
        Card card4 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.JACK.toString());
        Card card5 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.QUEEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        PokerHand pokerHand = new PokerHand(cards);

        HandEvaluator handEvaluator = new HandEvaluator(pokerHand);
        EvaluationResult evaluationResult = handEvaluator.evaluate();

        int typeOfHand = evaluationResult.getPartialOrder();
        assertEquals(typeOfHand, TestConstants.PARTIAL_ORDER.STRAIGHT_FLUSH.getValue());
    }

    @Test
    public void should_Pass_When_FourOfAKindHand_IsDetected() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.ACE.toString());
        Card card2 = new Card(TestConstants.SUITE.HEART.toString(), TestConstants.RANK.ACE.toString());
        Card card3 = new Card(TestConstants.SUITE.CLUB.toString(), TestConstants.RANK.ACE.toString());
        Card card4 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.QUEEN.toString());
        Card card5 = new Card(TestConstants.SUITE.SPADE.toString(), TestConstants.RANK.ACE.toString());
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

        assertEquals(typeOfHand, TestConstants.PARTIAL_ORDER.FOUR_OF_A_KIND.getValue());
        assertEquals(primaryValue, TestConstants.RANK.ACE.getValue());
        assertEquals(secondaryValue, TestConstants.RANK.QUEEN.getValue());

    }

    @Test
    public void should_Pass_When_StraightHand_IsDetected() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.ACE.toString());
        Card card2 = new Card(TestConstants.SUITE.HEART.toString(), TestConstants.RANK.KING.toString());
        Card card3 = new Card(TestConstants.SUITE.CLUB.toString(), TestConstants.RANK.TEN.toString());
        Card card4 = new Card(TestConstants.SUITE.SPADE.toString(), TestConstants.RANK.JACK.toString());
        Card card5 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.QUEEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        PokerHand pokerHand = new PokerHand(cards);

        HandEvaluator handEvaluator = new HandEvaluator(pokerHand);
        EvaluationResult evaluationResult = handEvaluator.evaluate();
        int typeOfHand = evaluationResult.getPartialOrder();
        assertEquals(typeOfHand, TestConstants.PARTIAL_ORDER.STRAIGHT.getValue());
    }

    @Test
    public void should_Pass_When_FlushHand_IsDetected() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.ACE.toString());
        Card card2 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.KING.toString());
        Card card3 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.TEN.toString());
        Card card4 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.TWO.toString());
        Card card5 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.QUEEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        PokerHand pokerHand = new PokerHand(cards);

        HandEvaluator handEvaluator = new HandEvaluator(pokerHand);
        EvaluationResult evaluationResult = handEvaluator.evaluate();
        int typeOfHand = evaluationResult.getPartialOrder();
        assertEquals(typeOfHand, TestConstants.PARTIAL_ORDER.FLUSH.getValue());
    }

    @Test
    public void should_Pass_When_FullHouseHand_IsDetected() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.JACK.toString());
        Card card2 = new Card(TestConstants.SUITE.HEART.toString(), TestConstants.RANK.JACK.toString());
        Card card3 = new Card(TestConstants.SUITE.CLUB.toString(), TestConstants.RANK.QUEEN.toString());
        Card card4 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.QUEEN.toString());
        Card card5 = new Card(TestConstants.SUITE.SPADE.toString(), TestConstants.RANK.QUEEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        PokerHand pokerHand = new PokerHand(cards);

        HandEvaluator handEvaluator = new HandEvaluator(pokerHand);
        EvaluationResult evaluationResult = handEvaluator.evaluate();
        int typeOfHand = evaluationResult.getPartialOrder();
        assertEquals(typeOfHand, TestConstants.PARTIAL_ORDER.FULL_HOUSE.getValue());
    }

    @Test
    public void should_Pass_When_ThreeOfAKindHand_IsDetected() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.QUEEN.toString());
        Card card2 = new Card(TestConstants.SUITE.HEART.toString(), TestConstants.RANK.FIVE.toString());
        Card card3 = new Card(TestConstants.SUITE.CLUB.toString(), TestConstants.RANK.QUEEN.toString());
        Card card4 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.QUEEN.toString());
        Card card5 = new Card(TestConstants.SUITE.SPADE.toString(), TestConstants.RANK.TEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        PokerHand pokerHand = new PokerHand(cards);

        HandEvaluator handEvaluator = new HandEvaluator(pokerHand);
        EvaluationResult evaluationResult = handEvaluator.evaluate();
        int typeOfHand = evaluationResult.getPartialOrder();
        assertEquals(typeOfHand, TestConstants.PARTIAL_ORDER.THREE_OF_A_KIND.getValue());
    }

    @Test
    public void should_Pass_When_TwoPairsHand_IsDetected() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.JACK.toString());
        Card card2 = new Card(TestConstants.SUITE.HEART.toString(), TestConstants.RANK.FOUR.toString());
        Card card3 = new Card(TestConstants.SUITE.CLUB.toString(), TestConstants.RANK.TEN.toString());
        Card card4 = new Card(TestConstants.SUITE.CLUB.toString(), TestConstants.RANK.JACK.toString());
        Card card5 = new Card(TestConstants.SUITE.SPADE.toString(), TestConstants.RANK.FOUR.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        PokerHand pokerHand = new PokerHand(cards);

        HandEvaluator handEvaluator = new HandEvaluator(pokerHand);
        EvaluationResult evaluationResult = handEvaluator.evaluate();
        int typeOfHand = evaluationResult.getPartialOrder();
        assertEquals(typeOfHand, TestConstants.PARTIAL_ORDER.TWO_PAIRS.getValue());
    }

    @Test
    public void should_Pass_When_PairHand_IsDetected() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.JACK.toString());
        Card card2 = new Card(TestConstants.SUITE.HEART.toString(), TestConstants.RANK.FOUR.toString());
        Card card3 = new Card(TestConstants.SUITE.CLUB.toString(), TestConstants.RANK.TEN.toString());
        Card card4 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.JACK.toString());
        Card card5 = new Card(TestConstants.SUITE.SPADE.toString(), TestConstants.RANK.SEVEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        PokerHand pokerHand = new PokerHand(cards);

        HandEvaluator handEvaluator = new HandEvaluator(pokerHand);
        EvaluationResult evaluationResult = handEvaluator.evaluate();
        int typeOfHand = evaluationResult.getPartialOrder();
        assertEquals(typeOfHand, TestConstants.PARTIAL_ORDER.PAIR.getValue());
    }

    @Test
    public void should_Pass_When_HighCardHand_IsDetected() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.ACE.toString());
        Card card2 = new Card(TestConstants.SUITE.HEART.toString(), TestConstants.RANK.KING.toString());
        Card card3 = new Card(TestConstants.SUITE.CLUB.toString(), TestConstants.RANK.FOUR.toString());
        Card card4 = new Card(TestConstants.SUITE.SPADE.toString(), TestConstants.RANK.TEN.toString());
        Card card5 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.QUEEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        PokerHand pokerHand = new PokerHand(cards);

        HandEvaluator handEvaluator = new HandEvaluator(pokerHand);
        EvaluationResult evaluationResult = handEvaluator.evaluate();
        int typeOfHand = evaluationResult.getPartialOrder();
        assertEquals(typeOfHand, TestConstants.PARTIAL_ORDER.HIGH_CARD.getValue());
    }
}
