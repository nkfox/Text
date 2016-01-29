package ua.kiev.univ.cyb.text;

/**
 * This class extends @PartOfSentence. It contains methods for working with
 * words.
 *
 * @author Nataliia Kozoriz
 * @version 1.0
 * @see Sentence
 * @see Punctuation
 * @see PartOfSentence
 * @see Char
 */
public class Word extends PartOfSentence {

    /**
     * Constructs new word
     *
     * @param s string form of punctuation
     */
    public Word(String s) {
        super(s);
    }

    /**
     * Count percent of vowels in this word
     *
     * @return percent of vowels in this word
     */
    public double countVowelPercent() {
        int vowels = countVowels();
        return (double) vowels / size();
    }

    /**
     * Count vowels in this word
     *
     * @return amount of vowels in this word
     */
    public int countVowels() {
        int count = 0;
        for (Char c : chars) {
            if (c.isVowel()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Return size of word
     *
     * @return size of word
     */
    public int size() {
        return chars.size();
    }

}
