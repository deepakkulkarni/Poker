package com.task.evaluator;

import com.task.entity.Card;
import com.task.entity.Deck;
import com.task.entity.PokerHand;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

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
        List cards = new ArrayList<>();
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

        PokerHand pokerHand = new PokerHand(cards);

        assertEquals(pokerHand.getCards().size(), 5);
    }

    @Test
    public void should_Evaluate_When_PokerHandHasHighestCard() {
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
        PokerHand pokerHand = new PokerHand(cards);

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator();
        Card card = pokerHandEvaluator.evaluateHighestRankCard(pokerHand);

        assertEquals(TestConstants.RANK.valueOf(card.getRank()).getValue(), TestConstants.RANK.ACE.getValue());
    }

    @Test
    public void should_Pass_When_PokerHandIsStraight() {
        List cards = new ArrayList<>();
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

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator();
        assertEquals(pokerHandEvaluator.isStraightHand(pokerHand), true);
    }

    @Test
    public void should_Pass_When_PokerHandIsStraightFlush() {
        List cards = new ArrayList<>();
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

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator();
        assertEquals(pokerHandEvaluator.isStraightFlushHand(pokerHand), true);
    }

    @Test
    public void should_Pass_When_PokerHandIsFlush() {
        List cards = new ArrayList<>();
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

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator();
        assertEquals(pokerHandEvaluator.isFlushHand(pokerHand), true);
    }

    @Test
    public void should_Pass_When_PokerHandHasFourOfAKindCards() {
        List cards = new ArrayList<>();
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

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator();
        assertEquals(pokerHandEvaluator.isFourOfAKindHand(pokerHand), true);
    }


    @Test
    public void should_Pass_When_PokerHandHasThreeOfAKindCards() {
        List cards = new ArrayList<>();
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

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator();
        assertEquals(pokerHandEvaluator.isThreeOfAKindHand(pokerHand), true);
    }

    @Test
    public void should_Pass_When_PokerHandIsFullHouse() {
        List cards = new ArrayList<>();
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

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator();
        boolean fullHouseHand = pokerHandEvaluator.isFullHouseHand(pokerHand);
        assertEquals(fullHouseHand, true);
    }

    @Test
    public void should_Pass_When_PokerHandIsAPair() {
        List cards = new ArrayList<>();
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

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator();
        boolean fullHouseHand = pokerHandEvaluator.isPairHand(pokerHand);
        assertEquals(fullHouseHand, true);
    }

    @Test
    public void should_Pass_When_PokerHandHasTwoPair() {
        List cards = new ArrayList<>();
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

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator();
        boolean fullHouseHand = pokerHandEvaluator.isTwoPairHand(pokerHand);
        assertEquals(fullHouseHand, true);
    }

}
