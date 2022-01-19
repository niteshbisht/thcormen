package app.algo.leetcode.backtrak;

import java.util.HashSet;
import java.util.Set;

interface Robot {
  // Returns true if the cell in front is open and robot moves into the cell.
  // Returns false if the cell in front is blocked and robot stays in the current cell.
  boolean move();

  // Robot will stay in the same cell after calling turnLeft/turnRight.
  // Each turn will be 90 degrees.
  void turnLeft();

  void turnRight();

  // Clean the current cell.
  void clean();
}

class RoomRobot implements Robot {

  @Override
  public boolean move() {
    return false;
  }

  @Override
  public void turnLeft() {}

  @Override
  public void turnRight() {}

  @Override
  public void clean() {}
}

public class RoomCleanerRobot {
  // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
  int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
  Set<Pair<Integer, Integer>> visited = new HashSet<>();
  Robot robot;

  public static void main(String[] args) {
    RoomRobot r = new RoomRobot();
    RoomCleanerRobot rc = new RoomCleanerRobot();
    rc.cleanRoom(r);
  }

  public void goBack() {
    robot.turnRight();
    robot.turnRight();
    robot.move();
    robot.turnRight();
    robot.turnRight();
  }

  public void backtrack(int row, int col, int d) {
    visited.add(new Pair<>(row, col));
    robot.clean();
    // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
    for (int i = 0; i < 4; ++i) {
      int newD = (d + i) % 4;
      int newRow = row + directions[newD][0];
      int newCol = col + directions[newD][1];

      if (!visited.contains(new Pair<>(newRow, newCol)) && robot.move()) {
        backtrack(newRow, newCol, newD);
        goBack();
      }
      // turn the robot following chosen direction : clockwise
      robot.turnRight();
    }
  }

  public void cleanRoom(Robot robot) {
    this.robot = robot;
    backtrack(0, 0, 0);
  }
}
