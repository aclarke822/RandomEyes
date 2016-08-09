package net.austinclarke.randomeyes;

/*
 * @author Austin Clarke
 */

public class GDeck {

    public static int numSuits = 4;
    public static int numRanks = 13;
    public static int numCards = numSuits * numRanks;

    private GCard[][] cards;

    public GDeck() {
        cards = new GCard[numSuits][numRanks];
        for (int suit = GCard.DIAMONDS; suit <= GCard.SPADES; suit++) {
            for (int rank = GCard.ACE; rank <= GCard.KING; rank++) {
                cards[suit - 1][rank - 1] = new GCard(rank, suit);
            }
        }
    }

    public GCard getCard(int rank, int suit) {
        return cards[suit - 1][rank - 1];
    }
}