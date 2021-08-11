package IntgrationServerTests.SymbLinkDeletion;

import java.io.File;
import java.io.IOException;

//import java.nio.file.F;

public class DeleteSymb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//	String dir = "C:\\testSpace\\SymbLink\\SoftLink";

		String dir = "C:\\testSpace\\SymbLink\\TargetFolder";

		File fileToDelete = new File(dir);

		/*java.nio.file.Path path = java.nio.file.Paths.get(fileToDelete.toURI()); 
		if(java.nio.file.Files.isSymbolicLink(path)){ 
			try {
				java.nio.file.Files.delete(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} else {

			deleteDirectory(new File(dir));
		}*/


		deleteDirectory(new File(dir));
		System.out.println("End of DeleteSymb");		


	}

	/**
	 * Delete the specified directory.  This means emptying it first.
	 *
	 * @param dir      File object representing current(sub)directory in recursion
	 *
	 * This method is RECURSIVE so watch out.
	 */
	public static void deleteDirectory(File dir) {
		String[] files;

		if (dir.isFile()) {
			dir.delete();
			return;
		}

		files = dir.list();     // list everything in this directory

		// run through file/directory list
		if ((files != null) && (files.length > 0)) {
			for (int i=0; i < files.length; i++) {
				File infile = new File(dir, files[i]);

				// if item is a file, delete it
				if (infile.isFile()) {
					//infile.delete();

					java.nio.file.Path path = java.nio.file.Paths.get(dir.toURI()); 
					if(java.nio.file.Files.isSymbolicLink(path)){ 
						try {
							java.nio.file.Files.delete(path);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					}else {
						infile.delete();
					}
				}
				// if item is a directory, call ourselves recursively
				else {
					deleteDirectory(infile);
				}
			}
		}
		dir.delete();
		return;
	}
	
	
	/**
	 * To Crete symblink in windows:
	 * 	https://www.howtogeek.com/howto/16226/complete-guide-to-symbolic-links-symlinks-on-windows-or-linux/
	 *  
	 * @param dir
	 */

	public static void deleteSymbLink(File dir){

		java.nio.file.Path path = java.nio.file.Paths.get(dir.toURI()); 
		try { 
			if(java.nio.file.Files.isSymbolicLink(path)){ 
				java.nio.file.Files.delete(path); 
				return; 
			} 
		} catch (IOException e) { 
			
		}

	}


}



/**
 * Symbolic links are basically advanced shortcuts. 
 * Create a symbolic link to an individual file or folder, and that link will appear to be the same as the file or folder to Windows.

There are two type of symbolic links: 
 - Soft symbolic links work similarly to a standard shortcut. When you open a soft link to a folder, you will be redirected to the folder where the files are stored.
 - Hard link makes it appear as though the file or folder actually exists at the location of the symbolic link.
Windows  uses the terms “hard link” and “symbolic link” (for soft link).

To create symbolic links use the mklink command in a Command Prompt window as Administrator. 
Locate the “Command Prompt” shortcut in your Start menu, right-click it, and select “Run as Administrator”.

mklink command can create both hard links (known as “hard links” in Windows) and soft links
  - mklink Link Target - creates a symbolic (soft) link at Link pointing to the file Target 
  - mklink /D Link Target - to create a soft link pointing to a directory Target
  - mklink /H Link Target - to create a hard link pointing to a file Target
  - mklink /J Link Target - to create a hard link pointing to a directory
*/