package me.majsky.joker.client;

import me.majsky.joker.client.states.StateConnectToServer;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class JokerClient extends StateBasedGame{

    public static AppGameContainer gameContainer;
    private static JokerClient instance;
    
    public JokerClient(String name){
        super(name);
        
    }

    @Override
    public void initStatesList(GameContainer arg0) throws SlickException{
        addState(new StateConnectToServer(0));
    }

    public static void main(String[] args){
        instance = new JokerClient("Joker");
        try{
            gameContainer = new AppGameContainer(instance, 800, 600, false);
            gameContainer.setVSync(true);
            gameContainer.start();
        } catch(SlickException e){
            e.printStackTrace();
        }
    }

}
