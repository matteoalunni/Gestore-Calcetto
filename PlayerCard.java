
public class PlayerCard {

	public int match;
	public int goal;
	public int redCard;
	public int yellowCard;
	
	public PlayerCard(){
		this.match = 0;
		this.goal = 0;
		this.redCard = 0;
		this.yellowCard = 0;
	}
	
	public void addGoal(int s){
		this.goal+= s;
	}
	
	public void addMatch(){
		this.match++;
	}
	
	public void addRedCard(){
		this.redCard++;
	}
	
	public void addYellowCard(){
		this.yellowCard++;
	}
	
}
