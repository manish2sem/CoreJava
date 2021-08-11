package DS.String.Basic.B_Duplicate;

/**
 * Remove a duplicate without using additional buffer.
 * 
 * This is exactly same as using buffer.
 * Compare with A_RemoveDuplicate.
 * @author sinhama
 *
 */

public class B_RemoveDupWithoutBuffer {
	
	public static void main(String[] args) {

		String originalStr = "My name is Manish";
		
		System.out.println("new String is : " +removeDuplicate(originalStr));
	}

	static String removeDuplicate(String orgStr){
		
		if(orgStr == null || orgStr.equals("")){
			return "";
		}

		int length =  orgStr.length();
		int location = 0;
		boolean found = false;
		char[] orgArray = orgStr.toCharArray();

		for(int i=0; i<length; i++){

			found = false;
			for(int j=0; j<location; j++){				
				if(orgArray[i] == orgArray[j]){
					found = true;
					break;
				}
			}
			
			if (!found) {
				orgArray[location] = orgArray[i];
				location++;
			}
		}

		return new String(orgArray, 0, location);
	}


}
