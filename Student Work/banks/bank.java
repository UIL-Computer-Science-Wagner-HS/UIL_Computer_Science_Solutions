import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class bank {
	LocalDate entry;
	double money;
	
public bank(LocalDate d, double money) {
	entry = d;
	this.money=money;
		
	}

public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(new File("bank.dat"));
	List<bank> list = new ArrayList<>();
	while(scan.hasNextLine()) {
		String[] arr = scan.nextLine().split(" ");
		String[] arr1 = arr[0].split("-");
	
		bank b = new bank(LocalDate.of(Integer.parseInt(arr1[0]),Integer.parseInt(arr1[1]),Integer.parseInt(arr1[2])),Double.parseDouble(arr[1]));
		list.add( b);
				}
	double sum = 0;
	//int month = 1;
	LocalDate oldMonth =list.get(0).entry; 
	for(bank b: list) {
		
		if(oldMonth.getMonthValue()==b.entry.getMonthValue()) {
			sum+=b.money;
		oldMonth=b.entry;	
		}
		else {
			int diff = (b.entry.getYear()-oldMonth.getYear())*12 +b.entry.getMonthValue()-oldMonth.getMonthValue();
			

			for(int i = 0; i<diff; i++) {
				sum=sum+0.02*sum;
				}
			sum=sum+b.money;
			oldMonth = b.entry;
			
			
		}
		
		
	}
	int s = (int)(sum*100);
	System.out.println(s/100.0);
		
	
}

}