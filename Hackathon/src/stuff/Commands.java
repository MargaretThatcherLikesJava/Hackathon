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
    private String _command;    // search, count, compare
    private String _userInput;
    private int _condition;
    private String _book;
    
    public Commands(String command, String path, String userInput) throws FileNotFoundException {
        _command = command;
        _file = path;
        _userInput = userInput;
        this.control();
    }
    
    public Commands(String command, String book) throws FileNotFoundException {
        _command = command;
        _book = book;
    }
    
    public Commands(String command, String book, String path, int condition) throws FileNotFoundException {
        _command = command;
        _file = path;
        _book = book;
        _condition = condition;
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
     * Searches through file to find string s
     * @param path file location
     * @param s user string input
     * @return true if found
     * @throws FileNotFoundException 
     */
    public boolean contains(String path, String input) throws FileNotFoundException {
        boolean contains = false;
        input = input.toLowerCase();
        if (readFile(path)) {
            File fileInput = new File(path);
            Scanner in = new Scanner(fileInput);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                line = line.toLowerCase();
                if (input.equals(line)) {
                    contains = true;
                }
            } 
        }
        return contains;
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
            in.close();
        } else {
            System.out.println("Error! Cannot read file");
        }
        return total;
    }
    
    /**
     * Find the number of the document that the word was located on.
     * @param path
     * @param input
     * @return
     * @throws FileNotFoundException 
     */
    public int findLineNumber(String path, String input) throws FileNotFoundException{
        int number = 0;
        input = input.toLowerCase();
        if (readFile(path) && contains(path, input)) {
            File fileInput = new File(_file);   
            Scanner in = new Scanner(fileInput);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (input.equals(line)){
                    break;
                }
                number++;
            }
        }
        return number;
    }
    
    public void control() throws FileNotFoundException {
        _command = _command.toLowerCase();
        if (_command == "search") {
            searchText(_file, _userInput);
        } else if (_command == "count") {
            count(_file, _userInput);
        } else if (_command == "compare") {
            compare(_file, _book, _condition);
        }
    }
    /**
     * Searches through file for string. If found, returns with information
     * @param s
     * @return
     * @throws FileNotFoundException 
     */
    public String searchText(String path, String input) throws FileNotFoundException {
        String message = "";
        if (readFile(path) && contains(path, input)) {
            int totalWords = countWords(path);  // determine total words in file
            int lineNumber = findLineNumber(path, input);   // determine file line of word
            String displayFoundFile = input + " found" + " in file " + path;
            String displayFoundNumber = "Found at line " + lineNumber + " out of " + totalWords + " total lines";
            message = displayFoundFile + "\n" + displayFoundNumber;
        } else {
            message = input + " not found in " + path;
        }
        System.out.println(message+"\n");
        return message;
    }
    
    /**
     * Counts the occurrences of a particular word
     * @return number of occurrences
     */
    public int count(String book, String input) throws FileNotFoundException {
        int count = 0;
        input = input.toLowerCase();
        if (readFile(book)) {
            File fileInput = new File(book);
            Scanner in = new Scanner(fileInput);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                line = line.toLowerCase();
                String[] tokens = line.split(" ");
                for (int i = 0; i < tokens.length; i++){
                    if (tokens[i].equals(input)) {
                        count++;
                    }
                }
                }
            } 
        String message = "There are " + count + " instances of the word " + 
                "'" +input+"'" + " in the book " + book;
                
        System.out.println(message);
        return count;
    }
    
    /**
     * Compare text file with book file
     * @param path
     * @param input
     * @param condition
     * @return word
     * @throws FileNotFoundException 
     */
    public double compare(String path, String book, int condition) throws FileNotFoundException {
        double percentageMatched = 0;
        if (readFile(book)){
            File fileInput = new File(book);
            Scanner in = new Scanner(fileInput);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                line = line.toLowerCase();
                String[] tokens = line.split(" ");
            }
        }
        
        return percentageMatched;
    }
   
    @Override
    public String toString() {
        String displayPath = "File: " + _file;
        return displayPath;
    }

}