package CoreJava.J_Importent.cloning.basicclone;

public class CloneObj {
	public static void main (String args[]){
		int x[]={1,2,3,4,5};
		int y[]=x.clone();
		
		//CloneObj cloneObj = (CloneObj)new CloneObj().clone();
		
		BasicClone bc = new BasicClone();
		int hashbc = bc.hashCode();
		BasicClone bc1= (BasicClone)bc.clone();
		int hashbc1 = bc1.hashCode();	
		System.out.println("bc1 is equal to bc : " + bc.equals(bc1));
	//	System.out.println("bc1 is == to bc : " + bc==(BasicClone)bc1);
		
		BasicClone bc2 = new BasicClone();
		int hashbc2 = bc2.hashCode();
		System.out.println("hash code of original obj : "+hashbc);
		System.out.println("hash code of cloned obj : "+hashbc1);
		System.out.println("hash code of other original obj : "+hashbc2);
		
		
	}

}
