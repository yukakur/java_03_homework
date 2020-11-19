import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.*;

public class Server {
    private static final Logger logger = Logger.getLogger(Server.class.getName());
    private DataInputStream in;
    private DataOutputStream out;

    public boolean isCloseConnection() {
        return closeConnection;
    }

    private boolean closeConnection = true;

    public Server () {
        try {
            ServerSocket serverSocket = new ServerSocket(14334);
//            System.out.println("Server starting");
            logger.log(Level.INFO, "server started");
            Socket socket = serverSocket.accept();
//            System.out.println("Server got connection " + socket);
            logger.log(Level.INFO, "Server received connection");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Handler serverHandler = new ConsoleHandler();
            serverHandler.setLevel(Level.ALL);
            serverHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(serverHandler);
            logger.log(Level.ALL, "test");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Server thread network waiting...");
                        while (closeConnection) {
                            ForSendObject readObject1 = (ForSendObject)ois.readObject();
                            System.out.println( "object received " + readObject1.getClass() + " " + readObject1.toString());
                            logger.log(Level.INFO, "received something");
                            String message = in.readUTF();
                            if(message.equals("close terminal")) {
                                closeConnection = false;
                                throw new IOException();
                            }
                            System.out.println("client > server: " + message);
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("client closed connection");
                        logger.log(Level.WARNING, "Client closed connection");


                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("server thread waiting console");
                    try {
                        while(closeConnection) {
                            String message = reader.readLine();
                            if (!message.trim().isBlank()) {
                                out.writeUTF(message);
                                logger.log(Level.INFO, "server received something");
                                System.out.println("sent: " + message );
                            }
                            else throw new IOException();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        try {
                            reader.close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                in.close();
                out.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }


    }


    public static void main(String[] args) {
        new Server();
    }
}
