package CoreJava.J_Elementry.chars.charOpFrmKR;

public class CharsOprations {

	String str;
	public CharsOprations(String param) {
		str=param;
		// TODO Auto-generated method stub

	}

	String convLower()
	{
		char chars[]=str.toCharArray();// imp 1
		char conv[]=new char[chars.length] ;
		for (int i=0; i<chars.length;i++){			
			conv[i]=(char)toLower(chars[i]);
		}
		String convStr = new String(conv);//imp 2
		return convStr;
	}

	String convLower(String str){
		char chars[]=str.toCharArray();
		char conv[]=new char[chars.length] ;
		for (int i=0; i<chars.length;i++){			
			conv[i]=(char) toLower(chars[i]);
		}
		String convStr = new String(conv);
		return convStr;
	}

	String convUpper(){
		char chars[]=str.toCharArray();
		char conv[]=new char[chars.length] ;
		for (int i=0; i<chars.length;i++){			
			conv[i]=(char)toUpper(chars[i]);
		}
		String convStr = new String(conv);
		return convStr;
	}
	String convUpper(String str){
		char chars[]=str.toCharArray();
		char conv[]=new char[chars.length] ;
		for (int i=0; i<chars.length;i++){			
			conv[i]=(char) toUpper(chars[i]);
		}
		String convStr = new String(conv);
		return convStr;
	}

	String duplicateRemove(String str){
		char chars[]=str.toCharArray();
		char newchars[]=new char[chars.length];
		//char conv[]=new char[chars.length] ;
		int j=0;
		for (int i=0; i<chars.length;i++){
			char tmp = chars[i];
			int k=0;
			boolean flag=true;
			while(k<j){
				if(tmp==newchars[k]){
					flag =false;
					break;
				}

				k++;
			}
			if(flag){
				newchars[j]=tmp;
				j++;
			}
			//conv[i]=(char) toUpper(chars[i]);
		}
		char destchars[]=new char[j];
		System.arraycopy(newchars, 0, destchars, 0, j);// imp 3

		String convStr = new String(destchars);
		return convStr;
	}

	String rvrse(String str){
		char chars[]=str.toCharArray();
		for (int i=0, j=chars.length-1; i<j;i++,j--){
			char tmp = chars[i];
			chars[i]=chars[j];
			chars[j]=tmp;
		}
		String strng = new String(chars);  
		return strng;
	}

	int toUpper(char c){
		//int c=0;
		if( c>='a' && c<='z'){ //imp 4
			return c+'A'-'a'; // imp 5
		}else 
			return c;
	}

	int toLower(int c){
		//int c=0;
		if( c>='A' && c<='Z'){
			return c+'a'-'A';
		}else 
			return c;
	}

	int strToInt(String str){
		char chars[]=str.toCharArray();
		int n=0;
		for(int i=0;i<chars.length;i++){
			n= n*10+ chars[i]-'0';

		}
		return n;
	}

}
