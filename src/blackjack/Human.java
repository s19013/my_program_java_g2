package blackjack;


import java.util.Scanner;

public class Human extends player {
	private boolean Checker = true;
  Scanner scan = new Scanner(System.in);
  String s;


	public boolean Choice() {
		while (Checker) {
			Screan();
	  	System.out.println("HIT or STAND:");
	  	s = scan.nextLine();
	  	s=s.toLowerCase();
	  	if (s.equals("h") || s.equals("hit") ||s.equals("s") || s.equals("stand")) {
	    	Checker=false;
	  	}
	  	else {
	    	System.out.println("入力し直してください");
	  	}
		}
		return s.equals("h") || s.equals("hit");
	}

}
