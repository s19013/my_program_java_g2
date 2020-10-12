package blackjack;


import java.util.Scanner;

public class Human extends player {
	
  Scanner scan = new Scanner(System.in);
  String s;
  boolean Checker = true;

  public boolean Choice(){
	while (true) {
		Screan();
		System.out.println("HIT or STAND(h/s):");
		s = scan.nextLine();
		s=s.toLowerCase();
		if (s.equals("h") || s.equals("hit")||s.equals("s") || s.equals("stand")) {
			break;
		}
		else{
			System.out.println("いれなおし");
		}
	  }
	  return	s.equals("h") || s.equals("hit");
  }
}
