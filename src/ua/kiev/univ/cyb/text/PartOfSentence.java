package ua.kiev.univ.cyb.text;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is abstract. Contains information about part of the sentence.
 *
 * @author Nataliia Kozoriz
 * @version 1.0
 * @see Sentence
 * @see Word
 * @see Punctuation
 * @see Char
 */
public abstract class PartOfSentence {

    /**
     * List of all Chars
     *
     * @see Char
     */
    protected final List<Char> chars;

    /**
     * Constructs new part of sentence
     *
     * @param s all chars of new part of sentence
     */
    public PartOfSentence(String s) {
        chars = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            chars.add(new Char(s.charAt(i)));
        }
    }
    
    /**
     * Print this part of sentence
     */
    public void print() {
        for (Char c : chars) {
            c.print();
        }
    }
}
