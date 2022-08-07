import java.util.Random;
import java.util.Scanner;

/**
 * RPS class that extends and inherits from Game class --> Number guesser is a traditional game for guessing numbers;
 */
public class NumberGuesser extends Game{
    private int maxGuesses;
    private Random rng;
    private int maxNumber;
    private int secretNumber;
    private int count;
    private int int_move;

    /**
     * Construtor method which intitializes: the Random object to use when generating the secret numbers, the
     * maximum number to use when generating the secret number (inclusive) and the maxi-
     * mum number of guesses.
     */
    public NumberGuesser(Random rng, int maxNumber, int maxGuesses) {
        this.rng = rng;
        this.maxNumber = maxNumber;
        this.maxGuesses = maxGuesses;
        count = maxGuesses;
    }

    /**
     * picks a new secret number between 1 and the maxNumber;
     * @return a message indicating the number range and number of guesses
     */
    @Override
    protected String prepToPlay() {
        secretNumber = rng.nextInt(maxNumber)+1; //not working
        return "I've picked a number 1 to " + maxNumber + ". You get " + maxGuesses + " guesses to guess it";
    }

    /**
     * game is over if the player has guessed every letter in the word OR if they have
     * reached their maximum move limit.
     * @return boolean
     */
    @Override
    protected boolean isOver() {
        if (count == 0 || int_move == secretNumber) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * loops over the string and sees if the indiviual character is a digit or not
     * @param move --> a string resembling a number
     * @return boolean
     */
    @Override
    protected boolean isValid(String move) {
        char[] arrMove = move.toCharArray();
        for (char integer:arrMove) {
            if (!Character.isDigit(integer)) {
                return false;
            }
        }
        return true;
    }

    /**
     * parsing the move string, then figures whether it is bigger or smaller than the secretNumber
     * @param move --> a number string
     * @return a string indicating if it is bigger or smaller or equal to the number we are looking for
     */
    @Override
    protected String processMove(String move) {
        int_move = Integer.parseInt(move);
        count -= 1;
        if (int_move > secretNumber) {
            return "Too High";
        } else if (int_move < secretNumber) {
            return "Too Low";
        } else {
            return "That's it!";
        }
    }

    /**
     * return a final message that is the secret number
     */
    @Override
    protected String finalMessage() {
        count = 0;
        int_move = 0;
        count = maxGuesses; return "The number was: " + secretNumber;
    }

    /**
     * @return gets the name of the game
     */
    @Override
    public String getName() {
        return "NumberGuesser";
    }

    public static void main(String[] args) {
        FakeRandom rng = new FakeRandom(22);
        Game number  = new NumberGuesser(rng, 72, 1);
        Scanner user = new Scanner(System.in);
        number.play(user);
    }

}
