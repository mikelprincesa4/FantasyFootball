import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	
	public static File	f1 			= new File("2017.txt");
	static Player[] 	players 	= new Player[];
	
	public static void main(String[] args) throws FileNotFoundException {
		String ignore1, ignore2, unformatted;
		Scanner stdin 		= new Scanner(f1);
		int	playerCount 	= countPlayers(f1);
		int curPlayerNum	= 0;
		
		
		ignore1 	= stdin.nextLine();		// Ignores first line of text (table labels in CSV)
		ignore2 	= stdin.nextLine();		// Ignores second line of text (table labels in CSV)
		ignore1 	= null;					// Free up memory
		ignore2 	= null;					// Free up memory
		unformatted = stdin.nextLine();
		
		while (stdin.hasNextLine()) {
			
			makePlayer(unformatted, playerCount, curPlayerNum);
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
