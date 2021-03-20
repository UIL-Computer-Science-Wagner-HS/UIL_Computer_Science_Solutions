import java.io.*;
import java.util.*;

public class Sharon {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(new File("sharon.dat"));

		int numLoops = scan.nextInt();
		scan.nextLine();
		while(numLoops-- > 0) {
			
			String[] dropout1 = scan.nextLine().split(" ");
			
			 ArrayList<String> list = new ArrayList<String>();
			 int dice = Integer.parseInt(dropout1[0]);
			 for(int i = 2; i < dropout1.length; i++) {
				 list.add(dropout1[i]);
			 }
			boolean winnerFound = false;
			while(winnerFound = false) {
				int reset = Integer.parseInt(list.get(dice+1));
				list.remove(list.get(dice));
				
				//for(int i = )
				
				
				
			}
			
		
			
		}
	}

}
