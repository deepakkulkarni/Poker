package production;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by user on 6/25/2016.
 */
public class Deck {
    private List cards = new ArrayList();

    public Deck() {
        initializeCards(cards);
    }

    public List getCards() {
        return cards;
    }

    private void initializeCards(List cards) {
        for (int suiteIndex = 0; suiteIndex < Constants.SUITE.values().length; suiteIndex++) {
            for (int rankIndex = 0; rankIndex < Constants.RANK.values().length; rankIndex++) {
                Card card = new Card(Constants.SUITE.values()[suiteIndex].toString(), Constants.RANK.values()[rankIndex].toString());
                cards.add(card);
            }
        }
    }
}
