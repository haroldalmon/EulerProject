package JUnitTests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import G01.P004_PalindromeProduct;

@RunWith(Parameterized.class)
public class P004_PalindromeProductTest {
	private int input;
	private int expectedResult;
	private static P004_PalindromeProduct palindromeProduct = new P004_PalindromeProduct();

	@Parameters
	public static List<Object []> data() {
		return Arrays.asList( new Object [][] {
			{3, 906609},
			{4, 99000099}
		} );
	}

	public P004_PalindromeProductTest(int input, int expectedResult) {
		this.input = input;
		this.expectedResult = expectedResult;
	}
	
	@Test (timeout = 10_000)
	public void MultiplesOf3And5() throws Exception {
		int result;

		result = palindromeProduct.largestPalindromeProduct(input);
		System.out.printf("Result = %d%n", result);
		assertEquals( expectedResult, result);
	}
}