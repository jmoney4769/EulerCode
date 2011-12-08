
public class Card implements Comparable<Card>{

	private String suit;
	private int value;
	
	public Card(String info) {
		
		char[] array = info.toCharArray();
		setValue(array[0]);
		setSuit(array[1]);
	}
	
	public String getSuit() {
		return suit;
	}
	public int getValue() {
		return value;
	}
	public void setSuit(char suit) {
		if (suit == 'C')
			this.suit = "clubs";
		if (suit == 'D')
			this.suit = "diamonds";
		if (suit == 'H')
			this.suit = "hearts";
		if (suit == 'S')
			this.suit = "spades";
	}
	public void setValue(char value) {
		try {
			this.value = Integer.parseInt(Character.toString(value)) - 1;			
		}
		catch (Exception e) {
			if (value == 'K')
				this.value = 13;
			if (value == 'A')
				this.value = 14;
			if (value == 'Q')
				this.value = 12;
			if (value == 'J')
				this.value = 11;
		}
	}

	@Override
	public int compareTo(Card o) {
		if (this.getValue() > o.getValue())
			return 1;
		else if (this.getValue() < o.getValue())
			return -1;
		return 0;
	}
	
	@Override
	public String toString() {
		
		return String.format("%.0f of %s", getValue(), getSuit());
	}
}
