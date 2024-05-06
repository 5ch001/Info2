import java.io.*;
import java.net.*;

public class ClientExtended {
    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost"; // Server's IP address or hostname
        int port = 8080; // Server's port number

        // Create a socket and connect to the server
        Socket socket = new Socket(serverAddress, port);

        // Communication streams
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        // Read from server
        Thread readFromServer = new Thread(() -> {
            try {
                String serverResponse;
                while ((serverResponse = in.readLine()) != null) {
                    System.out.println("Server: " + serverResponse);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        readFromServer.start();

        // Read from user and send to server
        String userInput;
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput); // Send user input to server
        }

        // Close resources
        out.close();
        in.close();
        stdIn.close();
        socket.close();
    }
}
