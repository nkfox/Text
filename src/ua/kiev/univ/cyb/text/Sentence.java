package ua.kiev.univ.cyb.text;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class contains information about Sentence. Sentence can consist of
 * combinations of words and punctuation.
 *
 * @author Nataliia Kozoriz
 * @version 1.0
 * @see Text
 * @see PartOfSentence
 * @see Word
 * @see Punctuation
 */
public class Sentence {

    /**
     * List of all sentences
     *
     * @see PartOfSentence
     * @see Word
     * @see Punctuation
     */
    private final List<PartOfSentence> parts;

    /**
     * Constructs empty sentence
     */
    public Sentence() {
        parts = new ArrayList<>();
    }

    /**
     * Constructs new sentence by sting
     *
     * @param string new sentence in string form
     */
    public Sentence(String string) {
        parts = new ArrayList<>();
        parse(string);
    }

    /**
     * Parsing string to make a new sentence. String is divided into words and
     * punctuation.
     *
     * @param string new sentence in string form
     */
    private void parse(String string) {
        String punct = "([\\.]){3}|[,\\.\\?!@\":;\'–\\(\\)]";
        String word = "[\\w]+";

        Pattern pos = Pattern.compile(word + "|" + punct);
        Pattern w = Pattern.compile(word);
        Pattern p = Pattern.compile(punct);
        Matcher m = pos.matcher(string);
        while (m.find()) {
            Matcher mm = w.matcher(m.group());
            if (mm.find()) {
                this.parts.add(new Word(m.group()));
            } else {
                this.parts.add(new Punctuation(m.group()));
            }
        }
    }

    /**
     * Add all words from another sentence
     *
     * @param sentence all new words are taken from this sentence
     */
    public void addWords(Sentence sentence) {
        for (PartOfSentence part : sentence.parts) {
            if (part instanceof Word) {
                this.parts.add(part);
            }
        }
    }

    /**
     * Sort words of this sentence in ascending order of vowel percent
     */
    public void sortInAscOfVowels() {
        for (int i = 0; i < parts.size() - 1; i++) {
            for (int j = i + 1; j < parts.size(); j++) {
                if (((Word) parts.get(i)).countVowelPercent() < ((Word) parts.get(j)).countVowelPercent()) {
                    Word word = (Word) parts.get(i);
                    parts.set(i, (Word) parts.get(j));
                    parts.set(j, word);
                }
            }
        }
    }

    /**
     * Count words in this sentence
     *
     * @return amount of words
     */
    public int countWords() {
        int count = 0;
        for (PartOfSentence part : parts) {
            if (part instanceof Word) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns all words of this sentence
     *
     * @return list of all words
     */
    public List<Word> getAllWords() {
        List<Word> words = new ArrayList<>();
        for (PartOfSentence part : parts) {
            if (part instanceof Word) {
                words.add((Word) part);
            }
        }
        return words;
    }

    /**
     * Print this sentence
     */
    public void print() {
        for (PartOfSentence part : parts) {
            part.print();
            System.out.print(" ");
        }
        System.out.println();
    }
}
