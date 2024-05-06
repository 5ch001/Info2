import java.io.*;
import java.net.*;

public class ServerExtended {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // Choose a port number
        System.out.println("Server is waiting for client...");
        Socket clientSocket = serverSocket.accept(); // Wait for client connection

        // Communication streams
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Create Game instance with input and output streams
        Game game = new Game(in, out);
        game.startGame();

        // Close resources
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
