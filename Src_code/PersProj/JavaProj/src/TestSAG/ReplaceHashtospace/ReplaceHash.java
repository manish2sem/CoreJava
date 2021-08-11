package TestSAG.ReplaceHashtospace;

public class ReplaceHash {

	public static void main(String[] args) {
		String props = "C:\\softwareag\\jvm\\jvm\\bin\\javac#-classpath\\#\\{0}#-d#\\{1}";
		String newStr = replaceHash(props);
		
		System.out.println("Old String : " +props);
		System.out.println("New String : " +newStr);
	}
	
	private static String replaceHash(String extendedProperty) {
		
		char[] chArr = extendedProperty.intern().toCharArray();
		StringBuffer sb = new StringBuffer(extendedProperty.substring(0, 1));
		
		for (int i=1; i < chArr.length; i++) {
			
			if(chArr[i] == '#') {
				if (chArr[i-1] == '\\') {
					sb.replace(sb.length()-1, sb.length(), "#");
				} else {
					sb.append(" ");
				}
				
			} else {
				sb.append(chArr[i]);
			} 			
		}
		
		return sb.toString();
	}

}
