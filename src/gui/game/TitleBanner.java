package gui.game;

import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JLabel;


/**
 * 	This represents the banner label that goes across the
 * 	top of the main window. 
 */
public class TitleBanner extends JLabel {

	/** Font size details */
	private static final double RELATIVE_FONT_HEIGHT = 0.35;
	
	
	
	public TitleBanner()
	{
		// Allow color
		this.setOpaque( true );
		
		// Keep text centered
		this.setHorizontalAlignment( JLabel.CENTER);
		this.setVerticalAlignment( JLabel.CENTER);
				
		// Handle updates when resized
		this.addComponentListener( new ComponentAdapter() {
			@Override public void componentResized( ComponentEvent e ) {
				onResize();
			}
		});
	}

//=============================================================
//					RESIZING
//=============================================================
	
	/**
	 * 	Handles updating the font and layout of this banner
	 * 	when its size has been changed.
	 */
	private void onResize()
	{
		// Grab new size details
		int myHeight = this.getHeight();
		int targetH = (int)(myHeight * RELATIVE_FONT_HEIGHT);
		
		// Get old Font details
		Font oldFont = this.getFont();
		
		// Create new font
		this.setFont( new Font(
				oldFont.getName(), oldFont.getStyle(), targetH
			) );
	}
}
