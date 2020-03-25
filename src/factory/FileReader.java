package factory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 	Handles reading in files and returning the contents
 * 	in different forms.
 */
public class FileReader {	
	
	/**
	 * 	Reads in the text file at the given file location
	 * 	and returns the contents of each line in a list
	 * 	of strings.
	 */
	public static List<String> readTextFile( String filename )
	{
		// If unable to open file at given file path,
		//	then an exception will be thrown...
		try {
			// (1) Create file
			File file = new File( filename );
			
			// (2) Scanner for the file
			Scanner scanner = new Scanner( file );
			
			// (3) Read each line in
			List<String> data = new ArrayList<String>();
			while ( scanner.hasNextLine() )
			{
				String line = scanner.nextLine();
				data.add( line );
			}
			
			// (4) Job done
			scanner.close();
			return data;
		} catch (FileNotFoundException e) {
			System.out.println( "Error occured when loading file: " + filename );
			return null;
		}
		
	}
	
}