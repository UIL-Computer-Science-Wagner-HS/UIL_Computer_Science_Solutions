import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Fantasy {
	
	static class Team {
		String name;
		int fieldGoalsMade, fieldGoalsAttempted, freeThrowsMade, freeThrowsAttempted;
		int threePointers, points, rebounds, assists, steals, blocks, turnovers;
		int fantasyPoints;
		
		public Team(String name) {
			this.name = name;
		}
		
		public void add(int[] playerStats) {
			fieldGoalsMade += playerStats[0];
			fieldGoalsAttempted += playerStats[1];
			freeThrowsMade += playerStats[2];
			freeThrowsAttempted += playerStats[3];
			threePointers += playerStats[4];
			points += playerStats[5];
			rebounds += playerStats[6];
			assists += playerStats[7];
			steals += playerStats[8];
			blocks += playerStats[9];
			turnovers += playerStats[10];
		}
		
		public static void compareTeams(Team team1, Team team2) {
			double fieldGoalPercentage_1 = team1.fieldGoalsAttempted==0?0:1.0*team1.fieldGoalsMade/team1.fieldGoalsAttempted;
			double freeThrowPercentage_1 = team1.freeThrowsAttempted==0?0:1.0*team1.freeThrowsMade/team1.freeThrowsAttempted;
			double fieldGoalPercentage_2 = team2.fieldGoalsAttempted==0?0:1.0*team2.fieldGoalsMade/team2.fieldGoalsAttempted;
			double freeThrowPercentage_2 = team2.freeThrowsAttempted==0?0:1.0*team2.freeThrowsMade/team2.freeThrowsAttempted;
		
			determineWinner(team1, team2, fieldGoalPercentage_1, fieldGoalPercentage_2, false);
			determineWinner(team1, team2, freeThrowPercentage_1, freeThrowPercentage_2, false);
			determineWinner(team1, team2, team1.threePointers, team2.threePointers, false);
			determineWinner(team1, team2, team1.points, team2.points, false);
			determineWinner(team1, team2, team1.rebounds, team2.rebounds, false);
			determineWinner(team1, team2, team1.assists, team2.assists, false);
			determineWinner(team1, team2, team1.steals, team2.steals, false);
			determineWinner(team1, team2, team1.blocks, team2.blocks, false);
			determineWinner(team1, team2, team1.turnovers, team2.turnovers, true);
			
			if(team1.fantasyPoints>team2.fantasyPoints)
				System.out.println(team1.name + " wins!");
			else if(team1.fantasyPoints<team2.fantasyPoints)
				System.out.println(team2.name + " wins!");
			else
				System.out.println("Tie.");
		}
		
		public static void determineWinner(Team team1, Team team2, double first, double second, boolean reverse) {
			if(reverse) {
				if(first<second)
					team1.fantasyPoints++;
				else if(first>second)
					team2.fantasyPoints++;
			} else {
				if(first<second)
					team2.fantasyPoints++;
				else if(first>second)
					team1.fantasyPoints++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("fantasy.dat"));
		int n = Integer.parseInt(scan.nextLine());
		while(n-->0) {
			String[] teams = scan.nextLine().split(" ");
			Team team1 = new Team(teams[0]);
			Team team2 = new Team(teams[1]);
			int numPlayers = Integer.parseInt(teams[2]);
			
			// Team 1
			for(int i = 0; i<numPlayers; i++) {
				String[] playerStats = scan.nextLine().split(" ");
				int[] playerStatistics = new ArrayList<>(Arrays.asList(playerStats)).stream().mapToInt(Integer::parseInt).toArray();
				team1.add(playerStatistics);
			}
			
			// Team 2
			for(int i = 0; i<numPlayers; i++) {
				String[] playerStats = scan.nextLine().split(" ");
				int[] playerStatistics = new ArrayList<>(Arrays.asList(playerStats)).stream().mapToInt(Integer::parseInt).toArray();
				team2.add(playerStatistics);
			}
			
			Team.compareTeams(team1, team2);
		}
	}
}
