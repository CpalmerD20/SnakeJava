import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Map extends JPanel {

  static final int WIDTH = 600;
  static final int HEIGHT = WIDTH;
  static final int GRID_UNIT = 25;
  static final int GRID_MAX = (WIDTH * HEIGHT) / GRID_UNIT;
  static Font font = new Font("Aharoni", Font.PLAIN, 40);
  static Color fontColor = Color.RED;
  static Color wallColor = Color.BLACK;
  static JLabel gameOver = new JLabel("Game Over: ");
  static JLabel scoreLabel = new JLabel();

  Map() {
    gameOver.setFont(font);
    gameOver.setForeground(fontColor);
    gameOver.setVisible(false);

    scoreLabel.setFont(font);
    scoreLabel.setForeground(fontColor);

    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
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
    if (Game.running) {
      g.setColor(Food.color);
      g.fillOval(Food.xLocation, Food.yLocation, GRID_UNIT, GRID_UNIT);

      for (int i = 0; i < Snake.bodyLength; i++) {
        if (i == 0) {
          g.setColor(Snake.snakeHead);
          g.fill3DRect(Snake.X[i], Snake.Y[i], GRID_UNIT, GRID_UNIT, true);
        } else {
          g.setColor(Snake.snakeBody);
          g.fill3DRect(Snake.X[i], Snake.Y[i], GRID_UNIT, GRID_UNIT, false);
        }
      }

    } else {
      Game.end();
    }
  }
}
