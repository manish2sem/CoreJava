package DS.String.Basic.C_SubString;

/**
 * Given string and substring;  find the no. of occurrence of substring into string.
 * @author sinhama
 * 
 * Algo naive method -> 
 *
 */

public class A_FindSubString {

	public static void main(String[] args) {
		System.out.println("No. of occurrences -> " +findSubStr("aababacdababaceabc", "aba"));
	}

	static int findSubStr(String source, String expr){
		int count = 0;
		char[] sourceArray = source.toCharArray();
		char[] exprArray = expr.toCharArray();

		for (int i=0; i< source.length(); i++){

			int j = 0;
			int k = i;
			while(true){
				if (sourceArray[k] == exprArray[j]) {

					k++;
					j++;

					if(j == exprArray.length){
						count++;
						//			i = i+k;
						break;
					}

				}else{
					break;
				}
			}
		}

		return count;

	}

}
// order in n^2