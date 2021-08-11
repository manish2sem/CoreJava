package Java6Features;

import java.io.File;
public class DiskSpaceDemo {

    public static void main(String[] args) {
        // Creates a File object that references the C drive on a    
        // Windows machine 
        File file = new File("C:");
        long totalSpace = file.getTotalSpace();
        System.out.println("Total space on " + file + " = " 
                + totalSpace + " bytes");

        // Check the free space in C:
        long freeSpace = file.getFreeSpace();
        System.out.println("Free space on " + file + " = " 
                + freeSpace + " bytes");
    }
}
