import java.awt.Color;
import java.util.Random;

public class Food {

  static Random r = new Random();
  static int xLoc, yLoc, rColor;
  public static Color color;
  
  public static void placeFood() {
    xLoc = r.nextInt((int)(Map.WIDTH / Map.GRID_UNIT)) * Map.GRID_UNIT;
    yLoc = r.nextInt((int)(Map.HEIGHT / Map.GRID_UNIT)) * Map.GRID_UNIT;
    
    rColor = (int) (Math.random() * 7 + 1);
    
    switch (rColor) {
      case 1 -> color = Color.BLUE;
      case 2 -> color = Color.YELLOW;
      case 3 -> color = Color.ORANGE;
      case 4 -> color = Color.PINK;
      case 5 -> color = Color.MAGENTA;
      case 6 -> color = Color.RED;
      case 7 -> color = Color.GREEN;
    }
  }
}
