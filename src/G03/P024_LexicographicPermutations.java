package G03;
import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class P024_LexicographicPermutations {
	int[] digits;

	public String lexicographicPermutations(int noOfDigits, int targetPermNo) {
		digits = new int[noOfDigits];
		createDigitsInArray(noOfDigits, digits);

		String permutation = digitsToPermutation(digits);
		System.out.printf("Permutation = %s%n", permutation);
		
		final int startOnRight = noOfDigits - 2;
		int digitIndex = 0;
		digitIndex = startOnRight;
		int permCounter = 1;
		int FIRST_ARRAY_POSITION = 0;
		while (digitIndex >= FIRST_ARRAY_POSITION) {
			int ceilingPosition;
			ceilingPosition = digitCeilingPosition(digits, digitIndex);
			if (ceilingPosition != Integer.MAX_VALUE) {
				swapDigits(digits, digitIndex, ceilingPosition);
				sortDigitsOnRight(digits, digitIndex + 1);

				digitIndex = startOnRight;
				permCounter += 1;
				
				permutation = digitsToPermutation(digits);
				System.out.printf("Permutation = %s%n", permutation);
				
				if (permCounter == targetPermNo) {
					permutation = digitsToPermutation(digits);
					System.out.printf("Permutation = %s%n", permutation);
					break;
				}
			} else
				digitIndex -= 1;
		}

		return permutation;
	}

	private void swapDigits(int[] digits, int digitIndex, int posOfSmallestDigit) {
		int temp;
		temp = digits[posOfSmallestDigit];
		digits[posOfSmallestDigit] = digits[digitIndex];
		digits[digitIndex] = temp;
	}

	private void createDigitsInArray(int noOfDigits, int[] digits) {
		for (int i = 0; i < noOfDigits; i++) {
			digits[i] = i;
		}
	}

	private String digitsToPermutation(int[] digits) {
		String permutation;
		permutation = Arrays.toString(digits);
		permutation = permutation.replaceAll(", ", "");
		permutation = permutation.substring(1, permutation.length() - 1);
		return permutation;
	}
	
	private void sortDigitsOnRight(int[] digits, int i) {
		int arrayLength = digits.length - i;
		int[] subArray = new int[arrayLength];
		System.arraycopy(digits, i, subArray, 0, arrayLength);
		Arrays.sort(subArray);
		System.arraycopy(subArray, 0, digits, i, arrayLength);
	}

	private int digitCeilingPosition(int[] digits, int startPosition) {
		int min = Integer.MAX_VALUE;
		int leftChar = digits[startPosition];
		int position;
		int result = min;

		for (position = startPosition + 1; position < digits.length; position++) {
			if(leftChar < digits[position] && digits[position] < min) {
				min = digits[position];
				result = position;
			}
		}

		return result;
	}
	
	@Test
	public void Permutation() {
		String permutation;
		permutation = lexicographicPermutations(3, 1_000_000); 
		assertEquals("Permutation is not correct", "2783915460", permutation);
	}
}
