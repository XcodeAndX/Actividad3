import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try {
            // Creamos el socket del servidor
            ServerSocket serverSocket = new ServerSocket(9000);

            System.out.println("Esperando conexiones entrantes...");

            while (true) {
                // Aceptamos la conexión entrante
                Socket clientSocket = serverSocket.accept();
                System.out.println("Conexión establecida con el cliente " + clientSocket.getInetAddress());

                // Creamos un buffer de entrada y salida para comunicarnos con el cliente
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Leemos el mensaje del cliente
                String message = in.readLine();
                System.out.println("Recibido: " + message);

                // Enviamos el mensaje de vuelta al cliente
                out.println("Mensaje recibido: " + message);

                // Cerramos la conexión con el cliente
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

