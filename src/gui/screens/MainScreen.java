package gui.screens;

import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.BlankTriScreen;

public class MainScreen extends BlankTriScreen {

    public MainScreen(JFrame frame) 
    {
        super(frame);
        setButtonBox();
        setInformationBox();
        setTitleBox();
    }

    @Override
    protected void setInformationBox() 
    {
        JLabel label = new JLabel("Information");
        label.add(new JLabel("this is some pretty random text3"));
        this.panels.get(2).add(label);
    }

    @Override
    protected void setButtonBox() 
    {
        JLabel label = new JLabel("Buttons");
        label.add(new JLabel("this is some pretty random text2"));
        this.panels.get(1).add(label);
    }

    @Override
    protected void setTitleBox() 
    {
        JLabel label = new JLabel("Tycoon Game");
        label.add(new JLabel("this is some pretty random text1"));
        this.panels.get(0).add(label);
    }


    
}