package DessignPattern.Other.Strategy;


/**
 * Strategy pattern defines a family of algorithm encapsulate each one and make them interchangeable.
 * it lets the algorithm vary independently from the client that use it.
 * helps in decoupling the algorithm from its host and encapsulating algorithm in separate class.
 * 
 * Non SW Ex : Transport to airport -> personal car, cab, city-bus, metro.
 * 
 * Cases where it can be used : 
 * 1. to use a process for which multiple alternative algorithm are possible, all with same interface. 
 * 2. To allow a client to specify which of the finite set of algorithm they intended to use.
 * 3. To isolate from a client the choice of the actual implementation algorithm used.
 * 4. To define a generic process so that it could be used by multiple applications.
 * 
 * 
 * Steps :
 *  Determine the behavior (Algorithm) that vary and separate them from the system that remain same.
 *  These behavior are encapsulated in classes(concrete strategy) that implement a common interface.
 *  This enables the developer to program to an interface and not to implementation.
 *  Each of these objects((Algorithm)) are referenced by classes(context) through the common interface(Strategy).
 *
 *
 *It is useful when :
 * You have multiple way of solving the same problem.
 * benefit :
 * you can easily add new strategies(functionality) without disrupting the existing functionality
 */
public class SendFileClass {
	public static void main(String [] args) {
		
		String fileName = "C/folder/Myfile.txt";
		System.out.println("/t Sending via Email ..." );
		EmailAttachmentSendFileStrategy email = new EmailAttachmentSendFileStrategy("mail.server.com", "you@somewhere.com");
		SendFileContext emailContext = new SendFileContext(email);
		emailContext.sendFile(fileName);
		
		System.out.println("/t Sending via ftp ..." );
		FtpSendFileStrategy ftp = new FtpSendFileStrategy("ftp.server.com", "/home/mydir");
		SendFileContext ftpContext = new SendFileContext(ftp);
		ftpContext.sendFile(fileName);
		System.out.println("/t Sending via ftp ..." );
		
	}

}

/**
 * @author Manish
 *
 */
class FtpSendFileStrategy implements SendFileStrategy {	

	private String server;
	private String directory;
	
	public FtpSendFileStrategy(String server, String directory){
		this.server = server;
		this.directory = directory;
	}
	
	public void sendFile(String fileName)
	{
		System.out.println("/t upload file : " + fileName);
		System.out.println("/t FTP server : " +server);
		System.out.println("/t upload to Folder : " +directory);
	}
	
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
}




class EmailAttachmentSendFileStrategy implements SendFileStrategy {	

	private String server;
	private String recipientEmailAddress;
	
	public EmailAttachmentSendFileStrategy(String server, String recipientEmailAddress){
		this.server = server;
		this.recipientEmailAddress = recipientEmailAddress;
	}
	
	public void sendFile(String fileName)
	{
		System.out.println("/t upload file via E-Mail: " + fileName);
		System.out.println("/t SMTP server Name : " +server);
		System.out.println("/t Username : " );
		System.out.println("/t Password : " );
		System.out.println("/t recipient Email Address : " +recipientEmailAddress);
	}
	
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}

	public String getRecipientEmailAddress() {
		return recipientEmailAddress;
	}

	public void setRecipientEmailAddress(String recipientEmailAddress) {
		this.recipientEmailAddress = recipientEmailAddress;
	}
	
}



class SendFileContext {
	
	private SendFileStrategy strategy;
	
	public SendFileContext () {
		
	}
	
	public SendFileContext(SendFileStrategy strategy) {		
		this.strategy = strategy;		
	}
	
	public void setSendFileStrategy(SendFileStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void sendFile (String fileName) {
		strategy.sendFile(fileName);
	}
}

/**
 * Say if you need to add another functionality say send Via Fax.
 * create the independent class FtpSendFileStrategy by implementing same interface SendFileStrategy(This is must). 
 * override sendFile method according to FAX behavior.  
 * Then use this class and method in main class as above via  SendFileContext class.
 * 
 * Note, SendFileContext implementation will remain same.
 * 
 * 
 * So other strategies can be added as required in the form of independent class (loose coupling)
 * and this class can be used independently in main class.
 */
