import java.math.BigInteger;


public class SigmaNToTheN {

	public static void main(String args[]) {
		
		BigInteger result = BigInteger.ZERO;
		for (int i = 1; i <= 1000; i++) {
			result = result.add((new BigInteger(Integer.toString(i))).pow(i));
		}
		System.out.println(result);
	}
}
