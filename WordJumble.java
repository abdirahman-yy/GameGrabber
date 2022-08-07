import java.util.Random;
import java.util.Scanner;

/**
 * Word Jumble class that extends and inherits from Game class;
 */
public class WordJumble extends Game {
    private int maxWordLen;
    private int maxGuesses;
    private Random rng;
    private WordsList wl;
    private int minWordLen;
    private int count;
    private String word;
    private String guess;

    /**
     * Construtor method which intitializes:  word list object to use when getting random words,
     * random number generator to use when shuffling the word, minimum and maximum (inclusive on both) word length,
     * number of guesses allowed – after this number of guesses the player looses.
     */
    public WordJumble(WordsList wl, Random rng, int minWordLen, int maxWordLen, int maxGuesses) {
        this.wl = wl;
        this.rng = rng;
        this.minWordLen = minWordLen;
        this.maxWordLen = maxWordLen;
        this.maxGuesses = maxGuesses;
        count = maxGuesses;
    }


    /**
     * picks a new secret word whose length is within the sizes set by
     * minWordLen and maxWordLen (inclusive)
     * @return a including the jumbeled word and the maximum number of guesses.
     */
    @Override
    protected String prepToPlay() {
        word = wl.getWord(minWordLen, maxWordLen);
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            int index = rng.nextInt(wordArr.length);
            char tempVal = wordArr[i];
            wordArr[i] = wordArr[index];
            wordArr[index] = tempVal;
        }
        String scrambledWord = new String(wordArr);
        return "The following is a jumbled up word: " +  scrambledWord + " You get " + maxGuesses + " guesses to guess it";
    }


    /**
     * checks if game is over either by count going to 0 or by word equaling guesses
     * @return boolean
     */
    @Override
    protected boolean isOver() {
        if (count == 0 || (word.equals(guess)) && count != maxGuesses || guess.equals(null)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * any move is valid in word Jumble
     * @param move a string indicates a word; all moves are correct and true
     * @return
     */
    @Override
    protected boolean isValid(String move) {
        return true;
    }


    /**
     * this function processes the move by checking if it is equal to hidden word; if it is returns null;
     * @param move a string that is a word
     * @return null or returns that is not it
     */
    @Override
    protected String processMove(String move) {
        guess = move;
        String str = null;
        if (!move.equals(word)) {
            str = "That's not it";
            count -= 1;
            return str;
        } else {
            return null;
        }
    }

    /**
     * @return the final message
     */
    @Override
    protected String finalMessage() {
        guess = "";
        count = maxGuesses;
        return "The word was " + word;
    }

    /**
     * @return game name
     */
    @Override
    public String getName() {
        return "Word jumble";
    }

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        Random rand = new Random();
        WordsList words = new WordsList(rand);
        WordJumble nG = new WordJumble(words, rand, 2, 10, 3);
        nG.play(user);
    }

}
