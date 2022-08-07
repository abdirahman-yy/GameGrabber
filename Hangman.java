import java.util.Random;
import java.util.Scanner;

/**
 * Hangman class that extends and inherits from Game class;
 */

public class Hangman extends Game {
    private String word;
    private String word_search;
    private WordsList words;
    private int minWordLen;
    private int maxWordLen;
    private int maxGuesses;
    private int count;


    /**
     * constructor; initializes the parameters in hangman
     */
    public Hangman(WordsList words, int minWordLen, int maxWordLen, int maxGuesses) {
        this.words = words;
        this.minWordLen = minWordLen;
        this.maxWordLen = maxWordLen;
        this.maxGuesses = maxGuesses;
        count = maxGuesses;
    }

    /**
     * prep to play begins the game by returning a statement onto screen and sets the word and word_search
     */
    public String prepToPlay() {
        word = words.getWord(this.minWordLen, this.maxWordLen);
        word_search = "";
        for (int i = 0; i < word.length(); i++) {
            word_search += "_";
        }
        return "I've picked a " + word.length() + " letter word. Guess letters you think are in the word." + " You" +
                " get " + maxGuesses + " guesses.";
    }


    /**
     * isOvers works as a function to see if the function has hit max guess or the boolean value created
     * above the branching is false meaning there are spaces left. if so it returns true ending the game.
     */
    public boolean isOver() {
        if (count == 0 || word_search.equals(word)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * checks if the string move is valid a valid move meaning its length is one
     */
    public boolean isValid(String move) {
        if (move.length() == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * this takes in the move which is a letter and change one or more spaces on the word_search then returns word_search
     */
    public String processMove(String move) {
        char[] ws_list = word_search.toCharArray();
        char[] str_list = word.toCharArray();
        char char_move = move.charAt(0);
        count -= 1;
        for (int i = 0; i < word.length(); i++) {
            if (str_list[i] == char_move) {
                ws_list[i] = char_move;
                word_search = String.valueOf(ws_list);
                word = String.valueOf(str_list);
            }
        }
        return word_search; //+ "(guess " + '"' + move + '"' + ")";*
    }

    /**
     * returns a final message; the word
     */
    public String finalMessage() {
        count = maxGuesses;
        return "The word was: " + word;
    }

    /**
     * returns the game name
     */
    public String getName() {return "Hangman";}

}

