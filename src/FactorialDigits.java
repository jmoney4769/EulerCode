import java.math.BigInteger;
import java.util.ArrayList;


public class FactorialDigits {

	private static BigInteger[] split(BigInteger fullNumber) {
		
		char[] array = fullNumber.toString().toCharArray();
		BigInteger[] result = new BigInteger[array.length];
		
		for (int i = 0; i < array.length; i++) {
			result[i] = new BigInteger(Character.toString((char) (array[i])));
		}
		return result;
	}
	
	public static boolean checkIfFactEqualsNumber(BigInteger number) {
		
		BigInteger[] array = split(number);		
		BigInteger sum = BigInteger.ZERO;
		
		for (int i = 0; i < array.length; i++) {
			sum = sum.add(Combinatorics.factorial(array[i]));
		}
		
		if (sum.equals(number))
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		
		int sum = 0;
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for (int i = 10; i < 1000000; i++) {
			if (FactorialDigits.checkIfFactEqualsNumber(new BigInteger(Integer.toString(i)))); 
				array.add(i);
		}
		for (int i = 0; i < array.size(); i++) {
			sum += array.get(i);
			System.out.println(array.get(i));
		}
		System.out.println(sum);
		
	}
}
