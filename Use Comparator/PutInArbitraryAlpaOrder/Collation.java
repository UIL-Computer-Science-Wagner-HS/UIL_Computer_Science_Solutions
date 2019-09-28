import java.io.*;
import java.util.*;


public class Collation{
		
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("col.dat"));
		int noSets = scan.nextInt();
		
		while(noSets-->0) {
			scan.nextLine();
			String key = scan.nextLine();
			
			int noWords = scan.nextInt();
			
			scan.nextLine();
			ArrayList<String> list = new ArrayList();
			
			while(noWords-->0) {
				list.add(scan.next());
				
			}
		
			list.sort(new Comparator<String>() {

				@Override
				public int compare(String a, String b) {
					
					if(a.length()>0&&b.length()==0)
						return 1;
					if(b.length()>0&&a.length()==0)
						return -1;
					if(b.length()==0&&a.length()==0)
						return 0;
					if(b.charAt(0)!=a.charAt(0))
						return key.indexOf(a.charAt(0))-key.indexOf(b.charAt(0));
					return compare(a.substring(1), b.substring(1));
				}
			});
		System.out.println(key);	
		list.forEach(a->System.out.print(a+ " "));	
		System.out.println();
	}
	}

}
