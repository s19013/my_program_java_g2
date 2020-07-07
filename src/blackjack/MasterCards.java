package blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class MasterCards {
  private String [] Marks = {"S","C","H","D"};
  private String [] SMarks = {"J","Q","K"};
  private ArrayList<ArrayList<String>> Cards = new ArrayList<ArrayList<String>>();

  public void setUP(){
    for (String m: Marks) {
      for (int i=1;i<11 ;i++ ) {
        ArrayList <String> box = new ArrayList<>();
        box.add(m);
        if (i==1) {
          box.add("A");
        }
        else {
          box.add(String.valueOf(i));
        }
        box.add(String.valueOf(i));
        Cards.add(box);
      }
    }

    for (String m:Marks ) {
      for (String s :SMarks) {
        ArrayList <String> box = new ArrayList<>();
        Collections.addAll(box, m,s,"10");
        Cards.add(box);
      }
    }
    Collections.shuffle(Cards);
  }

  public String[] giveCard(){
    String[] box = new String[3];
    for (int i=0; i<3;i++) {
      box [i] = Cards.get(0).get(i);
    }
    Cards.remove(0);
    return box;
  }

  public void dbshowCards(){
    System.out.println(Cards);
  }

  public void dbShowCardsSize(){
    System.out.println(Cards.size());
  }
}