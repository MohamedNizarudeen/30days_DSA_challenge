import java.util.HashMap;
import java.util.Map;

class Lengthofsequence
{
	// Given two binary arrays, `X` and `Y`, find the length of the longest
	// continuous sequence that starts and ends at the same index in both
	// arrays and have the same sum
	public static int findMaxSubarrayLength(int[] X, int[] Y)
	{
		// create an empty map
		Map<Integer, Integer> map = new HashMap<>();

		// to handle the case when the required sequence starts from index 0
		map.put(0, -1);

		// stores length of the longest continuous sequence
		int result = 0;

		// `sum_x` and `sum_y` stores the sum of elements of `X[]` and `Y[]`,
		// respectively, till the current index
		int sum_x = 0, sum_y = 0;

		// traverse both lists simultaneously
		for (int i = 0; i < X.length; i++)
		{
			// update `sum_x` and `sum_y`
			sum_x += X[i];
			sum_y += Y[i];

			// calculate the difference between the sum of elements in two lists
			int diff = sum_x - sum_y;

			// if the difference is seen for the first time, store the
			// difference and current index in a map
			if (!map.containsKey(diff)) {
				map.put(diff, i);
			}

			// if the difference is seen before, then update the result
			else {
				result = Integer.max(result, i - map.get(diff));
			}
		}

		return result;
	}

	public static void main(String[] args)
	{
		int[] X = { 0, 0, 1, 1, 1, 1 };
		int[] Y = { 0, 1, 1, 0, 1, 0 };

		System.out.println("The length of the longest continuous sequence " +
						"with the same sum is " + findMaxSubarrayLength(X, Y));
	}
}