import java.util.Arrays;

class Printcontinuoussubarray
{
	// Function to print contiguous subarray with the largest sum
	// in a given set of integers
	public static int[] kadane(int[] arr)
	{
		// base case
		if (arr == null || arr.length <= 1) {
			return arr;
		}

		// stores the maximum sum subarray found so far
		int maxSoFar = Integer.MIN_VALUE;

		// stores the maximum sum of subarray ending at the current position
		int maxEndingHere = 0;

		// stores endpoints of maximum sum subarray found so far
		int start = 0, end = 0;

		// stores starting index of a positive-sum sequence
		int beg = 0;

		// traverse the given array
		for (int i = 0; i < arr.length; i++)
		{
			// update the maximum sum of subarray "ending" at index 'i'
			maxEndingHere = maxEndingHere + arr[i];

			// if the maximum sum becomes less than the current element,
			// start from the current element
			if (maxEndingHere < arr[i])
			{
				maxEndingHere = arr[i];
				beg = i;
			}

			// update result if the current subarray sum is found to be greater
			if (maxSoFar < maxEndingHere)
			{
				maxSoFar = maxEndingHere;
				start = beg;
				end = i;
			}
		}

		return Arrays.copyOfRange(arr, start, end + 1);
	}

	public static void main(String[] args)
	{
		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		int slice[] = kadane(arr);
		System.out.println("The contiguous subarray with the largest sum is " +
				Arrays.toString(slice));
	}
}