/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stuff;

/**
 *
 * @author chee
 */
public class Predict {
    
    private String _text;
    private String _filePath = "WordList.txt";
    
    Predict(String text) {
        _text = text;
    }
    
    public String getText() {
        return _text;
    }
    
    
    
}
