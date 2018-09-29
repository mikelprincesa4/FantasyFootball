import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	
	public static File				f1 		= new File("2017.txt");
	static Player[] 			players;
	
	public static void main(String[] args) throws FileNotFoundException {
		String ignore1, ignore2, unformatted;
		Scanner stdin 		= new Scanner(f1);
		int	playerCount 	= countPlayers(f1);
		int curPlayerNum	= 0;
		players = new Player[playerCount];
		
		
		ignore1 	= stdin.nextLine();		// Ignores first line of text (table labels in CSV)
		ignore2 	= stdin.nextLine();		// Ignores second line of text (table labels in CSV)
		ignore1 	= null;					// Free up memory
		ignore2 	= null;					// Free up memory
		unformatted = stdin.nextLine();
		
		while (stdin.hasNextLine()) {		// Populate Player[]
			makePlayer(unformatted, playerCount, curPlayerNum);
			unformatted = stdin.nextLine();
			curPlayerNum++;	
		}
		stdin.close();
		
	}

	
	public static void makePlayer(String unformatted, int playerCount, int curPlayerNum) {
		String	formatted;
		String	firstName, lastName, team, position, skip, posTemp;
		int		playerNum, posRank;
		Scanner	s = new Scanner(unformatted);
		
		formatted = unformatted.replace('*','\\');			// Replace * with \ for formatting purposes
		s.useDelimiter("[\\s\\*\\\\?\\,\\+\\_\\@]+");
		playerNum 		= s.nextInt();
		firstName 		= s.next();
		lastName  		= s.next();
		skip 			= s.next();
		team			= s.next();
		posTemp			= s.next();
		if (posTemp == "") {								// Correct when player has no position listed
			position	= "n/a";
		} else {
			position	= posTemp;
		}
		s.useDelimiter(",");
		for (int i=0; i < 24; i++) {
			skip 	= s.next();
		}
		posRank		= s.nextInt();
		players[curPlayerNum] = new Player (firstName,lastName,team, position, posRank);
		
		System.out.println(players[curPlayerNum].getFirstName());
		System.out.println(players[curPlayerNum].getLastName());
		System.out.println(players[curPlayerNum].getTeam());
		System.out.println(players[curPlayerNum].getPosition());
		System.out.println(players[curPlayerNum].getPosRank());
	}
	
	public static int countPlayers(File fileName) throws FileNotFoundException{
		int 	lineCount 	= 0;
		Scanner stdin = new Scanner(fileName);
		
		while(stdin.hasNextLine()) {
			lineCount++;
			stdin.nextLine();
		}
		stdin.close();
		return lineCount-2;
	}

}
