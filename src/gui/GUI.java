package gui;

import javax.swing.JFrame;

import gui.screens.MainScreen;
import gui.screens.Pause;


public class GUI{

    private JFrame frame;
    private Screen currentScreen;
    
    public GUI ()
    {
        configureFrame();
        this.currentScreen = new MainScreen(this.frame);
        this.frame.setVisible(true);
    }

    private void configureFrame ()
    {
        this.frame = new JFrame("Tycoon Game");
        frame.setLayout(null);
        frame.setSize(500 , 200);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setFrameMainMenu ()
    {
        this.currentScreen = null;
        this.currentScreen = new MainScreen(this.frame);
    }

    public void setFramePause ()
    {
        this.currentScreen = null;
        this.currentScreen = new Pause(this.frame);
    }
}