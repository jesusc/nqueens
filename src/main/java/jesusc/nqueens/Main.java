package jesusc.nqueens;

import java.util.Arrays;
import java.util.List;

import jesusc.nqueens.NQueens.Position;
import jesusc.nqueens.NQueens.Solution;

public class Main {

	public static void main(String[] args) {
		int n = 8;
		List<Solution> solutions = NQueens.solve(n);
		System.out.println("There are " + solutions.size() + " solutions for " + n + " queens.");
		
		for (Solution solution : solutions) {
			print(solution, n);
		}
	}

	private static void print(Solution solution, int size) {
		System.out.println("Solution:");
			
		List<Position> positions = solution.getPositions();
		for (Position p : positions) {
			String[] row = repeat(size, " "); 
			row[p.getCol()] = "Q";
			
			System.out.println("  |" + String.join("|", row) + "|");
		}
	}
	
	private static String[] repeat(int n, String s) {
		String[] row = new String[n];
		Arrays.fill(row, s);
		return row;
	}
	
	
	
}
