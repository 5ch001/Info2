import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345); // Choose a port number
        System.out.println("Server is waiting for client...");
        Socket clientSocket = serverSocket.accept(); // Wait for client connection

        // Communication streams
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Read from and write to the client
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Client: " + inputLine);
            out.println("Server received: " + inputLine);
        }

        // Close resources
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}