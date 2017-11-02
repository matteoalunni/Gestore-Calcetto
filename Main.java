
public class Main {

	
	public static void main(String[] args){
		
		Tournament t = new Tournament(true, 16);
		
		t.autoTournament();
		
		System.out.println(t.getResult(0, 0));
		System.out.println(t.getResult(0, 1));
		System.out.println(t.getResult(0, 2));
		System.out.println(t.getResult(0, 3));
		System.out.println(t.getResult(1, 1));
		System.out.println(t.getResult(1, 0));
		System.out.println(t.getResult(2, 0));
		System.out.println(t.getResult(2, 1));
		System.out.println(t.getResult(3, 0));
		
		System.out.println(t.getResultTournament());
		
	}
	
}
