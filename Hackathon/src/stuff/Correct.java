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
    
    private String _path;
    
    public Correct(String path) {
        _path = path;
    }
    
    public String getPath() {
        return _path;
    }
    
    /**
     * Checks if the file is found and can be read. if not, return false
     * @return boolean if can / cannot read file
     * @throws FileNotFoundException 
     */
    public boolean readFile() throws FileNotFoundException {
        boolean hasRead = false;    // can read
        try {
            File fileInput = new File(_path);   
            Scanner in = new Scanner(fileInput);
            in.close();
            hasRead = true;
            System.out.println("Success! read file");
        } catch (Exception e) {
            hasRead = false;
            System.out.println("Error! Cannot read file");;
        }
        return hasRead;
    }
    
    /**
     * Counts the total words. since they're one per line, counts lines
     * @return total word count
     * @throws FileNotFoundException 
     */
    public int countWords() throws FileNotFoundException {
        int i = 0;
        if (readFile()) {
            File fileInput = new File(_path);   
            Scanner in = new Scanner(fileInput);
            while (in.hasNextLine()) {
            String line = in.nextLine();
            i++;
            }
        } else {
            System.out.println("Error! Cannot read file");
        }
        return i;
    }
    
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
            File fileInput = new File(_path);
            Scanner in = new Scanner(fileInput);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (s == line) {    // whole word found, done
                    words.add(s);
                } else {    // no whole found, find similar words
                    char[] sArray = s.toCharArray();
                    char[] lineArray = line.toCharArray();
                    
                    
                }
            }
        } else {
            System.out.println("Error! Cannot read file.");
        }
        return words;
    }
}