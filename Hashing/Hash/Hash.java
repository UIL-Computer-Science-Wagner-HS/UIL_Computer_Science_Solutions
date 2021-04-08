import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hash {
	
	static class HashTableCollection {
		int size;
		ArrayList<HashTable> hashTables;
		
		public HashTableCollection(int size) {
			this.size = size;
			hashTables = new ArrayList<>();
		}
		
		public void addString(String str) {
			int index = getIndex(str);
			ArrayList<HashTable> toAddAtEnd = new ArrayList<>();
			for(HashTable table: hashTables) {
				if(table.indexFree(index))
					table.set(index, str);
				else if(table.indexFree(index-1)&&table.indexFree(index+1)) {
					// Make copy of HashTable with string added above.
					HashTable addedAbove = new HashTable(table.arr);
					addedAbove.set(index+1, str);
					toAddAtEnd.add(addedAbove);
					// Make copy of HashTable with string added below.
					HashTable addedBelow = new HashTable(table.arr);
					addedBelow.set(index-1, str);
					toAddAtEnd.add(addedBelow);
				} else if(table.indexFree(index+1))
					table.set(index+1, str);
				else if(table.indexFree(index-1))
					table.set(index-1, str);
				else // Unresolvable conflict
					table.numUnresolvedConflicts++;
			}
			for(HashTable table: toAddAtEnd)
				hashTables.add(table);
		}
		
		int getIndex(String str) {
			int sum = 0;
			for(int i = 0; i<str.length(); i++) {
				sum += (str.charAt(i)-'a')*Math.pow(2, i);
			}
			return sum%size;
		}
		
		public int getMinUnresolvedConflicts() {
			int minUnresolvedConflicts = Integer.MAX_VALUE;
			for(HashTable table: hashTables) {
				if(table.numUnresolvedConflicts<minUnresolvedConflicts)
					minUnresolvedConflicts = table.numUnresolvedConflicts;
			}
			return minUnresolvedConflicts;
		}
	}
	
	static class HashTable {
		int numUnresolvedConflicts;
		
		String[] arr;
		
		public HashTable(int size) {
			arr = new String[size];
		}
		
		public HashTable(String[] arr) {
			this.arr = new String[arr.length];
			for(int i = 0; i<arr.length; i++)
				this.arr[i] = arr[i];
		}
		
		public boolean indexFree(int index) {
			return index>=0 && index<arr.length && arr[index] == null;
		}
		
		public void set(int index, String str) {
			arr[index] = str;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("hash.dat"));
		int numCases = Integer.parseInt(scan.nextLine());
		while(numCases-->0) {
			String[] nextLine = scan.nextLine().split(" ");
			int size = Integer.parseInt(nextLine[0]);
			int numberStrings = Integer.parseInt(nextLine[1]);
			HashTableCollection collection = new HashTableCollection(size);
			collection.hashTables.add(new HashTable(size));
			while(numberStrings-->0) {
				collection.addString(scan.nextLine());
			}
			System.out.println(collection.getMinUnresolvedConflicts());
		}

	}

}
