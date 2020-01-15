import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Program #6 from the UIL 2017 Invitational A Programming Contest
 * 
 * @author Ian Fernandes
 *
 */
public class Jean {

	/**
	 * Name of bike/bike stop
	 */
	private char name;

	/**
	 * List of outgoing bike stop visits
	 */
	private ArrayList<Jean> outgoing = new ArrayList<>();

	/**
	 * List of incoming bikes
	 */
	private ArrayList<Jean> incoming = new ArrayList<>();

	/**
	 * Construct bike/bike stop
	 * 
	 * @param name
	 */
	public Jean(char name) {
		this.name = name;
	}

	/**
	 * Return name when printed out
	 */
	public String toString() {
		return name + " ";
	}

	/**
	 * Return the Jean object associated with the name 'dest'
	 * 
	 * @param list List of Jean objects to search through
	 * @param dest Name of Jean object to find
	 * @return Jean object in list with the name 'dest'
	 */
	private static Jean findJean(ArrayList<Jean> list, char dest) {
		for (Jean current : list) {
			if (current.name == dest)
				return current;
		}

		return null;
	}

	/**
	 * Process input, construct Jean objects, and determine sources and sinks.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("jean.dat"));
		int noCases = Integer.parseInt(scan.nextLine());

		// Will hold every line within a test case
		ArrayList<String> entries = new ArrayList<>();

		// Will hold the unique bike names
		HashSet<Character> bikeChars = new HashSet<>();

		// Will hold the bike objects themselves
		ArrayList<Jean> bikes = new ArrayList<>();

		// Process each test case
		while (noCases-- > 0) {
			entries.clear();
			bikeChars.clear();
			bikes.clear();

			int noLines = Integer.parseInt(scan.nextLine());
			while (noLines-- > 0) {
				String currentLine = scan.nextLine();
				String[] currentLineArray = currentLine.split(" -> ");

				// Add any bike names found to bikeChars set
				bikeChars.add(currentLineArray[0].charAt(0));
				if (!currentLineArray[1].equals("NONE")) {
					Scanner scan2 = new Scanner(currentLineArray[1]);
					while (scan2.hasNext())
						bikeChars.add(scan2.next().charAt(0));
					scan2.close();
				}

				// Add the current line to the entries list
				entries.add(currentLine);
			}

			// Construct a new Jean object for every unique bike
			for (char a : bikeChars) {
				bikes.add(new Jean(a));
			}

			// Now process each entry and update incoming and outcoming bikes accordingly.
			for (String entry : entries) {
				String[] splitEntry = entry.split(" -> ");
				char source = splitEntry[0].charAt(0);
				Jean sourceEquivalent = findJean(bikes, source); // works
				if (!splitEntry[1].equals("NONE")) {
					Scanner scan2 = new Scanner(splitEntry[1]);
					while (scan2.hasNext()) {
						char dest = scan2.next().charAt(0);
						Jean destEquivalent = findJean(bikes, dest);
						sourceEquivalent.outgoing.add(destEquivalent);
						destEquivalent.incoming.add(sourceEquivalent);
					}
					scan2.close();
				}
			}

			ArrayList<Jean> sources = new ArrayList<>();
			ArrayList<Jean> sinks = new ArrayList<>();

			// Determine sources and sinks
			for (Jean current : bikes) {
				if (current.outgoing.size() >= 1 && current.incoming.size() == 0) {
					sources.add(current);
				} else if (current.incoming.size() >= 1 && current.outgoing.size() == 0) {
					sinks.add(current);
				}
			}

			// Sort source list by name
			Collections.sort(sources, new Comparator<Jean>() {
				@Override
				public int compare(Jean one, Jean two) {
					return one.name - two.name;
				}
			});

			// Sort sinks list by name
			Collections.sort(sinks, new Comparator<Jean>() {
				@Override
				public int compare(Jean one, Jean two) {
					return one.name - two.name;
				}
			});

			// Print sources
			System.out.print("Sources: ");
			if (sources.size() == 0)
				System.out.print("NONE");
			else
				sources.forEach(x -> System.out.print(x + " "));
			System.out.println();

			// Print sinks
			System.out.print("Sinks: ");
			if (sinks.size() == 0)
				System.out.print("NONE");
			else
				sinks.forEach(x -> System.out.print(x + " "));
			System.out.println();
		}

		scan.close();
	}
}
