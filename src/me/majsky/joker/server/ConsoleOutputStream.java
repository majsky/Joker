package me.majsky.joker.server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class ConsoleOutputStream extends OutputStream{

    private PrintStream originalOut;
    
    public ConsoleOutputStream(PrintStream original){
        originalOut = original;
    }
    
    @Override
    public void write(int b) throws IOException{
        write(new byte[]{(byte)b});
    }

    @Override
    public void write(byte[] b) throws IOException{
        String s = new String(b);
        JokerServer.instance.addText(s);
        originalOut.append(s);
    }

}
