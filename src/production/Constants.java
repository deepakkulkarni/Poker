package production;

/**
 * Created by user on 6/26/2016.
 */
public class Constants {

    public enum SUITE {HEART(1), DIAMOND(2), SPADE(3), CLUB(4);
        private final int value;

        SUITE(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum RANK {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(11), QUEEN(12), KING(13), ACE(14);

        private final int value;

        RANK(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }
}