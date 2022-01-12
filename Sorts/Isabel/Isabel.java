package compSciWorkbench;
import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class Isabel {
	LocalDate birthday;
	String name;
	
	public Isabel(String name, LocalDate birthday) {
		this.birthday = birthday;
		this.name = name;
	}
	
	public static int compareTo (Isabel a, Isabel b) {
		if(!a.birthday.getDayOfWeek().equals(b.birthday.getDayOfWeek())) {
			return a.birthday.getDayOfWeek().compareTo(b.birthday.getDayOfWeek());
		}
		else {
			return a.name.compareTo(b.name);
		}
	}
	public static void main(String[] args)throws IOException {
		Scanner scan = new Scanner(new File("isabel.dat"));
		DateTimeFormatter endFormat = DateTimeFormatter.ofPattern("yyyy M d");
		ArrayList<Isabel> list= new ArrayList<>();
		while(scan.hasNextLine()) {
			String name =  scan.next();
			String dateinput = scan.next()+" "+scan.next()+" "+scan.next();
			LocalDate birthday = LocalDate.parse(dateinput, endFormat);
			Isabel student = new Isabel(name, birthday);
			list.add(student);
		}
		list.sort((a,b)-> compareTo(a, b));
		for(Isabel student: list) {
			String DoW = student.birthday.getDayOfWeek().toString().toLowerCase();
			String temp = DoW.substring(0,1).toUpperCase();
			DoW = temp+(DoW.substring(1));
			System.out.printf("%-11s",student.name);
			System.out.println(": "+DoW+", "+student.birthday.format(DateTimeFormatter.ofPattern("MMMM d, yyyy")));
		}

	}

}
