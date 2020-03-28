package gui.screens;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.Screen;

public class Pause extends Screen {

    private List<JButton> buttons;
    private JPanel panel;

    public Pause(JFrame frame) 
    {
        super(frame);
        this.buttons = new ArrayList<JButton>();
        create();
        frame.add(this.panel);
        frame.setVisible(true);
    }

    protected void create() 
    {
        makeBackSplash();
        this.buttons.add(makeSaveButton());
        this.buttons.add(makeLoadButton());
        this.buttons.add(makeQuitButton());
        this.buttons.add(makeResetButton());
        this.buttons.add(makeBackButtion());
        
    }

    private JButton makeBackButtion() 
    {
        return null;
    }

    private JButton makeResetButton() {
        return null;
    }

    private JButton makeQuitButton() {
        return null;
    }

    private JButton makeLoadButton() {
        return null;
    }

    private JButton makeSaveButton() {
        return null;
    }

    private void makeBackSplash() 
    {
        Point p = screenPersentageLocation(.1, .1);
        Dimension d = screenPersentageDimensions(.8);
        this.panel = makeJPanel(p, d);
    }

    
}