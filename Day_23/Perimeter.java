class Perimeter
{
	public static int findPerimeter(int[][] island)
	{
		// base case
		if (island.length == 0) {
			return 0;
		}

		int M = island.length;
		int N = island[0].length;

		int count = 0;

		// traverse each cell of the matrix
		for (int i = 0; i < M; i++)
		{
			for (int j = 0; j < N; j++)
			{
				// if the current cell is a land
				if (island[i][j] == 1)
				{
					// check if top edge is adjacent to the water
					if ((i == 0 || island[i - 1][j] == 0)) {
						count++;
					}

					// check if bottom edge is adjacent to the water
					if (i == M - 1 || island[i + 1][j] == 0) {
						count++;
					}

					// check if left edge is adjacent to the water
					if (j == 0 || island[i][j - 1] == 0) {
						count++;
					}

					// check if right edge is adjacent to the water
					if (j == N - 1 || island[i][j + 1] == 0) {
						count++;
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args)
	{
		int[][] island = =
		{
			{ 0, 1, 1, 1 },
			{ 1, 1, 0, 0 },
			{ 1, 1, 1, 0 },
			{ 0, 1, 0, 0 },
			{ 0, 1, 1, 1 }
		};

		System.out.println(findPerimeter(island));
	}
}