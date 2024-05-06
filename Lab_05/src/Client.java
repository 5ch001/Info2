import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverAddress = "192.168.0.2"; // Server's IP address or hostname
        int port = 12345; // Server's port number

        // Create a socket and connect to the server
        Socket socket = new Socket(serverAddress, port);

        // Communication streams
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        String userInput;
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput); // Send user input to server
            System.out.println("Server: " + in.readLine()); // Print server response
        }

        // Close resources
        out.close();
        in.close();
        stdIn.close();
        socket.close();
    }
}