import java.util.ArrayList;
import java.util.List;


public abstract class TournamentAbstract {

	public List<Team> teams = new ArrayList<Team> ();
	public List<Integer> awards = new ArrayList<Integer>();
	public List<Team> quarter = new ArrayList<Team> ();
	public List<Team> semi = new ArrayList<Team> ();
	public List<Team> finals = new ArrayList<Team> ();
	public List<Games> calendar = new ArrayList<Games>();
	
	
	public void addGame(int day, Team h, Team a){
		this.calendar.add(new Games());
		this.calendar.get(day).addMatch(h, a);
	}
	
	public void addTeam(Team t){
		if(this.teams.contains(t))
			System.out.println("E' già presente una squadra chiamata "+t.getTeamName());
		else
			this.teams.add(t);
	}
	
	public void removeTeam(Team t){
		this.teams.remove(t);
		System.out.println("E' stata rimossa dal torneo la squadra "+t.getTeamName());
	}
	
	public void addResult(int day, int i, int h, int a){
		this.calendar.get(day).getMatch(i).addResult(h,a);
	}
	
	public String getResult(int day, int i){
		return this.calendar.get(day).getMatch(i).getResult();
	}
	
	public void removeGame(int day, int i){
		if(this.calendar.size() > day)
			this.calendar.get(day).removeMatch(i);
		else 
			System.out.println("Non esiste la giornata nel calendario che si stà cercando di eliminare.");
	}
	
}
