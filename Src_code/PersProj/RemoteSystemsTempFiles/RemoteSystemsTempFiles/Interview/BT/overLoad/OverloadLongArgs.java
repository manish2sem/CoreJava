package Interview.BT.overLoad;

public class OverloadLongArgs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OverloadLongArgs obj = new OverloadLongArgs();
		int c = 1;
		obj.longArgs(c,c);
	}

	public void longArgs(Long a, Long b){
		System.out.println("Long Called");
	}
	
	public void longArgs(int ...args){
		System.out.println("Args Called");
	}
}
