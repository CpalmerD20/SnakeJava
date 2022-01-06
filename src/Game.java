import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Game extends JFrame implements ActionListener {

  static boolean running = false;
  static final int DELAY = 60;
  Timer timer =  new Timer(DELAY,this);
  static byte turn;
  static String score;
  static JButton replay, play;

  Game() {
    play  = new JButton("Play");
    play.setBounds(200,200,200,200);
    play.addActionListener(this);
    
    replay = new JButton("Replay");
    replay.setBounds(200,200,200,200);
    replay.addActionListener(this);
    
    this.setTitle("Super Snake");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.add(play);
    this.add(replay);
    this.add(new Map());
    this.pack();
    this.setVisible(true);
  }

  void playGame() {
    turn = 0;
    replay.setVisible(false);
    running = true;
    timer.start(); 
    Food.placeFood();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(running) { 
      Snake.move();
      Snake.collide();
      Snake.eatFood();
    }
    if(e.getSource() == play) {
      hideButtons();
      playGame();
    }
    if(e.getSource() == replay) {
      hideButtons();
      Snake.reset();
      Map.gameOver.setText("");
      Map.scoreLabel.setText(score);
      playGame();
    }
    repaint();
  }
  
  private void hideButtons() {
    play.setVisible(false);
    replay.setVisible(false);
  }

  public static void end(Graphics g) {
    score = "Score " + Snake.foodEaten;
    Map.scoreLabel.setText(score);
    if (turn > 0) {
      Map.gameOver.setText("Game Over: ");
    }
    replay.setVisible(true);
  }
}
