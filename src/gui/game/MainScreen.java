package gui.game;

import java.awt.Color;
import java.awt.Font;

import gui.framework.ScreenFramework;

/**
 * Class represents the main screen of the game with the three part layout
 * consistenting of a banner label across the top and two seperate screens split
 * down middle.
 */
public class MainScreen extends ScreenFramework {

	/** Amount of padding between components */
	private static final double RELATIVE_PAD_X = 0.01;
	private static final double RELATIVE_PAD_Y = 0.01;
	
	/** Title banner height relative to this screen */
	private static final double TITLE_RELATIVE_HEIGHT = 0.2;
	
	/** Manager screen size on left */
	private static final double MANAGER_RELATIVE_WIDTH = 0.66;
	
	/** Info screen size on right */
	private static final double INFO_RELATIVE_WIDTH = 0.33;
	
	
	
	/** Banner label across top of screen */
	private TitleBanner title;
	/** Right screen that holds game infoScreen */
	private InfoScreen infoScreen;
	/** Left screen with all managerScreen infoScreen */
	private ManagerScreen managerScreen;
	
	
	public MainScreen()
	{
		// Remove the layout managerScreen
		this.getPanel().setLayout( null );
		this.setBackground( new Color(200, 100, 40 ) );
		
		// Create the title banner across the top
		this.title = new TitleBanner();
		this.title.setFont( new Font( "Ariel", Font.BOLD, 20 ) );
		this.title.setText( "T y c o o n   G a m e" );
		this.title.setBackground( new Color( 50, 50, 50 ) );
		this.title.setForeground( new Color( 100, 220, 100 ) );
		this.getPanel().add( this.title );
		
		// Create the manager screen on left
		this.managerScreen = new ManagerScreen();
		this.managerScreen.setBackground( new Color( 134, 173, 134 ) );
		this.getPanel().add( this.managerScreen.getPanel() );

		// Create the info screen on right
		this.infoScreen = new InfoScreen();
		this.infoScreen.setBackground( new Color( 100, 220, 100 ) );
		this.getPanel().add( this.infoScreen.getPanel() );
	}

//=============================================================
//					RESIZING
//=============================================================
	
	/**
	 * 	Resizes the title banner and main game
	 * 	screen sections when the screen was
	 * 	resized.
	 */
	@Override protected void onScreenResize()
	{
		// Grab screen details
		int padLeft = this.getPanel().getInsets().left;
		int padRight = this.getPanel().getInsets().right;
		int padTop = this.getPanel().getInsets().top;
		int padBot = this.getPanel().getInsets().bottom;
		int myWidth = this.getWidth() - padLeft - padRight;
		int myHeight = this.getHeight() - padTop - padBot;
		int padX = (int)(myWidth * RELATIVE_PAD_X);
		int padY = (int)(myHeight * RELATIVE_PAD_Y);
		
		// Update the banner to fill entire screen
		int titleW = myWidth;
		int titleH = (int)(myHeight * TITLE_RELATIVE_HEIGHT);
		int titleX = (myWidth - titleW) / 2;
		int titleY = 0;
		this.title.setBounds( titleX, titleY, titleW, titleH );
		
		// Update manager screen on left
		int managerW = (int) ( myWidth * MANAGER_RELATIVE_WIDTH ) - padX / 2;
		int managerH = myHeight - ( titleH + padY );
		int managerX = 0;
		int managerY = myHeight - managerH;
		this.managerScreen.setBounds( managerX, managerY, managerW, managerH );
		
		// Update info screen on right size
		int infoW = (int) ( myWidth * INFO_RELATIVE_WIDTH ) - padX / 2;
		int infoH = managerH;
		int infoX = myWidth - infoW;
		int infoY = managerY;
		this.infoScreen.setBounds( infoX, infoY, infoW, infoH );
		
	}
	
}