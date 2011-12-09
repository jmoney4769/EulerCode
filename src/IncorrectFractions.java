import java.util.ArrayList;


public class IncorrectFractions {

	private static boolean checkIfWorks(String fraction) {
		if (seeIfLegit(fraction))
			return false;
		String bottom = fraction.substring(2);
		String top = fraction.substring(0, 2);
		char[] array1 = top.toCharArray();
		char[] array2 = bottom.toCharArray();
		
		if (array1[0] == array2[1]) {
			int topInt = Integer.parseInt(top), bottomInt = Integer.parseInt(bottom);
			int testTopInt = Integer.parseInt(Character.toString(array1[1])), 
					testBottomInt = Integer.parseInt(Character.toString(array2[0]));
			double real = (double) topInt / bottomInt, incorrect = (double) testTopInt / testBottomInt;
			if (real == incorrect) 
				return true;
		}
		if (array1[1] == array2[0]) {
			int topInt = Integer.parseInt(top), bottomInt = Integer.parseInt(bottom);
			int testTopInt = Integer.parseInt(Character.toString(array1[0])), 
					testBottomInt = Integer.parseInt(Character.toString(array2[1]));
			double real = (double) topInt / bottomInt, incorrect = (double) testTopInt / testBottomInt;
			if (real == incorrect) 
				return true;
		}
		return false;
	}
	
	private static boolean seeIfLegit(String fraction) {
		String bottom = fraction.substring(2);
		String top = fraction.substring(0, 2);
		if ((top.length() == bottom.length()) && (top.length() == 2)) {
			char[] array1 = top.toCharArray();
			char[] array2 = bottom.toCharArray();
			
			if ((array1[0] == array2[1]) ^ (array1[1] == array2[0]))
				return false;
		}
		return true;
	}
	
	private static ArrayList<String> generateArrays() {
		
		ArrayList<String> array = new ArrayList<String>();
		for (int i = 11; i < 100; i++) {
			for (int j = 11; j < 100; j++) {
				String s = Integer.toString(i) + Integer.toString(j);
				array.add(s);
			}
		}
		return array;
	}
	
	public static void thisPleaseWork() {
		
		ArrayList<String> array = generateArrays();
		
		for (int i = 0; i < array.size(); i++) {
			if (checkIfWorks(array.get(i))) {
				System.out.println(array.get(i));
			}
		}
	}
	
	public static void main(String[] args) {
		
		IncorrectFractions.thisPleaseWork();
	}
}