import java.util.Random;


public class Match {

	private Team home;
	private Team away;
	private int h;
	private int a;
	private Team winner;
	private Team loser;
	
	public Match(Team t1, Team t2){
		this.home = t1;
		this.away = t2;
	}
	
	public void addResult(int h, int a){
		this.h = h;
		this.a = a;
	}
	
	public String getResult(){
		String r = new String (this.home.getTeamName()+" - "+this.away.getTeamName()+" : "+this.h+" - "+this.a);
		return r;
	}
	
	public Team getHomeTeam(){
		return this.home;
	}
	
	public Team getAwayTeam(){
		return this.away;
	}
	
	public int getResultHome(){
		return this.h;
	}
	
	public int getResultAway(){
		return this.a;
	}
	
	public Team getTeamWin(){
		if(this.h > this.a) this.winner = this.home;
		else this.winner = this.away;
		return this.winner;
	}
	
	public Team getTeamLoser(){
		if(this.h < this.a) this.loser = this.home;
		else this.loser = this.away;
		return this.loser;
	}
	
	public void autoMatch(){
		int home = 0;
		int away = 0;
		while(home == away){
			home = random(10);
			away = random(10);
			addResult(home, away);
			autoSetGoal(this.home,home);
			autoSetGoal(this.away,away);
		}
	}
	public void autoSetGoal(Team t, int g){
		for(int i = 0; i < 15; i++){
			int score = random(g);
			if(score > 0){
				t.getPlayers().get(i).getCard().addGoal(score);
				System.out.println("Sono stati aggiunti "+score+" goal al giocatore "+t.getPlayers().get(i).getName()+
									" della squadra "+t.getTeamName()+".");
				g -= score;
			}		
		}
	}
	
	public int random(int max){
		Random rand = new Random();
		int a = 0;
		int b = max;
		int c = ((b-a)+1);
		int result = rand.nextInt(c)+a;
		return result;
	}
}
