package DS.Array.Z_tricky;

/**
 * BT, Amazon
 * 
 * For given N* N matrix, 

		1 2 3 
		8 9 4 
		7 6 5 
Write a program to 
print 1,2,3,4,5,6,7,8,9
 * @author sinhama
 *
 */

public class A_SpiralArrayPrint {
	
	public static void main(String[] args) {
		int n = 7;
		int a[][]={ {1 ,2 ,3 ,4 ,5 ,6 ,7},
				{24,25,26,27,28,29,8},
				{23,40,41,42,43,30,9},
				{22,39,48,49,44,31,10},
				{21,38,47,46,45,32,11},
				{20,37,36,35,34,33,12},
				{19,18,17,16,15,14,13}
			};
		
		print_num(a);
		
	}



	static void print_num(int myArray[][])
	{
		int i=0,j=0,count=0;
		int arrayLength = myArray.length;
		

		int n = myArray.length;
		while( count < arrayLength*arrayLength ) 
		{
			// direction -> RIGHT
			while( j <= arrayLength-1-i )
			{  
				System.out.println(" "+ myArray[i][j]);
				j++; count++;
			}
			j--; i++;

			// direction -> DOWN
			while( i <= j )
			{  
				System.out.println(""+ myArray[i][j]);
				i++; count++;
			}
			i--; j--;

			// direction -> LEFT
			while( j >= arrayLength-1-i )
			{  
				System.out.println(" "+ myArray[i][j]);
				j--; count++;
			}
			j++; i--;

			// direction -> UP
			while( i > j )
			{  
				System.out.println(" "+ myArray[i][j]);
				i--; count++;
			}
			i++; j++;

		} // end while
	} // 
}

