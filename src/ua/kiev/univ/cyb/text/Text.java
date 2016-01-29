package ua.kiev.univ.cyb.text;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains information about Text.
 *
 * @author Nataliia Kozoriz
 * @version 1.0
 * @see Sentence
 */
public class Text {

    /**
     * List of all sentences
     *
     * @see Sentence
     */
    private final List<Sentence> sentences;

    /**
     * Constructs empty text
     */
    public Text() {
        sentences = new ArrayList<>();
    }

    /**
     * Add new sentence to this text.
     *
     * @param sentence new sentence in string form
     */
    public void addSentence(String sentence) {
        sentences.add(new Sentence(sentence));
    }

    /**
     * Returns all words of this sentence
     *
     * @return list of all words
     */
    public Sentence getAllWordsSentene() {
        Sentence wordSentence = new Sentence();
        for (Sentence sentence : sentences) {
            wordSentence.addWords(sentence);
        }
        return wordSentence;
    }

    /**
     * Print all words of this text in ascending order of vowel percent
     */
    public void printAllWordsInAscOfVowels() {
        Sentence wordSentence = getAllWordsSentene();
        wordSentence.sortInAscOfVowels();
        wordSentence.print();
    }

    /**
     * Print text in sorting order. Sorting is done by amount of words in the
     * sentences. Sentences with minimum amount of words go first.
     */
    public void printInAscendingWordAmount() {
        List<Sentence> currSentences = new ArrayList(sentences);
        sortInAscendingWordAmount(currSentences);
        for (Sentence sentence : currSentences) {
            sentence.print();
        }
    }

    /**
     * Sort by amount of words in the sentences. Sentences with minimum amount
     * of words go first.
     */
    static void sortInAscendingWordAmount(List<Sentence> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).countWords() > list.get(j).countWords()) {
                    Sentence sentence = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, sentence);
                }
            }
        }
    }
}
