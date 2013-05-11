package me.majsky.joker.client.states;

import org.newdawn.slick.state.BasicGameState;

public abstract class JokerState extends BasicGameState{

    public final int id;
    
    public JokerState(int id){
        this.id = id;
    }

    @Override
    public int getID(){
        return id;
    }

}
