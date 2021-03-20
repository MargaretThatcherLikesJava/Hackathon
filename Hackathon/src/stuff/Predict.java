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
public class Predict {
    
    private String _text;
    private String _filePath = "WordList.txt";
    
    public Predict(String text) {
        _text = text;
    }
    
    public String getText() {
        return _text;
    }
    
    public boolean readFile() throws FileNotFoundException {
        boolean hasRead = false;
        try {
            File fileInput = new File(_filePath);
            Scanner in = new Scanner(fileInput);
            hasRead = true;
        } catch (Exception e) {
            hasRead = false;
        }
        return hasRead;
    }
    
    public boolean searchText(String s) {
        boolean hasFound = false;
        
        
        
        return hasFound;
    }
    
}
