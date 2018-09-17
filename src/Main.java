import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	
	public static File	f1 = new File("2017.txt");
	public static int	playerCount;	
	public static List<Player> players = new ArrayList<Player>();
	
	public static void main(String[] args) throws FileNotFoundException {
		playerCount = countPlayers(f1);
		readStats(f1);
	}
	
	public static void readStats(File fileName) throws FileNotFoundException {
		Scanner stdin 	= new Scanner(fileName);
		String	ignore1 = stdin.nextLine();		// Ignores first line of text (table labels in CSV)
		String	ignore2 = stdin.nextLine();		// Ignores second line of text (table labels in CSV)
				ignore1 = null;					// Free up memory
				ignore2 = null;					// Free up memory
		String	unformatted;
		int		curPlayerNum = 0;
		
		while (stdin.hasNextLine()) {
			unformatted = stdin.nextLine();
			makePlayer(unformatted, playerCount);
			
		}
		stdin.close();
	}
	
	public static void makePlayer(String unformatted, int playerCount) {
		String	formatted;
		String	firstName, lastName, team, position;
		int		playerNum, posRank, totPnts;
		Scanner	s = new Scanner(unformatted);
		s.split("[\\s\\-\\.\\'\\?\\,\\_\\@]+");
		formatted = unformatted.replace('*','\\');			// Replace * with \ for formatting purposes
		playerNum = s.nextInt();
		firstName = s.next();
		lastName  = s.next();
		
		//players[curNum] = new Player(); // LEFT OFF HERE. BEGIN PARSING STRING TO POPULATE PLAYER INFORMATION 	
		
	}
	
	public static int countPlayers(File fileName) throws FileNotFoundException {
		int 	lineCount 	= 0;
		Scanner stdin 		= new Scanner(fileName);
		while(stdin.hasNextLine()) {
			lineCount++;
			stdin.nextLine();
		}
		stdin.close();
		return lineCount-2;
	}

}
