import java.util.Arrays;

class Leftrotateanarray
{
	// Function to left-rotate an array by `r` positions
	public static void leftRotate(int[] arr, int r)
	{
		// get the length of the array
		int n = arr.length;

		// base case: invalid input
		if (r < 0 || r >= n) {
			return;
		}

		// construct an auxiliary array of size `r` and
		// fill it with the first `r` elements of the input array
		int[] aux = new int[r];
		for (int i = 0; i < r; i++) {
			aux[i] = arr[i];
		}

		// shift the remaining `n-r` elements of the input array at the beginning
		for (int i = r; i < n; i++) {
			arr[i - r] = arr[i];
		}

		// put the elements of the auxiliary array at their
		// correct positions in the input array
		for (int i = n-r; i < n; i++) {
			arr[i] = aux[i - (n - r)];
		}
	}

	public static void main(String[] args)
	{
		int[] arr = { 1, 2, 3, 4, 5 };
		int r = 2;

		leftRotate(arr, r);
		System.out.println(Arrays.toString(arr));
	}
}