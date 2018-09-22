import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	
	public static File	f1 = new File("2017.txt");
	public static int	playerCount;	
	public Player[] players = new Player[playerCount]; // NEED TO GET NUMBER OF PLAYERS BEFORE THIS
	
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
			makePlayer(unformatted, playerCount, curPlayerNum); // METHODS INSIDE OF METHODS IS NOT ALLOWED, MUST CHANGE
			curPlayerNum++;
			
		}
		stdin.close();
	}
	
	public static void makePlayer(String unformatted, int playerCount, int curPlayerNum) {
		String	formatted;
		String	firstName, lastName, team, position, skip;
		int		playerNum, posRank, totPnts;
		Scanner	s = new Scanner(unformatted);
		
		formatted = unformatted.replace('*','\\');			// Replace * with \ for formatting purposes
		s.useDelimiter("[\\s\\-\\.\\*\\\\?\\,\\+\\_\\@]+");
		players[curPlayerNum] = new Player();
		playerNum = s.nextInt();
		players[curPlayerNum].setFirstName(s.next());
		players[curPlayerNum].setLastName(s.next());
		skip = s.next();
		players[curPlayerNum].setTeam(s.next());
		System.out.println(players[curPlayerNum].getFirstName());
		System.out.println(players[curPlayerNum].getLastName());
		System.out.println(skip);
		System.out.println(players[curPlayerNum].getTeam());
		/*players[curPlayerNum].setLastName(s.next());
		skip	  	= s.next();
		players[curPlayerNum].setTeam(s.next());
		*/
		
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
