package blackjack;

import java.util.Scanner;

public class Master {
  boolean HTanswer = true;
  Scanner scan = new Scanner(System.in);
  boolean Canbattle = true;
  boolean playing = true;
  MasterCards mc = new MasterCards();
  Human h = new Human();
  Com c = new Com();
  String s;

  public void Reset(){
    mc.setUP();
    h.Reset();
    c.Reset();
  }

  public void First(){
    h.getCard(mc.giveCard());
    h.getCard(mc.giveCard());
    c.getCard(mc.giveCard());
    c.getCard(mc.giveCard());
    // mc.dbShowCardsSize();
  }

  public void HumanTurn(){
    while(true){
      HTanswer=h.Choice();
      if (HTanswer==true) {
        h.getCard(mc.giveCard());
        if (h.burst()==true) {
          h.Screan();
          System.out.println("バーストしたのでもう引けません");
          break;
        }
      }
      else {
        break;
      }
    }
  }

  public void ComTurn(){
    if (c.Choice()==true) {
      c.getCard(mc.giveCard());
      if (c.burst() != true) {
        ComTurn();
      }
    }
  }

  public void burst(){
    if (h.burst()==true) {
      if (c.burst()==true) {
        System.out.println("両者共にバーストしました");
      }
      else {
        System.out.println("あなたはバーストしました");
      }
      Canbattle = false;
    }
    else {
      System.out.println("コンピューターがバーストしました");
      Canbattle = false;
    }
  }

  public void battle(){
    int hr = h.giveResult();
    int cr = c.giveResult();
    System.out.println("あなた："+hr+" "+"コンピューター："+cr);
    if (hr>cr) {
      System.out.println("あなたの勝ち");
    }
    else if (hr<cr) {
      System.out.println("コンピュータの勝ち");
    }
    else {
      System.out.println("引き分け");
    }
  }

  public boolean Retry(){
    boolean RChecker = true;
    while(RChecker){
      System.out.println("retry? y/n");
      s = scan.nextLine();
      s=s.toLowerCase();
      if (s.equals("y") || s.equals("yes") ||s.equals("n") || s.equals("no")) {
	    	RChecker=false;
	  	}
	  	else {
	    	System.out.println("入力し直してください");
	  	}
    }
    return s.equals("y") || s.equals("yes");
  }


  public void game(){
    Reset();
    First();
    HumanTurn();
    ComTurn();
    burst();
    if (Canbattle == true) {
      battle();
    }
  }

  public void A(){
    while(playing){
      game();
      playing=Retry();
    }
  }
}