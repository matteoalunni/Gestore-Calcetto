import java.util.ArrayList;
import java.util.List;


public class Games {
	
	public List<Match> game = new ArrayList<Match>();
	
	public void addMatch(Team h, Team a){
		this.game.add(new Match(h,a));
	}

	public void removeMatch(int i){
		if(!this.game.isEmpty()) {
			if(this.game.size()> i){
				Match m = this.game.get(i);
				this.game.remove(m);
				System.out.println("E' stata eliminata la partita tra "+m.getHomeTeam().getTeamName()+" e " +m.getAwayTeam().getTeamName());
			}
			else System.out.println("La partita che si vuole eliminare non esiste.");
		} else System.out.println("Non ci sono partite da eliminare.");
	}
	
	public Match getMatch(int i){
		return this.game.get(i);
	}
	
	public void autoGames(){
		for(int i = 0; i < this.game.size(); i++){
			this.game.get(i).autoMatch();
		}
	}
	
}
