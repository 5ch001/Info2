import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Game {
    private BufferedReader in;
    private PrintWriter out;

    public Game(BufferedReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    // Implement your game logic here
    public void startGame() throws IOException {
        out.println("Welcome to Zuul Game!");
        out.println("Type 'help' for instructions.");

        // Example game loop
        String userInput;
        while ((userInput = in.readLine()) != null) {
            // Process user input and respond accordingly
            if (userInput.equalsIgnoreCase("help")) {
                out.println("You are lost. You are alone. You wander");
                out.println("around at the HTW university.");
                out.println("Your command words are:");
                out.println("quit | help");
            } else if (userInput.equalsIgnoreCase("quit")) {
                out.println("Bye, have a great day!");
                break;
            } else {
                out.println("Invalid command. Type 'help' for instructions.");
            }
        }
    }
}