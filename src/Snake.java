import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Snake implements KeyListener {

  final static int X[] = new int [Map.MAP_UNITS];
  final static int Y[] = new int [Map.MAP_UNITS];
  static String direction = "East";
  static Color snakeHead = Color.GREEN;
  static Color snakeBody = new Color(45,180,0);
  static int bodyLength = 5;
  static int foodEaten = 0;
  
  public static void collide() {
    //body
    for(int i = bodyLength; i > 0; i--) {
      if((X[0] == X[i] && Y[0] == Y[i])) {Game.running = false;}
    //borders
      if(X[0] < 0) {Game.running = false;}
      if(Y[0] < 0) {Game.running = false;}
      if(X[0] > Map.WIDTH) {Game.running = false;}
      if(Y[0] > Map.HEIGHT) {Game.running = false;}
    }
  }
  
  public static void eatFood() {
    if((X[0] == Food.xLoc && Y[0] == Food.yLoc)) {
      bodyLength++;
      foodEaten++;
      Food.placeFood();
      Map.scoreLabel.setText("Score " + foodEaten);
      
    }
  }
  
  public static void move() {
    for(int i = bodyLength; i > 0; i--) {
      X[i] = X[i-1];
      Y[i] = Y[i-1];
    }
    switch(direction) {
      case "North" -> Y[0] = Y[0] - Map.GRID_UNIT;
      case "South" -> Y[0] = Y[0] + Map.GRID_UNIT;
      case "West" -> X[0] = X[0] - Map.GRID_UNIT;
      case "East" -> X[0] = X[0] + Map.GRID_UNIT;
    }
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    switch(e.getKeyCode()) {
      case KeyEvent.VK_LEFT: if(direction != "East") {direction = "West";} break;
      case KeyEvent.VK_RIGHT: if(direction != "West") {direction = "East";} break;
      case KeyEvent.VK_UP: if(direction != "South") {direction = "North";} break;
      case KeyEvent.VK_DOWN: if(direction != "North") {direction = "South";} break;
    }
  }
  @Override
  public void keyTyped(KeyEvent e) {
  }
  @Override
  public void keyReleased(KeyEvent e) {
  }
}
