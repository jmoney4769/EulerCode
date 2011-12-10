import java.math.BigInteger;


public class SumOfAToB {

	public static void main(String[] args) {
		
		int highest = 0;
		
		for (int a = 1; a <= 100; a++) {
			for (int b = 1; b <= 100; b++) {
				BigInteger var = new BigInteger(Integer.toString(a)).pow(b);
				
				char[] array = var.toString().toCharArray();
				
				int sum = 0;
				for (int i = 0; i < array.length; i++) {
					sum += Integer.parseInt(Character.toString(array[i]));
				}
				if (sum > highest) {
					System.out.println(var + " " + a + " " + b);
					highest = sum;
				}
			}
		}
		System.out.println(highest);
	}
}
