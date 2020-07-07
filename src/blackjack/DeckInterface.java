package blackjack;

public interface DeckInterface {
	  public void Reset();
	  public void getCard(String[] arg);
	  public boolean burst();
	  public int sum();
	  public boolean CheckAce();
	  public boolean CheckJQK();
	  public boolean BlackJack();
	  public void Screan();
	  public void dbshowDeck();
	}
