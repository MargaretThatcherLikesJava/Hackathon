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
public class Correct {
    
    private String _file;
    private int _wordCount;
    
    public Correct(String path) {
        _file = path;
    }
    
    public String getPath() {
        return _file;
    }
    
    /**
     * Checks if the file is found and can be read. if not, return false
     * @return boolean if can / cannot read file
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
    
    /*
    public double percentageOf(char [] array) {
        
    }
    */
    
    /**
     * Search word file for a word. If found stops. If not, finds similar to the String passed. 
     * If many found, add to ArrayList.
     * @param s
     * @return List of same words, or if not the same, similar
     * @throws FileNotFoundException 
     */
    public ArrayList<String> searchText(String s) throws FileNotFoundException {
        ArrayList<String> words = new ArrayList<String>();
        if (readFile()) {
            File fileInput = new File(_file);
            Scanner in = new Scanner(fileInput);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                line.toLowerCase();
                s.toLowerCase();
                if (s.equals(line)) {    // whole word found, done
                    words.add(line);
                } else {    // no whole found, find similar words
                    char[] sArray = s.toCharArray();    // passed string
                    char[] lineArray = line.toCharArray();  // word in file
                    
                    int count = 0;
                    for (int i = 0; i < lineArray.length; i++) {
                        for (int j = 0; j < sArray.length; j++) {
                            if (lineArray[i] == sArray[j]) {
                                line = new String(line);
                                words.add(line);
                                
                            }
                        }
                    }
                    
                    
                }
            }
        } else {
            System.out.println("Error! Cannot read file.");
        }
        return words;
    }
    
    @Override
    public String toString() {
        String displayPath = "File: " + _file;
        String displayWordCount = "Word Count: " + _wordCount;
        return displayPath + "\n" + displayWordCount;
    }
}