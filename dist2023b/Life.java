import java.io.*;
import java.util.*;
public class Life {
public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(new File("life.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		int day = 1;
		while(noSets-->0) {
			String[] date = scan.nextLine().split("[ :]");
			String[] classes = scan.nextLine().split("[ :]");
			//System.out.println(Arrays.toString(classes));
			int dateStart = Integer.parseInt(date[0])*60+Integer.parseInt(date[1]);
			int dateEnd =  Integer.parseInt(date[2])*60+Integer.parseInt(date[3]);
			int classNo = 1;
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i<classes.length; i++) {
				int cStart = Integer.parseInt(classes[i++])*60+Integer.parseInt(classes[i++]);
				int cEnd = Integer.parseInt(classes[i++])*60+Integer.parseInt(classes[i]);
				if(cStart>=dateStart&&cStart<=dateEnd || cEnd>=dateStart&&cEnd<=dateEnd )
					list.add(classNo);
				classNo++;
			}
			if(list.size()>0) {
				for(int n: list)
					System.out.println("Day #"+day+" conflcit with class "+n);
			}
			day++;
				
			}
			
			
			
			
			
		
		}
		
}
