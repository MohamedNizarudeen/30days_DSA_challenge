class Bitsneeded
{
	// Find the total number of bits needed to be flipped to convert `x` to `y`
	public static int findBits(int x, int y)
	{
		// take XOR of `x` and `y` and store in `n`
		int n = x ^ y;

		// Using Brian Kernighan’s algorithm to count set bits

		// `count` stores the total bits set in `n`
		int count = 0;

		while (n != 0)
		{
			n = n & (n - 1);	// clear the least significant bit set
			count++;
		}

		return count;
	}

	public static void main(String[] args)
	{
		int x = 65;
		int y = 80;

		System.out.println(x + " in binary is " + Integer.toBinaryString(x));
		System.out.println(y + " in binary is " + Integer.toBinaryString(y));

		System.out.println("\nThe total number of bits to be flipped is " + findBits(x, y));
	}
}