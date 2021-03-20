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
    private String _file2;
    private String _command;    // search, compare
    private String _userInput;
    
    public Commands(String command, String path, String userInput) throws FileNotFoundException {
        _command = command;
        _file = path;
        _userInput = userInput;
        this.control();
    }
    
    public Commands(String command, String path, String path2, String userInput) throws FileNotFoundException {
        _command = command;
        _file = path;
        _file2 = path2;
        _userInput = userInput;
        this.control();
    }

    /**
     * Checks if the file is readable
     * @return
     * @throws FileNotFoundException 
     */
    public boolean readFile(String path) throws FileNotFoundException {
        boolean hasRead = false;    // can read
        try {
            File fileInput = new File(path);   
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
    public int countWords(String path) throws FileNotFoundException {
        int total = 0;
        if (readFile(path)) {
            File fileInput = new File(_file);   
            Scanner in = new Scanner(fileInput);
            while (in.hasNextLine()) {
            String line = in.nextLine();
            total++;
            }
        } else {
            System.out.println("Error! Cannot read file");
        }
        return total;
    }
    
    public int findLineNumber(String path, String s) throws FileNotFoundException{
        int number = 0;
        if (readFile(path) && searchText(path, s)) {
            File fileInput = new File(_file);   
            Scanner in = new Scanner(fileInput);
            while (in.hasNextLine()) {
            String line = in.nextLine();
            number++;
            }
        }
        return number;
    }
    
    public void control() throws FileNotFoundException {
        _command = _command.toLowerCase();
        if (_command == "search") {
            searchText(_file, _userInput);
        } else if (_command == "compare") {
            
        }
    }
    /**
     * Searches through file for string. If found, returns with information
     * @param s
     * @return
     * @throws FileNotFoundException 
     */
    public boolean searchText(String path, String s) throws FileNotFoundException{
        String result = "";
        int lineCounter = 0;
        boolean contains = false;
        s = s.toLowerCase();
        if (readFile(path)) {
            File fileInput = new File(_file);
            Scanner in = new Scanner(fileInput);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                line = line.toLowerCase();
                lineCounter++;
                if (s.equals(line)) {
                    String displayStatus = "Word found: " + line;
                    String displayFileName = "In file: " + _file;
                    String displayLineNumber = "Word " + lineCounter + " of " +countWords(_file) + "\n";
                    contains = true;
                    System.out.println(displayStatus);
                    System.out.println(displayFileName);
                    System.out.println(displayLineNumber);
                } 
            }
            
        }
        return contains;
    }
    
    public int compare(String path1, String path2) throws FileNotFoundException{
        int difference = 0;
        
        if(readFile(path1) && readFile(path2)) {
            int totalWordsFile1 = countWords(path1);
            int totalWordsFile2 = countWords(path2);
            int lineNumber1 = findLineNumber(path1, _userInput);
            int lineNumber2 = findLineNumber(path2, _userInput);
            
            
        } else {
            
        }
        
        return difference;
    }
   
    @Override
    public String toString() {
        String displayPath = "File: " + _file;
        return displayPath;
    }

}