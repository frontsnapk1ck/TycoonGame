package gui.screens;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Information");
        label.add(new JLabel("this is some pretty random text3"));
        panel.add(label);
        super.configureInformationBox(panel);
    }

    @Override
    protected void setButtonBox() 
    {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Buttons");
        label.add(new JLabel("this is some pretty random text2"));
        panel.add(label);
        super.configureButtonBox(panel);
    }

    @Override
    protected void setTitleBox() 
    {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Tycoon Game");
        label.add(new JLabel("this is some pretty random text1"));
        panel.add(label);
        super.configureTitleBox(panel);
    }


    
}