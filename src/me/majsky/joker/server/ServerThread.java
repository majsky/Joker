package me.majsky.joker.server;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread{

    private ServerSocket socket;
    private List<ClientConnection> activeConnections;
    
    public ServerThread(){
        super("Server thread");
        activeConnections = new ArrayList<>();
        try{
            socket = new ServerSocket(25566);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void run(){
        while(true){
            try{
                Socket connection = socket.accept();
                System.out.println("Client connected from " + connection.getInetAddress().getHostName());
                activeConnections.add(new ClientConnection(connection));
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }

}
