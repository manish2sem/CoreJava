package Java6Features;

import java.io.Console;
import java.util.Arrays;
public class PasswordPromptingDemo {

    public static void main(String[] args) {
        // Obtain reference to the Console object
        Console console = System.console();

        // If Console is not available, exit
        if (console == null) {
            System.out.println("Console is not available");
            System.exit(1);
        }

        // password for this application = "mustang"
        char[] password = "mustang".toCharArray();

        // prompt user's password
        char[] passwordEntered = console.readPassword(
                "Enter password: ");

        // compare
        if (Arrays.equals(password, passwordEntered)) {
            // correct password
            System.out.println("\n  Access granted \n");
            Arrays.fill(password, ' ');
            Arrays.fill(passwordEntered, ' ');
            // Run app
            System.out.println("OK ...");
        } else {
            // incorrect password 
            System.out.println("Access denied");
            System.exit(1);
        }
    }
}
