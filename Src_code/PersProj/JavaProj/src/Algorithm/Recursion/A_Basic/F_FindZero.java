package Algorithm.Recursion.A_Basic;

public class F_FindZero {

	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3, 0, 5, 6, 0};

		System.out.println( "Using recursion, we get: " );
		int cnt = findNo(array, 0, 3, 0);

		System.out.println( "count is: "+cnt );
	}

	public static int findNo( int store[], int index, int tofind, int count){

		if(index>=store.length) return count;

		if(store[index] == tofind){
				count++;	
		}
		System.out.println("index = " +index);
		return findNo( store, index+1, tofind, count);
	}

}


