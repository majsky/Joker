package me.majsky.joker.server;

import java.io.IOException;
import java.net.Socket;

import me.majsky.networking.PacketDispatcher;
import me.majsky.networking.PacketReciever;
import me.majsky.networking.packet.Packet;

public class ClientConnection extends Thread{

    public PacketReciever reciever;
    public PacketDispatcher dispatcher;
    
    public ClientConnection(Socket s){
        try{
            reciever = new PacketReciever(s);
            dispatcher = new PacketDispatcher(s);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void run(){
        boolean connected = true;
        try{
            do{
                Packet packet = reciever.recievePacket();
                System.out.println(packet);
            }while(connected);
        }catch(ClassNotFoundException | IOException e){e.printStackTrace();}
    }

}
