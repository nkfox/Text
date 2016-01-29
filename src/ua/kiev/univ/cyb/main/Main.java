/*
 * Nataliia Kozoriz
 * Task2
 * Operations with text
 */
package ua.kiev.univ.cyb.main;

import ua.kiev.univ.cyb.text.Text;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Text text = new Text();
        text.addSentence("Hey... it is me.");
        text.addSentence("ASCII reserves the first 32 codes (numbers 0–31 decimal) for control characters.");
        text.addSentence("Hello)");
        text.printInAscendingWordAmount();
        text.printAllWordsInAscOfVowels();
    }
    
}
