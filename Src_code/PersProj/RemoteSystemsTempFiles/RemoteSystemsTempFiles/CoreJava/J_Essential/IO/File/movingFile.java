package CoreJava.J_Essential.IO.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class movingFile {
	public static void main(String args[]){
	try{
		File srcDir = new File("src");
		File destDir = new File("lib");
		if(destDir.exists()){
			System.out.println("Exists");
			System.out.println(destDir.getAbsolutePath());
			System.out.println(destDir.getPath());
			if(srcDir.exists()){
				System.out.println(" src dir Exists");
				//String [] files = srcDir.list();
				copyDirectory(srcDir,destDir);
							
			}
			
		}else{
			System.out.println("Does not exists");
			destDir.mkdir();
			System.out.println(destDir.getAbsolutePath());
			System.out.println(destDir.getPath());
			
		}
		
		
	
		
	}catch(Exception ex){
		ex.printStackTrace();
		}
	}
	
	
	public static void copyDirectory(File sourceDir, File destDir)
    throws IOException{
		if(!destDir.exists()){
			destDir.mkdir();
		}

		File[] children = sourceDir.listFiles();

		for(File sourceChild : children){
			String name = sourceChild.getName();
			File destChild = new File(destDir, name);
			if(sourceChild.isDirectory()){
				copyDirectory(sourceChild, destChild);
			}else{
				copyFile(sourceChild, destChild);
			}
		}
	}

	
	
	 public static void copyFile(File source, File dest) throws IOException{
		 
		   if(!dest.exists()){		  
			   dest.createNewFile();		  
		    }
		   
		   System.out.println(dest.getPath());
		   System.out.println(dest.getAbsolutePath());
		   
		   InputStream in = null;		  
		   OutputStream out = null;		  
		    try{		 
		    	in = new FileInputStream(source);
		        out = new FileOutputStream(dest);
		  
		        byte[] buf = new byte[1024];
		        int len;
		  
		        while((len = in.read(buf)) > 0){		  
		        	out.write(buf, 0, len);
		        }		   
		     }finally{		 
		    	 in.close();		 
		         out.close();
		     }
		  
		  }	

}
