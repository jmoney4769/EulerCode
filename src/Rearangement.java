import java.util.ArrayList;
import java.util.Collections;


public class Rearangement {

	public static int sort(int number) {
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		char[] array1 = Integer.toString(number).toCharArray();
		for (int i = 0; i < array1.length; i++)
			array.add(Integer.parseInt(Character.toString(array1[i])));
		Collections.sort(array);
		System.out.println(array.get(0));
		int result;
		String s = "";
		for (int i = 0; i < array.size(); i++) {
			s += array.get(i);
		}
		result = Integer.parseInt(s);
		return result;
	}
	
	public static boolean check(int number) {
		
		int num1 = number * 2, num2 = 3 * number, num3 = number * 4,
				num4 = 5 * number, num5 = 6 * number;
		number = sort(number);
		
		if ((number == sort(num1)) && (number == sort(num2)) && (number == sort(num3)) && 
				(number == sort(num4)) && (number == sort(num5)))
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		Rearangement.sort(123);
		
		int i = 1;
		while (true) {
			System.out.println(i);
			if (Rearangement.check(i)) {
				System.out.println(i);
				break;
			}
			i++;
		}
	}
}
