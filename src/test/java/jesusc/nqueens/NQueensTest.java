package jesusc.nqueens;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import jesusc.nqueens.NQueens;
import jesusc.nqueens.NQueens.Position;
import jesusc.nqueens.NQueens.Solution;

public class NQueensTest {

	/**
	 * This test uses the data about the number of solution available in Wikipedia.
	 * 		https://en.wikipedia.org/wiki/Eight_queens_puzzle#Counting_solutions
	 */
	@Test
	public void testNumberOfSolutions() {
		int[] numSolutions = new int[] { 1, 0, 0, 2, 10, 4,	40, 92,	352, 724 };
		for (int i = 0; i < numSolutions.length; i++) {
			assertEquals(numSolutions[i], NQueens.solve(i + 1).size());
		}
	}
	
	/**
	 * This test checks the solution for a board of 4x4 against the solution
	 * computed by hand.
	 */
	@Test
	public void testSolution() {
		List<Solution> solutions = NQueens.solve(4);
		
		// First solution:
		Solution s1 = solutions.get(0);
		Position p1_1 = s1.getPositions().get(0);
		Position p1_2 = s1.getPositions().get(1);
		Position p1_3 = s1.getPositions().get(2);
		Position p1_4 = s1.getPositions().get(3);
			
		// This is the post-condition of the returned solutions:
		// they are returned in row order
		assertEquals(0, p1_1.getRow());
		assertEquals(1, p1_2.getRow());
		assertEquals(2, p1_3.getRow());
		assertEquals(3, p1_4.getRow());
		
		assertEquals(1, p1_1.getCol());
		assertEquals(3, p1_2.getCol());
		assertEquals(0, p1_3.getCol());
		assertEquals(2, p1_4.getCol());
		
		// Second solution
		Solution s2 = solutions.get(1);
		Position p2_1 = s2.getPositions().get(0);
		Position p2_2 = s2.getPositions().get(1);
		Position p2_3 = s2.getPositions().get(2);
		Position p2_4 = s2.getPositions().get(3);
			
		// This is the post-condition of the returned solutions:
		// they are returned in row order
		assertEquals(0, p2_1.getRow());
		assertEquals(1, p2_2.getRow());
		assertEquals(2, p2_3.getRow());
		assertEquals(3, p2_4.getRow());
		
		assertEquals(2, p2_1.getCol());
		assertEquals(0, p2_2.getCol());
		assertEquals(3, p2_3.getCol());
		assertEquals(1, p2_4.getCol());
		
	}
}
