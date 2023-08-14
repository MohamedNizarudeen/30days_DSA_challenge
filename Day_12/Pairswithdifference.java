import java.util.HashSet;
import java.util.Set;

class Pairswithdifference
{
	// Function to find a pair with the given difference in the array.
	// This method does not handle duplicates in the array
	public static void findPair(int[] A, int diff)
	{
		// array is unsorted

		// take an empty set
		Set<Integer> set = new HashSet<>();

		// do for every array element
		for (int i: A)
		{
			// check if pair with the given difference `(i, i-diff)` exists
			if (set.contains(i - diff)) {
				System.out.println("(" + i + ", " + (i - diff) + ")");
			}

			// check if pair with the given difference `(i + diff, i)` exists
			if (set.contains(i + diff)) {
				System.out.println("(" + (i + diff) + ", " + i + ")");
			}

			// insert the current element into the set
			set.add(i);
		}
	}

	public static void main(String[] args)
	{
		int[] A = { 1, 5, 2, 2, 2, 5, 5, 4};
		int diff = 3;

		findPair(A, diff);
	}
}