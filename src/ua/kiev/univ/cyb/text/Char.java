package ua.kiev.univ.cyb.text;

/**
 * This class contains information about chars.
 *
 * @author Nataliia Kozoriz
 * @version 1.0
 * @see PartOfSentence
 * @see Punctuation
 * @see Word
 */
public class Char {

    /**
     * Char
     */
    private final char myChar;

    /**
     * Constructs new Char
     *
     * @param myChar char foe Char
     */
    public Char(char myChar) {
        this.myChar = myChar;
    }

    /**
     * Check if char is vowel
     *
     * @return true if character is a letter
     */
    public boolean isVowel() {
        char[] vowels = {'a', 'e', 'i', 'o', 'y', 'u'};
        for (char c : vowels) {
            if (c == this.myChar) {
                return true;
            }
        }
        return false;
    }

    /**
     * Print this char
     */
    public void print() {
        System.out.print(myChar);
    }
}
