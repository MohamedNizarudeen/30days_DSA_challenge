import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair
{
	public int x, y;

	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

class Nonoverlapping
{
	// Function to find two non-overlapping pairs with the same sum in an array
	public static void findPairs(int[] nums)
	{
		// create an empty map
		// key —> sum of a pair of elements in the array
		// value —> list storing an index of every pair having that sum
		Map<Integer, List<Pair>> map = new HashMap<>();

		// consider every pair (nums[i], nums[j]), where `j > i`
		for (int i = 0; i < nums.length - 1; i++)
		{
			for (int j = i + 1; j < nums.length; j++)
			{
				// calculate the sum of the current pair
				int sum = nums[i] + nums[j];

				// if the sum is already present on the map
				if (map.containsKey(sum))
				{
					// check every pair for the desired sum
					for (Pair pair: map.get(sum))
					{
						int m = pair.x;
						int n = pair.y;

						// if pairs don't overlap, print and return them
						if ((m != i && m != j) && (n != i && n != j))
						{
							System.out.printf("First Pair (%d, %d)\n", nums[i], nums[j]);
							System.out.printf("Second Pair (%d, %d)\n", nums[m], nums[n]);

							return;
						}
					}
				}

				// insert the current pair into the map
				map.putIfAbsent(sum, new ArrayList<>());
				map.get(sum).add(new Pair(i, j));
			}
		}

		System.out.println("No non-overlapping pairs present");
	}

	public static void main(String[] args)
	{
		int[] nums = { 3, 4, 7, 3, 4 };

		findPairs(nums);
	}
}