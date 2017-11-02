
public class Player {

	private String name;
	private String surname;
	private int age;
	private PlayerCard card;
	
	public Player(String n, String c, int a){
		this.name = n;
		this.surname = c;
		this.age = a;
		this.card = new PlayerCard();
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getSurname(){
		return this.surname;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public PlayerCard getCard(){
		return this.card;
	}
	
}
