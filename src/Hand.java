import java.util.ArrayList;
import java.util.Collections;


public class Hand {

	private int rank;
	private int highCard;
	
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
	public int getHighCard() {
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
		
		int number = number(array);
		if (number == 4) {
			rank = 8;
			return;
		}
		else if (number == 3) {
			rank = 4;
			return;
		}
		else if (number == 2) {
			rank = 2;
			return;
		}
		else if (number == 22) {
			rank = 3;
			return;
		}
		else if (number == 32) {
			rank = 7;
			return;
		}
		else {
			if (number != 1) {
				System.err.println("No rank lolwut");
				System.exit(2);
			}
			int temp = 0;
			for (int i = 0; i < 5; i++) {
				if (temp < array.get(i).getValue())
					temp = array.get(i).getValue();
			}
			rank = 1;
			highCard = temp;
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
	private int number(ArrayList<Card> array) {
		
		int ints[] = new int[5];
		int howMany[] = new int[5];
		
		for (int i = 0; i < 5; i++)
			ints[i] = array.get(i).getValue();
		for (int i = 0; i < 5; i++) {
			int counter = 0;
			for (int j = 0; j < 5; j++) {
				if (ints[i] == ints[j]) {
						counter++;
				}				
			}
			howMany[i] = counter;
			
		}
		boolean b = false;
		boolean c = false;
		int temp = 0;
		for (int i = 0; i < 5; i++) {
			if (howMany[i] > temp) {
				temp = howMany[i];
				if (howMany[i] == 2)
					b = true;
				if ((howMany[i] == 2) && b)
					c = true;
			}
		}
		if (temp == 4)
			return 4;
		else if ((temp == 2) && c) 
			return 22;
		else if (temp == 2)
			return 2;
		else if (temp == 1)
			return 1;
		else if ((temp == 3) && b) 
			return 32;
		else if (temp == 3) 
			return 3;

		return 0;
	}
}
