package gui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Screen{

    private JFrame frame;

    public Screen (JFrame frame)
    {
        if (this.frame == null)
            this.frame = frame;
    }

    public JPanel makeJPanel ( Point p , Dimension d )
    {
        Rectangle r = new Rectangle( p , d );
        
        JPanel panel = new JPanel();
        panel.setBounds(r);
        
        return panel;
    }

    public Point screenPersentageLocation (double xPercent , double yPercent )
    {
        int x = (int) this.frame.getSize().getWidth();
        int y = (int) this.frame.getSize().getHeight();

        int newX = (int) (x * xPercent);
        int newY = (int) (y * yPercent);

        return new Point (newX , newY);
    }

    public Dimension screenPersentageDimensions ( double xPercent , double yPercent)
    {
        int x = (int) this.frame.getSize().getWidth();
        int y = (int) this.frame.getSize().getHeight();

        int newX = (int) (x * xPercent);
        int newY = (int) (y * yPercent);

        Dimension d = new Dimension(newX ,newY);
        System.err.println(d);
        return d;
    }

    public Dimension screenPersentageDimensions ( double percent)
    {
        int x = (int) this.frame.getSize().getWidth();
        int y = (int) this.frame.getSize().getHeight();

        int newX = (int) (x * percent);
        int newY = (int) (y * percent);

        return new Dimension(newX ,newY);
    }

    public Dimension scale ( Dimension d , double percent )
    {
        int x = (int) d.getSize().getWidth();
        int y = (int) d.getSize().getHeight();

        int newX = (int) (x * percent);
        int newY = (int) (y * percent);

        return new Dimension(newX ,newY);
    }

    public JFrame getFrame() 
    {
		return this.frame;
    }
    
    public Dimension getSize ()
    {
        return this.frame.getSize();
    }



}  