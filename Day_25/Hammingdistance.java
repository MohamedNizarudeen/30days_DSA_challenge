class Hammingdistance {
	public static int findHammingDistance(int x, int y) {
		int count = 0;
		int n = x ^ y;

		for (int i = 0; i < 32; i++) {
			if ((n & 1) != 0) {
				count++;
			}
			n >>= 1;
		}

		return count;
	}

	public static void main(String[] args) {
		int x = 2, y = 5;
		System.out.println(findHammingDistance(x, y));
	}
}