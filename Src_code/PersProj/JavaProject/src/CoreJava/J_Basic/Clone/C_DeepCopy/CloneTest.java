package CoreJava.J_Basic.Clone.C_DeepCopy;

/** 
 * http://javarevisited.blogspot.in/2015/01/java-clone-tutorial-part-2-overriding-with-mutable-field-example.html
 * override clone method for deep copying.
 *  
 *  This example includes a mutable filed in class to be cloned to show 
 *  how you deal with practical classes which contains both immutable and mutable fields. 
 */

public class CloneTest { 
	//private static final Logger logger = LoggerFactory.getLogger(Cloneclass);

	public static void main(String args[]) { 

		Programmer javaguru = new Programmer("John", 31);

		javaguru.addCertificates("OCPJP");
		javaguru.addCertificates("OCMJD");
		javaguru.addCertificates("PMP");
		javaguru.addCertificates("CISM");
		System.out.println("Real Java Guru : {}"+ javaguru);
		Programmer clone = javaguru.clone();
		System.out.println("Clone of Java Guru : {}"+ clone);
		//let's add another certification to java guru 
		javaguru.addCertificates("Oracle DBA");
		System.out.println("Real Java Guru : {}"+ javaguru);
		System.out.println("Clone of Java Guru : {}"+ clone);
	}
}

