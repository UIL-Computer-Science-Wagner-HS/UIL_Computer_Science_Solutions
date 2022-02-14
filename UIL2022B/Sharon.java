import java.io.*;
import java.util.*;

public class Sharon {
	
	public static void main(String... args) throws IOException {
		Scanner scan = new Scanner(new File("sharon.dat"));
		int noSets = scan.nextInt();
		int count = 1;
		while (noSets-- > 0) {
			int shift = scan.nextInt();
			int players = scan.nextInt();
			List<String> list = new ArrayList<>();
			for(int i = 0; i<players; i++)
				list.add(scan.next());
			while(list.size()>1){
				//System.out.println(list);
				Collections.rotate(list, -shift);
				//System.out.println(list);
				list.remove((list.size()-1));
			
		}
			System.out.println("The winner is "+list.get(0));

	}
}
}