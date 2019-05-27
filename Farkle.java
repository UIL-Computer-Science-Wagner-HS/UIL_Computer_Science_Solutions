import java.io.*;
import java.util.*;


public class Farkle {
	
	public static void process(int seed, int no) {
		Random rand = new Random(seed);
		int sum = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0;i<100;i++) {
			//System.out.println(i);
			while(true) {
			list.add(rand.nextInt(6)+1);
			if(severalTimesInRow(list,no)) {
				sum+=list.size();
				//System.out.println("Sttuck");
				break;
			}
			if(i==99)
				break;
			}
			if(i==0)
				printList(list);
			list = new ArrayList<Integer>();
		}
			System.out.printf("%.1f%n",(double)sum/100);
		
	}
	
	public static boolean severalTimesInRow(ArrayList<Integer> list,int no) {
		if(list.size()<no)
			return false;
		return(Collections.frequency(list,list.get(list.size()-1))==no&&nextToEachOther(list,no));
	}
	
	public static boolean nextToEachOther(ArrayList<Integer>list, int no) {
		for(int i = 0;i<no;i++) {
			if(list.get(list.size()-1)!=list.get(list.size()-1-i))
				return false;
		}
		return true;
	}
	
	public static void printList(ArrayList<Integer> list) {
		for(Integer a:list) {
			System.out.print(a);
		}
		System.out.println();
	}

	public static void main(String[] args)throws IOException {
		Scanner scan = new Scanner(new File("farkle.dat"));
		while(scan.hasNextLine()) {
			int seed = scan.nextInt();
			int no = scan.nextInt();
			scan.nextLine();
			process(seed,no);
			//System.out.println("Here");
		}
		scan.close();

	}

}
