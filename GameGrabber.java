import java.util.Random;
import java.util.Scanner;


/**
 * GameGrabber class represents a menu system across multiple games in the game pack
 */
public class GameGrabber {
    private Scanner user;
    private Game[] games;
    private int index;

    /**
     * initializes the parameters of games and user
     * @param games --> a list of games
     * @param user --> a scanner object to use for all user input
     */
    public GameGrabber(Game[] games, Scanner user) {
        this.games = games;
        this.user = user;
    }

    /**
     * prints a menu of games and runs play on the specific game that is picked or returns goodbye if quit is chosen
     * @param
     */
    public void doMenu() {
        while (!(games.length < index)) {
            for (int i = 0; i < games.length; i++) {
                System.out.println("" + i + ") " + games[i].getName());
            }
            System.out.println("" + (games.length) + ") " + "Quit");
            System.out.print("Pick a game (" + 0 + "-" + games.length + ") ");
            index = Integer.parseInt(user.next());
            while (index > games.length || index < 0) {
                System.out.print("Pick a game (" + 0 + "-" + games.length + ") ");
                index = Integer.parseInt(user.next());
            }
            games[index].play(user);
        }
        System.out.println("goodbye");
    }

    /**
     * calls do menu and executes the game grabber prompt
     */
    public static void main(String[] args) {
        Random rng = new Random();
        WordsList words = new WordsList(rng);
        Scanner scanner = new Scanner(System.in);
        Game[] games = new Game[]{new Hangman(words, 3, 10, 10), new NumberGuesser(rng, 3, 3), new RPS(rng, 3, 3), new WordJumble(words, rng, 3, 3, 10)  };
        GameGrabber gameGrabber = new GameGrabber(games, scanner);
        gameGrabber.doMenu();
    }
}
