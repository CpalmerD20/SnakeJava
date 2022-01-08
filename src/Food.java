import java.awt.Color;

public class Food {

  static int xLocation, yLocation, rColor;
  public static Color color;
  
  public static void placeFood() {
    //draws a random number inclusive 0, exclusive Map.WIDTH / GRID_UNIT, allocated by GRID_UNIT;
    xLocation = (int) (Math.random() * (Map.WIDTH / Map.GRID_UNIT)) * Map.GRID_UNIT;
    yLocation = (int) (Math.random() * (Map.HEIGHT / Map.GRID_UNIT)) * Map.GRID_UNIT;

    // to include 1-7 a unit shift of 1 is needed.
    rColor = (int) ((Math.random() * 7) + 1);
    
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
