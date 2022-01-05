import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Timer;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Map extends JPanel {
  
  static final int WIDTH = 700;
  static final int HEIGHT = 700;
  static final int GRID_UNIT = 20;
  static final int MAP_UNITS = (WIDTH * HEIGHT) / GRID_UNIT;
  static Font font = new Font("Aharoni", Font.PLAIN,40);
  static Color fontColor = Color.red;
  static JLabel gameOver = new JLabel();
  static JLabel scoreLabel = new JLabel();
  static Color wallColor = Color.black;
  static Color scoreColor = Color.red;

  
  Map() {
    gameOver.setFont(font);
    gameOver.setForeground(fontColor);
    scoreLabel.setFont(font);
    scoreLabel.setForeground(fontColor);
    
    this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
    this.setBackground(wallColor);
    this.setFocusable(true);
    this.add(gameOver);
    this.add(scoreLabel);
    this.addKeyListener(new Snake());
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    draw(g);
  }
  
  public void draw(Graphics g) {
    if(Game.running) {
    g.setColor(Color.RED);
    g.fillOval(Food.xLoc, Food.yLoc, GRID_UNIT, GRID_UNIT);
    
      for(int i = 0; i < Snake.bodyLength; i++) {
        if(i == 0) {
          g.setColor(Snake.snakeHead);
          g.fill3DRect(Snake.X[i], Snake.Y[i], GRID_UNIT, GRID_UNIT, true);
        } else {
          g.setColor(Snake.snakeBody);
          g.fill3DRect(Snake.X[i], Snake.Y[i], GRID_UNIT, GRID_UNIT, false);
        }
      }
    } else {
      Game.end(g);
    }
  }
}