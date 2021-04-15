import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class IsabelCorrected {
String name;
int dayNum;
LocalDate date;
	
	

	public Isabel(String name, int dayNum, LocalDate date) {
	super();
	this.name = name;
	this.dayNum = dayNum;
	this.date = date;
}



	public static void main(String[] args) throws IOException{
		List<Isabel> list = new ArrayList();
		Comparator<Isabel> comp1 = (a,b)->a.name.compareTo(b.name);
		Comparator<Isabel> comp =(a,b)->a.dayNum-b.dayNum;
		Scanner scan = new Scanner(new File("isabel.dat"));
		while(scan.hasNextLine()) {
		String name = scan.next();
		int year = scan.nextInt();
		int month = scan.nextInt();
		int day = scan.nextInt();
		//System.out.println(day);
		LocalDate date = LocalDate.of(year, month, day);
		int n = date.getDayOfWeek().getValue();
		list.add(new Isabel(name, n, date));
		
				
		}
		list.sort(comp.thenComparing(comp1));
		for(Isabel per: list) {
			System.out.printf("%-11s",per.name);
			DateTimeFormatter format = DateTimeFormatter.ofPattern(": EEEE, MMMM d, yyyy");
			System.out.print(per.date.format(format));
			System.out.println();
			
			
		}
		
	}

}
