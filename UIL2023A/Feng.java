import java.io.*;
import java.util.*;
public class Feng {
public static void main(String... args) throws IOException {

	Scanner scan = new Scanner(new File("feng.dat"));
	int noSets = scan.nextInt();
	scan.nextLine();
	while (noSets-- > 0) {
		String str = scan.next();
		//System.out.println(str);
		int index = str.indexOf(":");
		int hours = Integer.parseInt(str.substring(0,index));
		int minutes = Integer.parseInt(str.substring(index+1));
		double hrs = 60*hours+minutes;
		double mins = (60*hours+minutes)%60;
		hrs = hrs/60;
		double degHrs = 360/12*hrs;
		double degMins = 360/60*mins;
		if(degHrs<=90)
			degHrs= 90 - degHrs;
		else degHrs = 360-degHrs+90;
		if(degMins<=90)
			degMins= 90 - degMins;
		else degMins = 360-degMins+90;
		
		System.out.printf("Hour: %-1.1f Minute: %-1.1f\n", degHrs, degMins);
		
		

	}

}
}
