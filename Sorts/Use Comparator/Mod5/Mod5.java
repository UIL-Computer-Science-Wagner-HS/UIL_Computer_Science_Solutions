import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class Mod5 {

  static Comparator<Integer> comp = (a,b)->
    {if (a%5==0&&b%5!=0)
      return 1;
    else if(a%5!=0&&b%5==0)
      return -1;
    return a-b;
    };

  public static void main(String[] args) throws IOException{
    Scanner scan = new Scanner(new File("mod5.dat"));
    int noSets = scan.nextInt();
    
    while(noSets-->0){
      int numElts = scan.nextInt();
      ArrayList<Integer> list = new ArrayList();
      for(int i = 0; i<numElts; i++) {
       list.add(scan.nextInt());
      }

      list.sort(comp);
      for(int i:list)
      System.out.print(i+" ");
      System.out.println();
    }

  }

}
