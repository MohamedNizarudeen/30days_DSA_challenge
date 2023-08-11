class Smallestsubarray
{
	// Function to find the length of the smallest subarray whose sum
	// of elements is greater than the given number
	public static int findSmallestSubarrayLen(int[] A, int k)
	{
		// stores the current window sum
		int windowSum = 0;

		// stores the result
		int len = Integer.MAX_VALUE;

		// stores the window's starting index
		int left = 0;

		// maintain a sliding window `[left…right]`
		for (int right = 0; right < A.length; right++)
		{
			// include the current element in the window
			windowSum += A[right];

			// the window becomes unstable if its sum becomes more than `k`
			while (windowSum > k && left <= right)
			{
				// update the result if the current window's length is less than the
				// minimum found so far
				len = Integer.min(len, right - left + 1);

				// remove elements from the window's left side till the window
				// becomes stable again
				windowSum -= A[left];
				left++;
			}
		}

		// invalid input
		if (len == Integer.MAX_VALUE) {
			return 0;
		}

		// return result
		return len;
	}

	public static void main(String[] args)
	{
		// an array of positive numbers
		int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
		int k = 21;

		// find the length of the smallest subarray
		int len = findSmallestSubarrayLen(A, k);

		if (len != Integer.MAX_VALUE) {
			System.out.print("The smallest subarray length is " + len);
		}
		else {
			System.out.print("No subarray exists");
		}
	}
}