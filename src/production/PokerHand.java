package production;

import java.util.Comparator;
import java.util.List;

/**
 * Created by user on 6/25/2016.
 */
public class PokerHand {

    private List<Card> cards = null;

    private boolean isStraight = false;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List cards) {
        this.cards = cards;
    }

    public boolean isStraight() {
        return isStraight;
    }

    public void setStraight(boolean straight) {
        isStraight = straight;
    }
}
