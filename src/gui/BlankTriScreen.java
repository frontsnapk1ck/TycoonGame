package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;


public abstract class BlankTriScreen extends Screen {

    protected List<JPanel> panels;

    protected abstract void setInformationBox ();
    protected abstract void setButtonBox ();
    protected abstract void setTitleBox ();

    public BlankTriScreen(JFrame frame) 
    {
        super(frame);
        this.panels = new ArrayList<JPanel>();
        this.create();
        this.addToFrame (frame , this.panels);
    }

    @Override
    protected void create() 
    {
        panels.add( makeTitleBox());
        panels.add( makeButtonBox());
        panels.add( makeInformationBox());
    }

    protected JPanel makeInformationBox() 
    {
        Point p = screenPersentageLocation(.05, .2);
        Dimension d = screenPersentageDimensions(.6 , .7);
        JPanel panel =  makeJPanel(p, d);
        panel.setBackground(new Color( 82 , 234 , 12));
        return panel;
    }

    protected JPanel makeButtonBox() 
    {
        Point p = screenPersentageLocation(.7, .2);
        Dimension d = screenPersentageDimensions(.25 , .7);
        JPanel panel =  makeJPanel(p, d);
        panel.setBackground(new Color( 45 , 64 , 76));
        return panel;    
    }

    protected JPanel makeTitleBox() 
    {
        Point p = screenPersentageLocation(.05, .05);
        Dimension d = screenPersentageDimensions( .9 , .1);
        JPanel panel =  makeJPanel(p, d);
        panel.setBackground(new Color( 234 , 121 , 34));
        return panel;    
    }
    
}