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
  String input;
  boolean Checker = true;

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
    boolean choice = h.Choice();
    while (true) {
      if (choice==true) {
        h.getCard(mc.giveCard());
        if (h.burst()==true) {
          h.Screan();
          System.out.println("バーストしたのでもう引けません");
          break;
        }
        choice=h.Choice();
      }
      else{
        break;
      }
    }
  }

// 上手く動かなかった
  public void ComTurn(){
    while (true) {
      if (c.AceSum()==21) {
        break;
      }
      boolean choice= c.Choice();
      if (choice == true) {
        c.getCard(mc.giveCard());
        if (c.burst()==true) {
          break;
        }
        choice=c.Choice();
      }
      else{
        break;
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
    else if (c.burst()==true) {
      System.out.println("コンピューターがバーストしました");
      Canbattle = false;
    }
    else{
      Canbattle=true;
    }
  }

  public void battle(){
    int hr = h.giveResult();
    int cr = c.giveResult();
    System.out.println("");
    if (h.BlackJack()==true) {
      if (c.BlackJack()==true) {
        System.out.println("引き分け"); 
      }
      else{
        System.out.println("あなた："+hr+"(bj)"+" "+"コンピューター："+cr);
        System.out.println("あなたの勝ち");
      }
    } 
    else if(c.BlackJack()==true) {
      System.out.println("コンピュータの勝ち");
      System.out.println("あなた："+hr+" "+"コンピューター："+cr+"(bj)");
    }
    else {
      System.out.println("あなた："+hr+" "+"コンピューター："+cr);
      if (hr>cr) {
        System.out.println("あなたの勝ち");
      } else if (hr<cr) {
        System.out.println("コンピュータの勝ち");
      } else {
        System.out.println("引き分け");
      }
    }
  }

  public boolean Retry(){
    boolean RChecker = true;
    while(RChecker){
      System.out.println("");
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
    while (playing) {
      Reset();
      First();
      HumanTurn();
      ComTurn();
      burst();
      if (Canbattle == true) {
        battle();
      }
      playing=Retry();
    }
  }



  public void dbGiveCardToHuman() {
    String[] box = {"S","J","10"};
    String[] box2 = {"S","A","1"};
    h.getCard(box);
    h.getCard(box2);
  }

  public void dbGiveCardToCom() {
    String[] box = {"S","9","9"};
    String[] box2 = {"S","2","2"};
    c.getCard(box);
    c.getCard(box2);
  }

}