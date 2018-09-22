import java.util.ArrayList;

public class Player {
	private String  firstName, lastName;					//name
	private String 	team;									//team
	private String 	position;								//position
	private int		posRank;								//position rank
	private int		totPts;									//total fantasy points during season
	
	/*public Player(String firstName, String lastName, String team, String position, int posRank, int totPts) {
		this.firstName 	= firstName;
		this.lastName	= lastName;
		this.team		= team;
		this.position	= position;
		this.posRank	= posRank;
		this.totPts		= totPts;
	}*/

	public String getFirstName() {
		return firstName;
	}	
	public void setFirstName(String first) {
		this.firstName = first;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String last) {
		this.lastName = last;
	}
	
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public int getPosRank() {
		return posRank;
	}
	public void setPosRank(int posRank) {
		this.posRank = posRank;
	}
	
	public int getTotPts() {
		return totPts;
	}
	public void setTotPts(int totPts) {
		this.totPts = totPts;
	}
	
}
