import java.io.*;
import java.net.Socket;

public class Client {
    private DataInputStream in;
    private DataOutputStream out;

//    public Server server;

    private boolean isConnectionAlive = true;
    Socket socket;

    public Client(Server server) {
        isConnectionAlive = server.isCloseConnection();
    }

    public Client () {
        try {
            socket = new Socket("127.0.0.1", 14334);
            System.out.println("client connected " + socket);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());


            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Client thread network waiting...");
                        while (isConnectionAlive) {
                            String message = in.readUTF();
                            System.out.println("Server > client " + message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("client thread waiting console");
                    ForSendObject test1 = new ForSendObject(true, 11, "Hello");

                    try {
                        while(isConnectionAlive) {
                            Thread.sleep(3000);
                            System.out.println("sending object" + test1.toString());
                            ObjectOutputStream oos = new ObjectOutputStream(out);
                            oos.writeObject(test1);
                            System.out.println("object sent");
                            String message = reader.readLine();
                            if (!message.trim().isBlank()) out.writeUTF(message);

                            System.out.println("sent: " + message);
                        }
                    } catch (IOException | InterruptedException e) {
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
        new Client();
    }


}
