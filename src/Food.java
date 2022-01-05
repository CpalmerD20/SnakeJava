import java.util.Random;

public class Food {

  static Random r;
  static int xLoc, yLoc;
  
  public static void placeFood() {
    r = new Random();
    xLoc = r.nextInt((int)(Map.WIDTH / Map.GRID_UNIT)) * Map.GRID_UNIT;
    yLoc = r.nextInt((int)(Map.HEIGHT / Map.GRID_UNIT)) * Map.GRID_UNIT;
  };
}
