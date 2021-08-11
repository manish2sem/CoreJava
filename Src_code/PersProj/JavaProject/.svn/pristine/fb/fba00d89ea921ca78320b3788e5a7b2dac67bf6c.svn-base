package Algorithm.Searching;

/**
 * the input array has to be sorted in increasing order.
 * 
 * Choose a range of elements say, [A .. Z]
Find the middle of the range, say M
Look at the element at index M. Is X equal to the element at M – (Probing Step)
Yes – return M
No – Is the element at M greater than the K
Yes – shrink the range to left [L .. M-1]
No – shrink the range to right [M+1 .. R]
Repeat this until the range shrinks to just one ele
 * @author Manish
 *
 */

public class BinarySearch {
	public static void main(String[] args) {
		
		System.out.println(binarySearch(new int[]{1, 4 ,5 ,8, 9, 23}, 8));
		
	}
	
	public static int binarySearch(int[] A, int N) {
		int start = 0, end = A.length-1, mid ;
	        mid = start + (end - start) / 2;
		while (start <= end) {
			if (A[mid] == N)
				return mid;
			else if (A[mid] > N)
				end = mid - 1;
			else
				start = mid + 1;
			mid = start + (end-start)/2;
		}
		return -1;
	}

}
