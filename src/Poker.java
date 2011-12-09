import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Poker {

	private static BufferedReader reader;
	
	private static void getInfo(String path) {
		
		try {
			InputStreamReader inReader = new InputStreamReader(new FileInputStream(
					path)); //filepath will vary, I included in /res folder of project
			reader = new BufferedReader(inReader);
		}
		catch (FileNotFoundException e) { // properly handle exception
			System.err.println("you're a moron, fix the path");
		}
	}
	
	public static int doItUp() {
		
		int counter = 0;
		try {		
			getInfo("res/poker.txt");
			String line = reader.readLine();
			while (line != null) {
			
				if (line.length() != 29) {
					System.err.println("Length is wrong check while loop");
					System.exit(1);
				}	
			
				String[] array = line.split(" ");
			
				if (array.length != 10) {
					System.err.println("Array is not the correct length");
					System.exit(1);
				}
			
				String[] array1 = new String[5], array2 = new String[5];
				for (int i = 0; i < 5; i++) {
					array1[i] = array[i];
					array2[i] = array[i + 5];
				}
			
				ArrayList<Card> cardArray1 = new ArrayList<Card>(), cardArray2 = new ArrayList<Card>();
			
				for (int i = 0; i < 5; i++) {
					Card temp = new Card(array1[i]);
					Card temp2 = new Card(array2[i]);
					cardArray1.add(temp);
					cardArray2.add(temp2);
				}
			
				Hand firstPlayer = new Hand(cardArray1), secondPlayer = new Hand(cardArray2);
			
				if (firstPlayer.getRank() == secondPlayer.getRank()) {
					if (firstPlayer.getHighCard() > secondPlayer.getHighCard())
						counter++;
				}
				else if (firstPlayer.getRank() > secondPlayer.getRank())
					counter++;
				line = reader.readLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return counter;		
	}
	
	public static void main(String[] args) {
		
		System.out.println(Poker.doItUp());
	}
}
