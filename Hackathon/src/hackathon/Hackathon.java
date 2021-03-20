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
    public static void main(String[] args) throws FileNotFoundException {
        // Theme: They are all the same
        // autocorrect
        
        String fileName = "10thousandwords.txt";
        String fileName2 = "300thousandwords.txt";
        String fileName3 = "500thousandwords.txt";
        
        /*
        Scanner userPrompt = new Scanner(System.in);    // prompt user input
        System.out.println("Enter a word");
        String userInput = userPrompt.nextLine();
        System.out.println(userInput);
        */
        
        //Correct newCorrect = new Correct(fileName, "String");
        //System.out.println(newCorrect.readFile());
        //System.out.println(newCorrect.searchText("String"));
        
        Correct newCorrect = new Correct(fileName3);
        
        
        newCorrect.searchText("String");
    }
    
}
