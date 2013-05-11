package me.majsky.joker.client.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import me.majsky.joker.client.states.StateConnectToServer;
import me.majsky.networking.PacketDispatcher;
import me.majsky.networking.PacketReciever;

public class ServerConnector extends Thread{

    private Socket s;
    
    public PacketDispatcher dispatcher;
    public PacketReciever reciever;
    
    public ServerConnector(){
        super("Server connection");
        //TODO LOCALHOST!!
        
    }
    
    @Override
    public void run(){
        try{
            s = new Socket(InetAddress.getLocalHost(), 25566);
            dispatcher = new PacketDispatcher(s);
            reciever = new PacketReciever(s);
        } catch(IOException e){
            e.printStackTrace();
        }
        boolean connected = s!=null;
        
        if(!connected)
            StateConnectToServer.instance.connectionFailed();
        else
            StateConnectToServer.instance.connectionSucess();
        
        while(connected){
            
        }
    }
    
}
