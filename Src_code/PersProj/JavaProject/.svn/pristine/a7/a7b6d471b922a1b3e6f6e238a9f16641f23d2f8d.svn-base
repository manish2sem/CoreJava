package DessignPattern.HeadFirst.Decorator.JvaBuiltinSupport.IOdecorator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.InputStream;


public class LowerCaseStreamTest {
	public static void main(String[] args) throws IOException {
		
		File javaFile = new File("src/DesignPattern/HeadFirst/Decorator/JvaBuiltinSupport/IOdecorator/LowerCaseStreamTest.java");		
		
		if(javaFile.exists()) {
			System.out.println("File does  exist");
			FileInputStream fis = new FileInputStream(javaFile);
			BufferedInputStream filterIS = new BufferedInputStream(fis);
			InputStream lcs = new LowerCaseStream(filterIS);
			int c;
			while((c = lcs.read()) >= 0) {
				System.out.print((char)c);
			}
			
			lcs.close();
			
		}else {
			System.out.println("File does not exist");
		}
	}

}
