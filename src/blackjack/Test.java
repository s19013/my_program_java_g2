package blackjack;

public class Test {
	static MasterCards mc = new MasterCards();
	static Deck deck = new Deck();
	static Human h = new Human();
	static Com c = new Com();
	static Master m = new Master();
	public static void main(String[] args) {
		// mc.setUP();
		TestHumanTurn();
	}

	public static void TestShowCards(){
		mc.dbshowCards();
	}

	public static void TestGiveCard(){
		// ArrayList <String> box = new ArrayList<>();
		String [] box = mc.giveCard();
		for (String b:box ) {
			System.out.println(b);
		}
	}

	public static void TestShowCardsSize(){
		mc.dbShowCardsSize();
	}

	public static void TestShowPlayerDeck(){
		deck.getCard(mc.giveCard());
		deck.getCard(mc.giveCard());
		deck.dbshowDeck();
	}

	public static void TestPlayerdeckSum(){
		System.out.println(deck.sum());
	}

	public static void TestPlayerdeckBurst(){
		System.out.println(deck.burst());
	}

	public static void TestPlayerdeckStream(){
		TestShowPlayerDeck();
		TestPlayerdeckSum();
		TestPlayerdeckBurst();
	}

	public static void TestCheckAce(){
		String[] box = {"S","A","1"};
		deck.getCard(box);
		System.out.println(deck.CheckAce());
	}

	public static void TestCheckJQK(){
		String[] box = {"S","J","10"};
		deck.getCard(box);
		System.out.println(deck.CheckJQK());
	}

	public static void TestBlackJack(){
		String[] box = {"S","J","10"};
		String[] box2 = {"S","A","1"};
		deck.getCard(box);
		deck.getCard(box2);
		System.out.println(deck.BlackJack());
	}

	public static void TestPlayerChoice(){
		String[] box2 = {"S","A","1"};
		h.getCard(box2);
		h.getCard(mc.giveCard());
		h.Screan();
	}

	public static  void TestComChoice(){
		c.getCard(mc.giveCard());
		c.getCard(mc.giveCard());
		c.getCard(mc.giveCard());
		c.Screan();
		boolean a = c.Choice();
		System.out.println(a);
	}

	public static void TestHumanTurn(){
		m.Reset();
		m.First();
		m.HumanTurn();
	}
}
