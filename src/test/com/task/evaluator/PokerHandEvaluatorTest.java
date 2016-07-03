package com.task.evaluator;

import com.task.entity.Card;
import com.task.entity.Deck;
import com.task.entity.PokerHand;
import com.task.entity.hand.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Created by user on 6/25/2016.
 */
public class PokerHandEvaluatorTest {

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

        boolean isStraightFlushHand = pokerHand.evaluateRank();

        assertEquals(isStraightFlushHand, true);
    }

    @Test
    public void should_Pass_When_PokerHandIsFlush() {
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
        PokerHand pokerHand = new Flush(cards);

        boolean isFlushHand = pokerHand.evaluateRank();
        assertEquals(isFlushHand, true);
    }

    @Test
    public void should_Pass_When_PokerHandHasFourOfAKindCards() {
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
        PokerHand pokerHand = new FourOfAKind(cards);

        boolean isFourOfAKindHand = pokerHand.evaluateRank();

        assertEquals(isFourOfAKindHand, true);
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

        boolean isThreeOfAKind = pokerHand.evaluateRank();

        assertEquals(isThreeOfAKind, true);
    }


    @Test
    public void should_Pass_When_PokerHandIsFullHouse() {
        List <Card>cards = new ArrayList<>();
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

        boolean fullHouseHand = pokerHand.evaluateRank();

        assertEquals(fullHouseHand, true);
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

        boolean fullHouseHand = pokerHand.evaluateRank();
        assertEquals(fullHouseHand, true);
    }

    @Test
    public void should_Pass_When_PokerHandHasTwoPair() {
        List <Card>cards = new ArrayList<>();
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

        boolean fullHouseHand = pokerHand.evaluateRank();
        assertEquals(fullHouseHand, true);
    }

    @Test
    public void should_Evaluate_When_PokerHandIsHighCard() {
        List cards = new ArrayList<>();
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.ACE.toString());
        Card card2 = new Card(TestConstants.SUITE.HEART.toString(), TestConstants.RANK.KING.toString());
        Card card3 = new Card(TestConstants.SUITE.CLUB.toString(), TestConstants.RANK.JACK.toString());
        Card card4 = new Card(TestConstants.SUITE.SPADE.toString(), TestConstants.RANK.TEN.toString());
        Card card5 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.QUEEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        PokerHand pokerHand = new HighCard(cards);

        boolean fullHouseHand = pokerHand.evaluateRank();
        assertEquals(fullHouseHand, true);
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
        boolean isStraightHand = pokerHand.evaluateRank();
        assertEquals(isStraightHand, true);
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

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator(pokerHand);
        int typeOfHand = pokerHandEvaluator.evaluate();
        assertSame(typeOfHand,TestConstants.PARTIAL_ORDER.STRAIGHT_FLUSH.getValue());
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

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator(pokerHand);
        int typeOfHand = pokerHandEvaluator.evaluate();
        assertSame(typeOfHand,TestConstants.PARTIAL_ORDER.FOUR_OF_A_KIND.getValue());
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

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator(pokerHand);
        int typeOfHand = pokerHandEvaluator.evaluate();
        assertSame(typeOfHand,TestConstants.PARTIAL_ORDER.FULL_HOUSE.getValue());
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

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator(pokerHand);
        int typeOfHand = pokerHandEvaluator.evaluate();
        assertSame(typeOfHand,TestConstants.PARTIAL_ORDER.FLUSH.getValue());
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

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator(pokerHand);
        int typeOfHand = pokerHandEvaluator.evaluate();
        assertEquals(typeOfHand,TestConstants.PARTIAL_ORDER.STRAIGHT.getValue());
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

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator(pokerHand);
        int finalRank = pokerHandEvaluator.evaluate();
        pokerHand.setFinalRank(finalRank);
        assertEquals(pokerHand.getFinalRank(),TestConstants.PARTIAL_ORDER.THREE_OF_A_KIND.getValue());
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

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator(pokerHand);
        int typeOfHand = pokerHandEvaluator.evaluate();
        assertEquals(typeOfHand,TestConstants.PARTIAL_ORDER.TWO_PAIRS.getValue());
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

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator(pokerHand);
        int typeOfHand = pokerHandEvaluator.evaluate();
        assertEquals(typeOfHand,TestConstants.PARTIAL_ORDER.PAIR.getValue());
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

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator(pokerHand);
        int typeOfHand = pokerHandEvaluator.evaluate();
        assertEquals(typeOfHand,TestConstants.PARTIAL_ORDER.HIGH_CARD.getValue());
    }
}
