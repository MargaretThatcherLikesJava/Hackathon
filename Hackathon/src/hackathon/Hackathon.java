/**
* Corrective and predictive text
* @author Evan Chee
* @version 1.0, March 20, 2021
* Note that this version is not thread safe.
*/

package hackathon;
import java.io.*;
import java.util.*;
import stuff.*;

/**
 *
 * @author chee
 */
public class Hackathon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        // Theme: They are all the same
        // autocorrect
        
        String fileName = "WordList.txt";   // read file
        File fileInput = new File(fileName);
        Scanner in = new Scanner(fileInput);
        
        Scanner userPrompt = new Scanner(System.in);    // prompt user input
        System.out.println("Enter a word");
        String userInput = userPrompt.nextLine();
        System.out.println(userInput);
        
        /*
        int i = 0;  // count total lines
        while (in.hasNextLine()) {  // gather text lines
            String line = in.nextLine();
            i++;    
            
            System.out.println(line);
        }
        
        in.close();
        
        System.out.println("\n");
        System.out.println("Total: " + i);
        */
    }
    
}
