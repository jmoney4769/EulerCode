import java.math.BigInteger;
import java.util.ArrayList;


public class AAndBPower {

	public static void main(String[] args) {
		
		ArrayList<BigInteger> array = new ArrayList<BigInteger>();
		int counter = 0;
		
		for (int a = 2; a <= 100; a++) {
			for (int b = 2; b <= 100; b++) {
				BigInteger var = new BigInteger(Integer.toString(a)).pow(b);
				BigInteger var2 = new BigInteger(Integer.toString(b)).pow(a);
				
				boolean  c = true, d = true;
				for (int i = 0; i < array.size(); i++) {
					if (var.equals(array.get(i)))
						c = false;
					if (var2.equals(array.get(i)))
						d = false;
				}
				if (c) 
					array.add(var);
				if (!var.equals(var2))
					if (d)
						array.add(var2);
			}
		}

		System.out.println(array.size());
	}
}
