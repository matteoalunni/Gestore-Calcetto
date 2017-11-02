import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Tournament {

	public List<Team> teams = new ArrayList<Team> ();
	public List<Team> currentTeams = new ArrayList<Team> ();
	public int[] awards;
	public List<Team> quarter = new ArrayList<Team> ();
	public List<Team> semi = new ArrayList<Team> ();
	public List<Team> finals = new ArrayList<Team> ();
	public Stack<Team> finalTeam = new Stack<Team> ();
	public List<Games> calendar = new ArrayList<Games>();
	
	public Tournament(boolean type, int size){
		if(!type) this.awards = new int[] {600,400,200};
		else this.awards = new int[] {1400,800,400};
        
		double exp = (Math.log(size)/Math.log(2));
		if(exp != (int)exp) {
			System.out.println("Il numero di squadre selezionate non sono corrette.");
			System.exit(0);
		}
		autoTeam(size);
		this.currentTeams = this.teams;
		switch(this.currentTeams.size()){
			case 8:
				this.quarter = this.currentTeams;
			case 4:
				this.semi = this.currentTeams;
			case 2:
				this.finals = this.currentTeams;
		}
	}
	
	public void addGame(int day, Team h, Team a){
		this.calendar.add(new Games());
		this.calendar.get(day).addMatch(h, a);
	}
	
	public void addTeam(Team t){
		if(this.teams.contains(t))
			System.out.println("E' gia presente una squadra chiamata "+t.getTeamName());
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
			System.out.println("Non esiste la giornata nel calendario che si sta cercando di eliminare.");
	}
	
	public List<Team> getTeams(){
		return this.teams;
	}
	
	public String getResultTournament(){
		String r = "";
		for(int i = 0; i < 3; i++){
			r += "La squadra "+this.finalTeam.pop().getTeamName()+ " è arrivata "+ (i+1) +"° e vince il premio di "+this.awards[i]+".\n";
		}
		return r;
	}
		
	private void autoTeam(int size) {
		for(int i =0; i < size; i++){
			Team t = new Team("Team "+i);
			this.teams.add(t);
			t.autoPlayer();			
		}
	}
	
	private void autoCalendar(int day){
		List<Team> temp = new ArrayList<Team> ();
		temp = this.currentTeams;
		for(int i = 0; i < this.currentTeams.size(); i +=2){
			this.calendar.add(new Games());
			this.calendar.get(day).addMatch(temp.get(i), temp.get(i+1));
		}
	}
	
	private void autoPhase(int day){
		this.calendar.get(day).autoGames();
		switch(this.currentTeams.size()){
			case 4:
				playSemiFinal(day);
				break;
			case 2:
				playFinals(day);
				break;
			default :
				nextPhase(day);
				break;
		}	
	}
	
	private void nextPhase(int day){
		int s = this.calendar.get(day).game.size();
		for(int i = 0; i < s; i++){
			Team t = this.calendar.get(day).getMatch(i).getTeamLoser();
			this.currentTeams.remove(t);
		}
		switch(this.currentTeams.size()){
		case 8:
			this.quarter = this.currentTeams;
			break;
		case 4:
			this.semi = this.currentTeams;
			break;
		}	
	}
	
	private void playSemiFinal(int day){
		List<Team> tft = new ArrayList<Team>();
		Match tf;
		Team tr1;
		Team tr2;
		int s = this.calendar.get(day).game.size();
		for(int i = 0; i < s; i++){
			Team t = this.calendar.get(day).getMatch(i).getTeamLoser();
			this.currentTeams.remove(t);
			tft.add(t);
		}
		tr1 = tft.get(0);
		tr2 = tft.get(1);
		tf = new Match(tr1, tr2);
		tf.autoMatch();
		this.finalTeam.push(tf.getTeamWin());
	}
	
	private void playFinals(int day){
		Team tl = this.calendar.get(day).getMatch(0).getTeamLoser();
		Team tw = this.calendar.get(day).getMatch(0).getTeamWin();
			this.currentTeams.remove(tl);
			this.finalTeam.push(tl);
			this.finalTeam.push(tw);
		this.finals = this.currentTeams;
	}
	
	public void autoTournament(){
		int s = (int)(Math.log(this.teams.size())/Math.log(2));
		for(int i = 0; i < s; i++){
			autoCalendar(i);
			autoPhase(i);
		}
	}

}
