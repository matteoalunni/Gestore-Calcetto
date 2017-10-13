
public class Player {

	public String name;
	public String surname;
	public int age;
	public PlayerCard card;
	
	public Player(String n, String c, int e){
		this.name = n;
		this.surname = c;
		this.age = e;
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
