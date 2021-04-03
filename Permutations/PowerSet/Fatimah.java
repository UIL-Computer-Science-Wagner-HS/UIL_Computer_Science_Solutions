import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.util.Pair;

public class Fatimah {
	
	static ArrayList<ArrayList<String>> powerSet;
	
	static void generatePowerSet(ArrayList<String> list, int index, ArrayList<String> temp) {
		if(index==list.size()) {
			powerSet.add(new ArrayList<String>(temp));
			return;
		}
		
		temp.add(list.get(index));
		generatePowerSet(list, index+1, temp);
		temp.remove(temp.size()-1);
		generatePowerSet(list, index+1, temp);
	}
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("fatimah.dat"));
		int n = Integer.parseInt(scan.nextLine());
		for(int i = 1; i<=n; i++) {
			String[] nextLine = scan.nextLine().split(" ");
			int numCharacters = Integer.parseInt(nextLine[0]);
			int numPairs = Integer.parseInt(nextLine[1]);
			ArrayList<String> characters = new ArrayList<>();
			ArrayList<Pair<String, String>> pairs = new ArrayList<>();
			powerSet = new ArrayList<>();
			while(numCharacters-->0)
				characters.add(scan.next());
			while(numPairs-->0)
				pairs.add(new Pair<>(scan.next(), scan.next()));
			scan.nextLine();
			
			generatePowerSet(characters, 0, new ArrayList<String>());
			for(int j = powerSet.size()-1; j>=0; j--) {
				ArrayList<String> currSet = powerSet.get(j);
				for(Pair<String, String> pair: pairs)
					if(currSet.contains(pair.getKey()) && currSet.contains(pair.getValue()))
						powerSet.remove(currSet);
			}
			
			int maxNumMonsters = Integer.MIN_VALUE;
			for(ArrayList<String> set: powerSet)
				if(set.size()>maxNumMonsters)
					maxNumMonsters = set.size();
			System.out.printf("Case #%d: %d%n", i, maxNumMonsters);
		}
	}
}
