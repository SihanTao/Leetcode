import java.util.Arrays;
import java.util.Comparator;

public class BurstBalloons_452 {
  public static int findMinArrowShots(int[][] points) {
    int num_balloons = points.length;
    if (num_balloons == 0) {
      return 0;
    }

    Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

    int shoot = points[0][1];
    int num_arrows = 1;

    for (int i = 1; i < num_balloons; i++) {
      if (shoot < points[i][0]) {
        // missed
        num_arrows++;
        shoot = points[i][1];
      }
    }
    return num_arrows;
  }

  public static void main(String[] args) {
    int[][] points = new int[2][2];
    points[0][0] = Integer.MIN_VALUE;
    points[0][1] = Integer.MIN_VALUE + 1;
    points[1][0] = Integer.MAX_VALUE-1;
    points[1][1] = Integer.MAX_VALUE;
    System.out.println(findMinArrowShots(points));
  }
}
