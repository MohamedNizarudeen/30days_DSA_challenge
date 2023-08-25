import java.util.ArrayList;
import java.util.List;

class Pascaltriangle
{
	public static List<List<Integer>> getPascalTriangleElements(int n) {
		List<List<Integer>> rows = new ArrayList<>();

		// base case
		if (n <= 0) {
			return rows;
		}

		// base case: first row contains only a single element 1
		rows.add(List.of(1));

		// do for each row starting the second row
		for (int i = 1; i < n; i++)
		{
			List<Integer> row = new ArrayList<>();
			for (int j = 0; j <= i; j++)
			{
				// first and last element of any row will be always 1
				if (j == 0 || j == i) {
					row.add(1);
				}
				else {
					// for all other elements, sum adjacent elements in the preceding row
					List<Integer> prev = rows.get(i - 1);
					row.add(prev.get(j - 1) + prev.get(j));
				}
			}

			// add current row to the result
			rows.add(row);
		}

		return rows;
	}

	public static void main(String[] args)
	{
		int n = 5;

		List<List<Integer>> result = getPascalTriangleElements(n);
		System.out.println(result);
	}
}