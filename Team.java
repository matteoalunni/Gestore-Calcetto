import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Team {

	private String name;
	private List<Player> players = new ArrayList<Player>();
	private int gamesPlayed;
	private int gamesWin;
	private int tournamentWin;
	
	public Team(String n){
		this.name = n;	
		this.gamesPlayed = 0;
		this.gamesWin = 0;
		this.tournamentWin = 0;
		autoPlayer();
		
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
	 
	public void addGoals(List<Player> p, int s){
		for(Player pl : p){
			pl.getCard().addGoal(s);
			System.out.println("Sono stati aggiunti "+s+" goal al giocatore "+pl.getName()+" della squadra "+this.getTeamName()+".");
		}
	}

	public int gamesPlayed(){
		return this.gamesPlayed;
	}
	
	public void addGamesPlayed(){
		this.gamesPlayed++;
	}
	
	public int gamesWin(){
		return this.gamesWin;
	}
	
	public void addGamesWin(){
		this.gamesWin++;
	}
	
	public int tournamentWin(){
		return this.tournamentWin;
	}
	
	public void addTournamentWin(){
		this.tournamentWin++;
	}
	
	public void autoPlayer() {
		/**
		 *  Il 15 indica che il numero di giocatori per squadra è di 15.
		 */
		for(int i = 0; i<15; i++){
			Random rand = new Random();
			int a = 18;
			int b = 40;
			int c = ((b-a)+1);
			int autoAge = rand.nextInt(c)+a;
			Player pl = new Player("Name "+i, "Surname "+i, autoAge);
			this.players.add(pl);
		}
	}
	
}
