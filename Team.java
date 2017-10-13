import java.util.ArrayList;
import java.util.List;


public class Team {

	public String name;
	public List<Player> players = new ArrayList<Player>();
	
	public Team(String n){
		this.name = n;		
	}
	
	public String getTeamName(){
		return this.name;
	}
	
	public List<Player> getPlayers(){
		return this.players;
	}
	
	public void addPlayer(Player p){
		this.players.add(p);
	}
	
}
