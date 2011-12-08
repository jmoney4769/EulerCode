import java.util.ArrayList;
import java.util.Collections;


public class Hand {

	private int rank;
	private Card highCard;
	
	public Hand(ArrayList<Card> array) {
		
		if (array.size() != 5) {
			System.err.println("Incorrect number of cards in hand");
			System.exit(1);
		}
		setRank(array);
	}
	
	public int getRank() {
		return rank;
	}
	public Card getHighCard() {
		return highCard;
	}
	public void setRank(ArrayList<Card> array) {
		
		Collections.sort(array);
		
		if ((array.get(0).getSuit().equals(array.get(1).getSuit())) && 
				(array.get(0).getSuit().equals(array.get(2).getSuit())) 
				&& (array.get(0).getSuit().equals(array.get(3).getSuit())) && 
				(array.get(0).getSuit().equals(array.get(4).getSuit()))) { // flush
			if (isStraight(array)) {
				if (array.get(0).getValue() == 9)
					rank = 10;
				else
					rank = 9;
			}
			else
				rank = 6;
			return;
		}
		if (isStraight(array)) {
			rank = 5;
			return;
		}
		
	}

	private boolean isStraight(ArrayList<Card> array) {
		
		if (((array.get(1).getValue() - array.get(0).getValue()) == 1) && 
				((array.get(2).getValue() - array.get(1).getValue()) == 1) &&
				((array.get(3).getValue() - array.get(2).getValue()) == 1) && 
				((array.get(4).getValue() - array.get(3).getValue()) == 1))
			return true;
		return false;
	}
	private boolean three(ArrayList<Card> array) {
		
		int ints[] = new int[5];
		
		
		return false;
	}
}
