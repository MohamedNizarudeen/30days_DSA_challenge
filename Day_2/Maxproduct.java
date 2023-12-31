class Maxproduct

{
	// A naive solution to finding the maximum product of two integers
	// in an array
	public static void findMaximumProduct(int[] A)
	{
		// base case
		if (A.length < 2) {
			return;
		}

		int max_product = Integer.MIN_VALUE;
		int max_i = -1, max_j = -1;

		// consider every pair of elements
		for (int i = 0; i < A.length - 1; i++)
		{
			for (int j = i + 1; j < A.length; j++)
			{
				// update the maximum product if required
				if (max_product < A[i] * A[j])
				{
					max_product = A[i] * A[j];
					max_i = i;
					max_j = j;
				}
			}
		}

		System.out.print("Pair is (" + A[max_i] + ", " + A[max_j] + ")");
	}

	public static void main (String[] args)
	{
		int[] A = { -10, -3, 5, 6, -2 };

		findMaximumProduct(A);
	}
}