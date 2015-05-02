package G02;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class P012_TriangularNumber {
	long triangularNumber(int divisorLimit) {
		final boolean FALSE = false;
		int naturalNumber = 2;
		int triangleNumber = 3;
		int numberOfDivisors = 0;
		while (true) {
			numberOfDivisors = divisorCount(triangleNumber);
			if (numberOfDivisors > divisorLimit) 
				break;
			naturalNumber = nextNaturalNumber(naturalNumber);
			triangleNumber = nextTriangleNumber(triangleNumber, naturalNumber);
		};
		if(FALSE)
			System.out.printf("no. of divisors = %d, Triangle seq no. = %d%n", numberOfDivisors , naturalNumber);
		return triangleNumber;
	}
	
	private int nextNaturalNumber(int naturalNumber) {
		return naturalNumber + 1;
	}
	
	private int nextTriangleNumber(int triangleNumber, int naturalNumber) {
		return triangleNumber + naturalNumber;
	}
	
	int divisorCount(int triangleNumber) {
		int divisorTotal = 0;
		int maxDivisor = (int) (triangleNumber/2);
		for (int n = 2; n <= maxDivisor; n++) {
			if (isDivisorOfTriangleNumber(triangleNumber, n)) 
			{
				divisorTotal += 2;
				maxDivisor = newDivisorLimit(triangleNumber, n);
			}
		}
		return divisorTotal + 2;
	}
	
	private int newDivisorLimit(int n, int i) {
		return (n / i) - 1;
	}
	
	private boolean isDivisorOfTriangleNumber(long n, int i) {
		return n % i == 0;
	}

	@Test(timeout = 3_000)
	public void TriangularNumber() {
		long result = triangularNumber(500);
		System.out.printf("triangularNumber(500) = %d%n", result);
		assertEquals( "Incorrect sum", 76576500, result );
	}
}
