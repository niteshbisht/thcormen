package app.algo.basic.hackerrank;

import junit.framework.TestCase;

public class FizzBuzzProblemTest extends TestCase {
  FizzBuzzProblem fizzBuzzProblem;

  public void setUp() throws Exception {
    super.setUp();
    fizzBuzzProblem = new FizzBuzzProblem();
  }

  public void testSolve() {
    fizzBuzzProblem.solve(15);
  }
}
