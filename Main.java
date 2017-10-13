
public class Main {

	private static Tournament t = new Tournament();
	private static Player p = new Player("Mat", "Alu", 26);
	private static Team team1 = new Team("OCB");
	private static Team team2 = new Team("ASD");
	private static Tournament t1 = new Tournament();
	
	public static void main(String[] args){
		team1.addPlayer(p);
		t.addGame(0, team1, team2);
		t.addResult(0, 0, 3, 1);
		System.out.println(t.getResult(0, 0));
		t.removeGame(0, 1);
		t.removeGame(0, 0);
		t.removeGame(0, 0);
		t.addTeam(team1);
		t.addTeam(team2);
		t.removeTeam(team2);
		t.addTeam(team1);
		t.addTeam(team2);
		t.addGame(1, team2, team1);
		t.addResult(1, 0, 0, 0);
		System.out.println(t.getResult(1, 0));
		t.removeGame(2, 0);
		t.removeGame(1, 0);
		t1.addGame(0, team2, team1);
		t1.addGame(0, team2, team1);
		
		
	}
	
}
