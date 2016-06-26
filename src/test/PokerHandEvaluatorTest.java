package test;

import org.junit.Test;
import production.Card;
import production.Deck;
import production.PokerHand;
import production.PokerHandEvaluator;

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
    public void deckShouldHave52Cards() {
        Deck deck = new Deck();
        assertEquals(deck.getCards().size(), 52);
    }

    @Test
    public void pokerHandShouldHoldFiveCards() {
        PokerHand hand = new PokerHand();

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

        hand.setCards(cards);

        assertEquals(hand.getCards().size(), 5);
    }

    @Test
    public void evaluateHighestCardInPokerHand() {
        PokerHand pokerHand = new PokerHand();

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
        pokerHand.setCards(cards);

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator();
        Card card = pokerHandEvaluator.evaluateHighestRankCard(pokerHand);

        assertEquals(TestConstants.RANK.valueOf(card.getRank()).getValue(), TestConstants.RANK.ACE.getValue());
    }

    @Test
    public void evaluateStraightPokerHand() {
        PokerHand pokerHand = new PokerHand();

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
        pokerHand.setCards(cards);

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator();
        boolean isStraightHand = pokerHandEvaluator.isStraightHand(pokerHand);
        assertEquals(isStraightHand, true);
    }

    @Test
    public void evaluateStraightFlushPokerHand() {
        PokerHand pokerHand = new PokerHand();

        List cards = new ArrayList<>();
        Card card1 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.ACE.toString());
        Card card2 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.KING.toString());
        Card card3 = new Card(TestConstants.SUITE.HEART.toString(), TestConstants.RANK.TEN.toString());
        Card card4 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.JACK.toString());
        Card card5 = new Card(TestConstants.SUITE.DIAMOND.toString(), TestConstants.RANK.QUEEN.toString());
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        pokerHand.setCards(cards);

        PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator();
        boolean isStraightFlushHand = pokerHandEvaluator.isStraightFlushHand(pokerHand);
        assertEquals(isStraightFlushHand, true);
    }

}
