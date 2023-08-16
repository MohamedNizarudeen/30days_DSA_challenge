import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Partitionanarray
{
	// Utility function to print the array between specified indices
	public static void printArray(int[] A, int i, int j)
	{
		System.out.println(IntStream.rangeClosed(i, j)
				.mapToObj(k -> A[k])
				.collect(Collectors.toList()));
	}

	// Partition the array into two subarrays with the same sum
	public static int partition(int[] A)
	{
		// do for each array element
		for (int i = 0; i < A.length; i++)
		{
			int left_sum = 0;
			for (int j = 0; j < i; j++) {
				left_sum += A[j];
			}

			int right_sum = 0;
			for (int j = i; j < A.length; j++) {
				right_sum += A[j];
			}

			// if sum of `A[0…i-1]` is equal to `A[i, n-1]`
			if (left_sum == right_sum) {
				return i;
			}
		}

		// invalid input
		return -1;
	}

	public static void main(String[] args)
	{
		int[] A = { 6, -4, -3, 2, 3 };

		// get index `i` that points to the starting of the second subarray
		int i = partition(A);

		if (i != -1)
		{
			// print the first subarray, `A[0, i-1]`
			printArray(A, 0, i - 1);

			// print the second subarray, `A[i, n-1]`
			printArray(A, i, A.length - 1);
		}
		else {
			System.out.print("The array can't be partitioned");
		}
	}
}