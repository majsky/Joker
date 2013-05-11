package me.majsky.joker.server;

import java.awt.BorderLayout;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

public class JokerServer extends JFrame{
    private static final long serialVersionUID = 1L;
    
    private JTextArea textArea;
    private JTextField userText;
    
    protected static JokerServer instance;
    
    public JokerServer(){
        super("Jocker server v. " + JokerServer.class.getPackage().getImplementationVersion());
        
        userText = new JTextField();
        //TODO Action listener
        add(userText, BorderLayout.NORTH);
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        DefaultCaret caret = (DefaultCaret)textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void addText(String s){
        textArea.append(s);
    }
    
    public static void main(String[] args){
        instance = new JokerServer();
        System.setOut(new PrintStream(new ConsoleOutputStream(System.out)));
        System.setErr(new PrintStream(new ConsoleOutputStream(System.err)));
        new ServerThread().run();
    }
}
