import java.util.Random;
import java.util.Scanner;


/**
 * RPS class that extends and inherits from Game class; mimics a rock-paper-scissors game
 */
public class RPS extends Game {

    private int requiredWins;
    private int maxLosses;
    private Random rng;
    private String computerMove;
    private int lossCount;
    private int winsCount;


    /**
     * Construtor method which intitializes: Random object to use when picking moves, The number of turns the player has
     * to win before they beat the game, and the number of turns they have to lose before they
     * lose the game.
     */
    public RPS(Random rng, int requiredWins, int maxLosses) {
        this.rng = rng;
        this.requiredWins = requiredWins;
        this.maxLosses = maxLosses;
        lossCount = maxLosses;
        winsCount = requiredWins;
    }


    /**
     * sets up string array with rock and paper and scissors
     * @return a message explaining the instructions and win/lose conditions.
     */
    @Override
    protected String prepToPlay() {
        String[] arr = {"rock", "paper", "scissors"};
        computerMove = arr[rng.nextInt(arr.length)]; //gets the randomly chosen index and then index it using the array
        return "Enter rock, paper, or scissors. Beat me " + requiredWins + " times before I win " + maxLosses + " times!";
    }


    /**
     *  this is over if the player has won enough rounds (determined by requiredWins)
     * or lost too many rounds (determined by maxLosses)
     * @return boolean
     */
    @Override
    protected boolean isOver() {
        if (lossCount == 0 || winsCount == 0) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * ”rock” ”paper” ”scissors”. All other moves are invalid.
     * @param "string that is either" -->  ”rock” ”paper” ”scissors”
     * @return boolean
     */
    @Override
    protected boolean isValid(String move) {
        if (computerMove.equals("rock") || computerMove.equals("paper") || computerMove.equals("scissors")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * checks whether computer wins or loses based on the what the players choose
     * @param move --> the choice of the player -->  ”rock” ”paper” ”scissors”
     * @return this returns a string of what the AI choose and what you choose and tells you whether you
     * win, lose or tie
     */
    @Override
    protected String processMove(String move) {
        for (int i = 0; i < (requiredWins + maxLosses); i++) {
            String[] arr = {"rock", "paper", "scissors"};
            computerMove = arr[rng.nextInt(arr.length)];
            if (computerMove.equals(move)) {
                return "" + computerMove + " vs. " + move + " You Tie";
            } else if (computerMove.equals("rock") && move.equals("paper")) {
                winsCount -= 1;
                return "" + computerMove + " vs. " + move + " You Win";
            } else if (computerMove.equals("paper") && move.equals("rock")) {
                lossCount -= 1;
                return "" + computerMove + " vs. " + move + " You lose";
            } else if (computerMove.equals("scissors") && move.equals("rock")) {
                winsCount -= 1;
                return "" + computerMove + " vs. " + move + " You Win";
            } else if (computerMove.equals("rock") && move.equals("scissors")) {
                lossCount -= 1;
                return "" + computerMove + " vs. " + move + " You lose";
            } else if (computerMove.equals("scissors") && move.equals("paper")) {
                lossCount -= 1;
                return "" + computerMove + " vs. " + move + " You lose";
            } else if (computerMove.equals("paper") && move.equals("scissors")) {
                winsCount -= 1;
                return "" + computerMove + " vs. " + move + " You Win";
            }
        }
        return null;
    }

    /**
     * returns a final message
     * @return a string indicating win or lose
     */
    @Override
    protected String finalMessage() {
        if (lossCount == 0) {
            return "you lose the set";
        } else {
            return "You win the set";
        }
    }

    /**
     * @return name of game
     */
    @Override
    public String getName() {
        return "Rock Paper Scissors";
    }

}

