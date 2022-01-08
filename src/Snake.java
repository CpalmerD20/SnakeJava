import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Snake implements KeyListener {

  final static int X[] = new int [Map.GRID_MAX];
  final static int Y[] = new int [Map.GRID_MAX];
  enum Direction {North, South, East, West};
  static Direction d;
  static Color snakeHead = Color.GREEN;
  static Color snakeBody = new Color(50,200,0);
  static int bodyLength = 4;
  static int foodEaten = 0;
  
  static void collide() {
    //collision with body
    for(int i = bodyLength; i > 0; i--) {
      if((X[0] == X[i] && Y[0] == Y[i])) {Game.running = false;}
    //collision with borders
      if(X[0] < 0) {Game.running = false;}
      if(Y[0] < 0) {Game.running = false;}
      if(X[0] > Map.WIDTH) {Game.running = false;}
      if(Y[0] > Map.HEIGHT) {Game.running = false;}
    }
    Game.over = true;
  }
  
  static void eatFood() {
    if((X[0] == Food.xLocation && Y[0] == Food.yLocation)) {
      bodyLength++;
      foodEaten++;
      Food.placeFood();
      Map.scoreLabel.setText("Score " + foodEaten);
    }
  }
  
  static void move() {
    for(int i = bodyLength; i > 0; i--) {
      X[i] = X[i-1];
      Y[i] = Y[i-1];
    }
    switch(d) {
      case North -> Y[0] = Y[0] - Map.GRID_UNIT;
      case South -> Y[0] = Y[0] + Map.GRID_UNIT;
      case West -> X[0] = X[0] - Map.GRID_UNIT;
      case East -> X[0] = X[0] + Map.GRID_UNIT;
    }
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    switch(e.getKeyCode()) {
      case KeyEvent.VK_UP: if(d != Direction.South) {d = Direction.North;} break;
      case KeyEvent.VK_DOWN: if(d != Direction.North) {d = Direction.South;} break;
      case KeyEvent.VK_LEFT: if(d != Direction.East) {d = Direction.West;} break;
      case KeyEvent.VK_RIGHT: if(d != Direction.West) {d = Direction.East;} break;
    }
  }

  static void create() {
    d = Direction.East;
    foodEaten = 0;
    bodyLength = 4;
    Game.score = "Score " + foodEaten;
    for (int i = 0; i < bodyLength; i++) {
      X[i] = -i;
      Y[i] = 12 * Map.GRID_UNIT; //halfway down the map
    }
  }
  
  @Override
  public void keyTyped(KeyEvent e) {}
  
  @Override
  public void keyReleased(KeyEvent e) {}
}
