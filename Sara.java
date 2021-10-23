import java.util.*;

import org.omg.Messaging.SyncScopeHelper;

import java.io.*;

public class Sara {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("sara.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		while (noSets-- > 0) {
			String[] bride = scan.nextLine().split(" ");
			String[] groom = scan.nextLine().split(" ");
			List<String> gBase = new ArrayList();
			List<String> bBase = new ArrayList();
			for (String s : bride)
				bBase.add(s);
			for (String s : groom)
				gBase.add(s);
			Set<String> set = new TreeSet(gBase);
			System.out.print("Guests: ");
			set.addAll(bBase);
			set.forEach(a->System.out.print(a+" "));
			System.out.println();
			set = new TreeSet(gBase);
			for(String s: gBase)
				if(!bBase.contains(s))
					set.remove(s);
				
			
			//gBase.retainAll(bBase);
			//Collections.sort(gBase);
			System.out.print("Guests of both: ");
			set.forEach(a->System.out.print(a+" "));
			System.out.println();
			System.out.print("Bride's guests: ");
			Collections.sort(bBase);
			bBase.stream().forEach(a-> {if (!gBase.contains(a)) System.out.print(a+" ");});
			System.out.println();
			System.out.print("Groom's guests: ");
			Collections.sort(gBase);
			gBase.stream().forEach(a-> {if (!bBase.contains(a)) System.out.print(a+" ");});
			System.out.println();
			
			
			
			System.out.println("___________________");
			

		}

	}
}
