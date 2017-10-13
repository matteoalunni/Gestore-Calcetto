
public class Match {

	public Team home;
	public Team away;
	public int h;
	public int a;
	
	public Match(Team t1, Team t2){
		this.home = t1;
		this.away = t2;
	}
	
	public void addResult(int h, int a){
		this.h = h;
		this.a = a;
	}
	
	public String getResult(){
		String r = new String (this.home.name+" - "+this.away.name+" : "+this.h+" - "+this.a);
		return r;
	}
}
