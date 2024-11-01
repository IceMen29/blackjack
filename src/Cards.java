import java.lang.String;
import java.util.Arrays;
import java.util.Random;

public class Cards {
    enum Card {
        // Определяем карты для каждой масти
        ACE_SPADES(11, "♠"), KING_SPADES(10, "♠"), QUEEN_SPADES(10, "♠"), JACK_SPADES(10, "♠"),
        TEN_SPADES(10, "♠"), NINE_SPADES(9, "♠"), EIGHT_SPADES(8, "♠"), SEVEN_SPADES(7, "♠"),
        SIX_SPADES(6, "♠"), FIVE_SPADES(5, "♠"), FOUR_SPADES(4, "♠"), THREE_SPADES(3, "♠"), TWO_SPADES(2, "♠"),

        ACE_CLUBS(11, "♣"), KING_CLUBS(10, "♣"), QUEEN_CLUBS(10, "♣"), JACK_CLUBS(10, "♣"),
        TEN_CLUBS(10, "♣"), NINE_CLUBS(9, "♣"), EIGHT_CLUBS(8, "♣"), SEVEN_CLUBS(7, "♣"),
        SIX_CLUBS(6, "♣"), FIVE_CLUBS(5, "♣"), FOUR_CLUBS(4, "♣"), THREE_CLUBS(3, "♣"), TWO_CLUBS(2, "♣"),

        ACE_HEARTS(11, "♥"), KING_HEARTS(10, "♥"), QUEEN_HEARTS(10, "♥"), JACK_HEARTS(10, "♥"),
        TEN_HEARTS(10, "♥"), NINE_HEARTS(9, "♥"), EIGHT_HEARTS(8, "♥"), SEVEN_HEARTS(7, "♥"),
        SIX_HEARTS(6, "♥"), FIVE_HEARTS(5, "♥"), FOUR_HEARTS(4, "♥"), THREE_HEARTS(3, "♥"), TWO_HEARTS(2, "♥"),

        ACE_DIAMONDS(11, "♦"), KING_DIAMONDS(10, "♦"), QUEEN_DIAMONDS(10, "♦"), JACK_DIAMONDS(10, "♦"),
        TEN_DIAMONDS(10, "♦"), NINE_DIAMONDS(9, "♦"), EIGHT_DIAMONDS(8, "♦"), SEVEN_DIAMONDS(7, "♦"),
        SIX_DIAMONDS(6, "♦"), FIVE_DIAMONDS(5, "♦"), FOUR_DIAMONDS(4, "♦"), THREE_DIAMONDS(3, "♦"), TWO_DIAMONDS(2, "♦");

        int value;
        String suit;

        Card(int value, String suit) {
            this.value = value;
            this.suit = suit;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();

        Card[] playerHand = new Card[11];
        Card[] computerHand = new Card[11];


        Card[] cards = Cards.deckGenerate();

        System.out.println(Arrays.toString(cards));

        cards = Cards.putCardInHand(playerHand, 2, cards);
        cards = Cards.putCardInHand(computerHand, 2, cards);
        System.out.println(Arrays.toString(cards));
        System.out.println(Arrays.toString(playerHand));
        System.out.println(Arrays.toString(computerHand));



    }

    public static Card[] deckGenerate() {
        Card[] cards = Card.values();
        return cards;
    }

    public static Card[] removeCardOnIndex(Card[] mass, int index) {

        Card[] receivedArray = new Card[mass.length - 1];

        for (int i = 0; i < index; i++) receivedArray[i] = mass[i];

        for (int i = index; i < receivedArray.length; i++) receivedArray[i] = mass[i + 1];

        return receivedArray;
    }

    public static Card[] putCardInHand(Card[] hand, int count, Card[] deck) {
        Random random = new Random();

        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == null) {
                for (int j = 0; j < count; j++) {
                    int randInt = random.nextInt(0, deck.length);
                    hand[i+j] = deck[randInt];
                    deck = Cards.removeCardOnIndex(deck, randInt);
                }
            break;
            }
        }
        return deck;
    }

}
