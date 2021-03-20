/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stuff;

import java.io.*;
import java.util.*;

/**
 *
 * @author chee
 */
public class Commands {
    
    private String _file;
    private int _wordCount;
    private String _command;    // search, similar
    private String _userInput;
    
    public Commands(String command, String path, String userInput) throws FileNotFoundException {
        _command = command;
        _file = path;
        _userInput = userInput;
        this.control();
    }
    

    /**
     * Checks if the file is readable
     * @return
     * @throws FileNotFoundException 
     */
    public boolean readFile() throws FileNotFoundException {
        boolean hasRead = false;    // can read
        try {
            File fileInput = new File(_file);   
            Scanner in = new Scanner(fileInput);
            in.close();
            hasRead = true;
        } catch (Exception e) {
            hasRead = false;
        }
        return hasRead;
    }
    
    /**
     * Counts the total words. since they're one per line, counts lines
     * @return total word count
     * @throws FileNotFoundException 
     */
    public String countWords() throws FileNotFoundException {
        String message = "";
        _wordCount = 0;
        if (readFile()) {
            File fileInput = new File(_file);   
            Scanner in = new Scanner(fileInput);
            while (in.hasNextLine()) {
            String line = in.nextLine();
            _wordCount++;
            }
        } else {
            System.out.println("Error! Cannot read file");
        }
        message = "Word Count: " + _wordCount;
        return message;
    }
   
    /**
     * Search word file for a word. If found stops. If not, finds similar to the String passed. 
     * If many found, add to ArrayList.
     * @param s
     * @return List of same words, or if not the same, similar
     * @throws FileNotFoundException 
     */
    
    public String control() throws FileNotFoundException {
        _command = _command.toLowerCase();
        String result = "";
        if (_command == "search") {
            result = searchText(_userInput);
        }
        System.out.println(result);
        return result;
    }
    
    public String searchText(String s) throws FileNotFoundException{
        String result = "";
        int lineCounter = 0;
        s = s.toLowerCase();
        if (readFile()) {
            File fileInput = new File(_file);
            Scanner in = new Scanner(fileInput);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                line = line.toLowerCase();
                lineCounter++;
                if (s.equals(line)) {
                    String displayStatus = "Word found: " + line + "\n";
                    String displayLineNumber = "Word " + lineCounter + " of " +countWords() + "\n";
                    String displayFileName = "In file: " + _file + "\n";
                    result = "\n" + displayStatus + displayFileName + displayLineNumber + "\n";
                }
            }
        }
        return result;
    }
   
    @Override
    public String toString() {
        String displayPath = "File: " + _file;
        String displayWordCount = "Word Count: " + _wordCount;
        return displayPath + "\n" + displayWordCount;
    }

}