package jesusc.nqueens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solves the N-Queens problem using a depth-first traversal
 * of the solution space. It uses the fact that every queen needs to
 * be in a different row.
 *
 * @author jesus 
 */
public class NQueens {

	private ArrayList<Solution> solutions = new ArrayList<>();

	/**
	 * Solves N-Queens for a board of the given size.
	 * 
	 * @param size The number of rows/columns of the board
	 * @return The exhaustive list of solutions for the problem
	 */
	public static List<Solution> solve(int size) {
		NQueens nqueens = new NQueens();
		nqueens.solve(new Solution(), 0, size);
		return nqueens.solutions;
	}
	
	// This is the actual recursive algorithm that solves the problem.
	protected void solve(Solution state, int row, int size) {
		if ( row == size ) {
			solutions.add(state);
			return;
		}
		
		for(int col = 0; col < size; col++) {
			if ( state.isSafePlacement(row, col) ) {
				Solution current = state.newSolutionFor(row, col);
				solve(current, row + 1, size);
			}
		}
	}

	/**
	 * Represent a solution of the N-Queens problems.
	 */
	public static class Solution {
		protected ArrayList<Position> positions = new ArrayList<>();

		protected Solution() { }

		protected Solution(Solution s, Position newPosition) {
			this.positions.addAll(s.positions);
			this.positions.add(newPosition);
		}		

		/**
		 * Creates a new (possibly partial) solution to the problem by
		 * adding a quick a position (row, col).
		 */
		protected Solution newSolutionFor(int row, int col) {
			return new Solution(this, new Position(row, col));
		}
		
		/**
		 * Checks whether adding a queen at (row, col) will produce
		 * a valid state, that is, a queen in this position will not
		 * kill any other queen.
		 */
		protected boolean isSafePlacement(int row, int col) {
			for (Position p : positions) {
				if ( p.col == col || Math.abs(p.row - row) == Math.abs(p.col - col) ) {
					return false;
				}
			}
			return true;
		}
		
		/**
		 * @return the positions of the board in which a queen is placed, ordered by row.
		 */
		public List<Position> getPositions() {
			return Collections.unmodifiableList(positions);
		}		
	}
	
	/**
	 * Represents a position in the chess board.
	 */
	public static class Position {
		private int row;
		private int col;
		
		public Position(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		public int getRow() {
			return row;
		}
		
		public int getCol() {
			return col;
		}
	}	
}
