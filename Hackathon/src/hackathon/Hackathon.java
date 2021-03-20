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
import Poetry.*;

/**
 *
 * @author chee
 */
public class Hackathon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Theme: They are all the same
        // autocorrect
        
        String fileName2 = "300thousandwords.txt";
        String fileName3 = "500thousandwords.txt";
        String fileName4 = "1millionwords.txt";
        
        String book1 = "theadventuresofsherlockholmes.txt";
        String book2 = "insearchoflosttime.txt";
        String book3 = "infinitejest.txt";
        
        /*
        Scanner userPrompt = new Scanner(System.in);    // prompt user input
        System.out.println("Enter a word");
        String userInput = userPrompt.nextLine();
        */
        //Commands newCommand = new Commands("search", fileName4, userInput);
        
        Commands newCommand = new Commands("count", book1);
        
    }
    
}
