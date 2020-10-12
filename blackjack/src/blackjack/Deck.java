package blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck implements DeckInterface {
	private ArrayList<ArrayList<String>> Cards = new ArrayList<ArrayList<String>>();

	@Override
	public void Reset(){
		Cards.clear();
	}

	@Override
	public void getCard(String[] arg) {
		ArrayList <String> box = new ArrayList<>();
		for (String s:arg ) {
			box.add(s);
		}
		Cards.add(box);
	}

	@Override
	public boolean burst() {
		return sum()>21;
	}

	@Override
	public int sum() {
		int result = 0;
		String s ="";
		for (int i = 0;i<Cards.size() ;i++) {
			s=Cards.get(i).get(2);
			result += Integer.parseInt(s);
		}
		return result;
	}

	public int AceSum(){
		int result = sum() + 10;
		return result;
	}

	@Override
	public boolean CheckAce() {
		ArrayList <String> box = new ArrayList<>();
		for (int i=0;i<Cards.size() ;i++) {
			box.add(Cards.get(i).get(1));
		}
		return burst()==false && box.contains("A");
	}

	@Override
	public boolean CheckJQK() {
		ArrayList <String> box = new ArrayList<>();
		for (int i=0;i<Cards.size() ;i++) {
			box.add(Cards.get(i).get(1));
		}
		return box.contains("J") || box.contains("Q") || box.contains("K");
	}

	@Override
	public boolean BlackJack() {
		return CheckAce()==true && CheckJQK()==true && burst()==false ;
	}

	@Override
	public void Screan(){
		ArrayList <String> box = new ArrayList<>();
		for (int i =0 ;i<Cards.size() ;i++) {
			box.add(Cards.get(i).get(0)+Cards.get(i).get(1));
		}
		System.out.println("あなたの手札"+box);
		if (AceSum()<22 && CheckAce()==true) {
			System.out.println("合計:"+sum());
			System.out.println("Aを11として考えると:"+AceSum());
		}
		else {
			System.out.println("合計:"+sum());
		}
	}

	public int giveResult(){
		if (AceSum()<22 && CheckAce()==true){
			return AceSum();
		}
		else {
			return sum();
		}
	}

	@Override
	public void dbshowDeck() {
		System.out.println(Cards);
	}

}
