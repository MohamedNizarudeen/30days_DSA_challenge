class Distinctelementscount
{
	// Function to find the count of distinct elements in every subarray
	// of size `k` in the array
	public static void findDistinctCount(int[] arr, int k)
	{
		// consider every subarray of size `k`
		for (int x = 0; x <= arr.length - k; x++)
		{
			// maintains a counter for distinct elements in the current subarray
			int distinct = 0;

			// current subarray is formed by subarray `arr[x, x+k)`
			for (int i = x; i < x + k; i++)
			{
				// increase distinct count for `arr[i]` in current subarray
				distinct++;

				// check if `arr[i]` is present in subarray `arr[x, i-1]` or not
				for (int j = x; j < i; j++)
				{
					// if duplicate element found in the current subarray
					if (arr[i] == arr[j])
					{
						// unmark element `arr[i]` as distinct – decrease count
						distinct--;
						break;
					}
				}
			}

			System.out.printf("The count of distinct elements in subarray [%d, %d]"
								+ " is %d\n", x, x + k - 1, distinct);
		}
	}

	public static void main(String[] args)
	{
		int[] arr = { 2, 1, 2, 3, 2, 1, 4, 5 };
		int k = 5;

		findDistinctCount(arr, k);
	}
}