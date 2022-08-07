import java.util.Scanner;

/**
 *  This Code was written by Abdirahman Mohamed
 *
 *  In this Game class, an abstract class, is a parent class to the other games for the project
 */


public abstract class Game {

    protected abstract String prepToPlay();

    protected abstract boolean isOver();

    protected abstract boolean isValid(String move);

    protected abstract String processMove(String move);

    protected abstract String finalMessage();

    public abstract String getName();

    /**
     * works as a user interaction for all of the game class using the abstact methods above
     *
     * @param user -->  Scanner object that is currently interacting with the user
     */

    public void play(Scanner user) {
        try {
            String str = prepToPlay();
            System.out.println(str);
            while (!isOver()) {
                System.out.print("Enter Your Move or 'quit' to quit> ");
                String userInput = user.next();
                while (!userInput.equals("quit")) {
                    if (!isValid(userInput)) {
                        System.out.print("Invalid Move! try again> ");
                        userInput = user.next();
                    } else {
                        String move = processMove(userInput);
                        if (move != null) {
                            System.out.println(move);
                            break;
                        } else {
                            break;
                        }
                    }
                }
                return;
            }
            System.out.println(finalMessage());
        } catch(Exception NoSuchElementException){
            System.out.print("Enter Your Move or 'quit' to quit> ");
            System.out.println(finalMessage());
        }
    }
}



