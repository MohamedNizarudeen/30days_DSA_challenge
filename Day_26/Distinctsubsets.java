import java.util.*;

class Distinctsubsets
{
	// Iterative function to print all distinct subsets of `S`
	public static void findPowerSet(int[] S)
	{
		// `N` stores the total number of subsets
		int N = (int)Math.pow(2, S.length);
		Set<List<Integer>> set = new HashSet<>();

		// sort the set
		Arrays.sort(S);

		// generate each subset one by one
		for (int i = 0; i < N; i++)
		{
			List<Integer> subset = new ArrayList<>();

			// check every bit of `i`
			for (int j = 0; j < S.length; j++)
			{
				// if j'th bit of `i` is set, append `S[j]` to the subset
				if ((i & (1 << j)) != 0) {
					subset.add(S[j]);
				}
			}

			// insert the subset into the set
			set.add(subset);
		}

		// print all subsets present in the set
		System.out.println(set);
	}

	public static void main(String[] args)
	{
		int[] S = { 1, 2, 1 };

		findPowerSet(S);
	}
}