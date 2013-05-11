package me.majsky.joker.client.states;

import me.majsky.joker.client.connection.ServerConnector;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class StateConnectToServer extends JokerState{

    private Rectangle[] rectangles = new Rectangle[5];
    
    public static StateConnectToServer instance;
    
    private String text;
    private int countdown = 3500;
    
    public StateConnectToServer(int id){
        super(id);
        
        for(int i=0;i<rectangles.length;i++)
            rectangles[i] = new Rectangle(175*i, 275, 51, 51);
        instance = this;
        text = "Conneting to gameserver...";
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException{
        container.getGraphics().setBackground(Color.gray);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException{
        g.setColor(Color.black);
        g.fillRect(0, 275, 800, 50);
        g.setColor(Color.white);
        g.drawRect(-1, 275, 801, 50);
        g.setColor(Color.darkGray);
        for(Rectangle r:rectangles)
            if(r != null && r.getX()<800 && r.getX()>-51)
                g.fill(r);
        g.setColor(Color.white);
        g.drawString(text, 400 - g.getFont().getWidth(text)/2, 275+60);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException{
        for(Rectangle r:rectangles){
            r.setX(r.getX() + delta/5);
            if(r.getX()>850)
                r.setX(-75);
        }
        
        if(text.equals("Connected!"))
            countdown -= delta;
        
        if(countdown <= 0)
            System.out.println("Entaring new state!");
    }
    
    public void connectionFailed(){
        text = "Connection failed";
    }
    
    public void connectionSucess(){
        text = "Connected!";
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException{
        new ServerConnector().start();
    }

}
