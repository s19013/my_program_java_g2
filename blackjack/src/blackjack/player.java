package blackjack;

public abstract class player {
	  Deck deck =new Deck();

	  public void Reset(){
	    deck.Reset();
	  }

	  public void getCard(String[] arg){
	    deck.getCard(arg);
	  }

	  public boolean burst(){
	    return deck.burst();
	  }

	  public int Sum(){
	    return deck.sum();
	  }

	  public int AceSum(){
	    return deck.AceSum();
	  }

	  public boolean CheckAce(){
	    return deck.CheckAce();
	  }

	  public boolean CheckJQK(){
	    return deck.CheckJQK();
	  }

	  public boolean BlackJack(){
	    return deck.BlackJack();
	  }

	  public void Screan(){
	    deck.Screan();
	  }

	  public int giveResult(){
	    return deck.giveResult();
	  }

	  public void dbshowDeck(){
	    deck.dbshowDeck();
	  }

	  // abstract boolean Choice();

	}
