package unitTests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import G01.P001_MultiplesOf3And5;

@RunWith(Parameterized.class)
public class P001_ParamTests {
	private int input;
	private int expectedResult;
	private static P001_MultiplesOf3And5 multiplesOf3And5 = new P001_MultiplesOf3And5();

	@Parameters
	public static List<Object []> data() {
		return Arrays.asList( new Object [][] {
			{100, 2_318},
			{1_000, 233_168}, 
			{10_000, 23_331_668}
		} );
	}

	public P001_ParamTests(int input, int expectedResult) {
		this.input = input;
		this.expectedResult = expectedResult;
	}
	
	@Test
	public void MultiplesOf3And5() {
		int result;

		result = multiplesOf3And5.multiplesOf3And5(input);
		System.out.printf("Result = %d%n", result);
		assertEquals( expectedResult, result);
	}
}