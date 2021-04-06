import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Descendants {
	
	static class Process {
		String name;
		int id, parentId;
		int steps;
		ArrayList<Process> children = new ArrayList<>();
		
		public Process(String name, int id, int parentId) {
			this.name = name;
			this.id = id;
			this.parentId = parentId;
		}
	}
	
	static ArrayList<Process> processes;
	
	static Process findProcess(int id) {
		for(Process process: processes)
			if(process.id==id)
				return process;
		return new Process("this never happens", -1, -1);
	}
	
	static void printTree(Process current) {
		int numSteps = current.steps;
		while(numSteps-->0)
			System.out.print("-");
		System.out.println(current.name);
		ArrayList<Process> children = current.children;
		if(children.isEmpty())
			return;
		Collections.sort(children, Comparator.comparing((Process x)->x.name));
		for(Process process: children)
			printTree(process);
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("descendants.dat"));
		int n = Integer.parseInt(scan.nextLine());
		processes = new ArrayList<>();
		Process root = new Process("root", 1, 0);
		processes.add(root);
		while(n-->0) {
			String[] nextLine = scan.nextLine().split(" ");
			String name = nextLine[0];
			int id = Integer.parseInt(nextLine[1]), parentId = Integer.parseInt(nextLine[2]);
			processes.add(new Process(name, id, parentId));
		}
		
		for(Process process: processes) {
			Process processCopy = process;
			int parentId = process.parentId;
			int numSteps = 0;
			while(parentId!=0) {
				numSteps++;
				Process parentProcess = findProcess(parentId);
				parentId = parentProcess.parentId;
				if(!parentProcess.children.contains(processCopy))
					parentProcess.children.add(processCopy);
				processCopy = parentProcess;
			}
			process.steps = numSteps;
		}
		
		printTree(root);
	}
}
