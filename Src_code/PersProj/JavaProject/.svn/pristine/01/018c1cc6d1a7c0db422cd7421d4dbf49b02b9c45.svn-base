package DS.String.Basic.B_Duplicate;

/**
 * Using extra buffer.
 * @author sinhama
 *
 */

public class A_RemoveDuplicate {

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
		char[] newArray = new char[length];

		for(int i=0; i<length; i++){

			found = false;
			for(int j=0; j<location; j++){				
				if(orgArray[i] == newArray[j]){
					found = true;
					break;
				}
			}
			
			if (!found) {
				newArray[location] = orgArray[i];
				location++;
			}
		}

		return new String(newArray, 0, location);	//Note Constructor of String.
	}

}
