class Circularlysortedarray
{
	// Returns index of the pivot element in a circularly sorted array
	public static int findPivot(int[] arr)
	{
		for (int i = 0; i < arr.length - 1; i++)
		{
			if (arr[i] > arr[i + 1]) {
				return i + 1;
			}
		}
		return arr.length;
	}

	// Function to find a pair with the given sum in a circularly sorted array
	public static void findPair(int[] arr, int target)
	{
		// base case
		if (arr.length <= 1) {
			return;
		}

		// find the pivot element
		int pivot = findPivot(arr);

		// maintain two pointers, `low` and `high`.

		// `high` points to an index of the maximum array element
		int high = pivot - 1;

		// `low` points to an index of the minimum array element
		int low = pivot % arr.length;

		/* Reduce search space at each iteration of the loop */

		// loop till `low` becomes equal to `high`
		while (low != high)
		{
			// pair with the desired sum is found
			if (arr[low] + arr[high] == target)
			{
				System.out.printf("Pair found (%d, %d)", arr[low], arr[high]);
				return;
			}

			// increment `low` index if the total is less than the desired sum
			if (arr[low] + arr[high] < target) {
				low = (low + 1) % arr.length;
			}

			// decrement `high` index if the total is more than the desired sum
			else {
				high = (high - 1 + arr.length) % arr.length;
			}
		}

		// Pair with the given sum doesn't exist in the array
		System.out.println("Pair not found");
	}

	public static void main(String[] args)
	{
		int[] arr = { 10, 12, 15, 3, 6, 8, 9 };
		int target = 18;

		findPair(arr, target);
	}
}