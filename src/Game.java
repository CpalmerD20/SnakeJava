import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Game extends JFrame implements ActionListener{

  static boolean running = false;
  static final int DELAY = 75;
  static String score;
  Timer timer;
  JButton play, replay;

  Game() {
    this.setTitle("Super Snake");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.add(new Map());
    this.pack();
    this.setVisible(true);
    
    playGame();
  }

  void playGame() {
    running = true;
    timer = new Timer(DELAY,this); 
    timer.start();
    Food.placeFood();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(Game.running) { 
      Snake.move();
      Snake.collide();
      Snake.eatFood();
    }
    repaint();
  }
  
  public static void end(Graphics g) {
    score = "Score " + Snake.foodEaten;
    Map.scoreLabel.setText(score);
    Map.gameOver.setText("Game Over: ");
  }
}
