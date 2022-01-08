import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Game extends JFrame implements ActionListener {

  static String score;
  static JButton play;
  static Font font = new Font("Aharoni", Font.BOLD, 30);
  public static boolean over = false;
  static boolean running = false;
  static final int DELAY = 50;
  Timer timer =  new Timer(DELAY,this);

  Game() {
    play = new JButton("Play Game");
    play.setBounds(200,240,200,160);
    play.setFont(font);
    play.addActionListener(this);
    
    this.setTitle("Snake");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.add(play);
    this.add(new Map());
    this.pack();
    this.setVisible(true);
  }

  void playGame() {
    play.setVisible(false);
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
    else if(e.getSource() == play) {
      Snake.create();
      Map.gameOver.setVisible(false);
      Map.scoreLabel.setText(score);
      playGame();
    }
    repaint();
  }
  
  public static void end() {
    play.setVisible(true);
    score = "Score " + Snake.foodEaten;
    Map.scoreLabel.setText(score);
    if (over == true) {
      Map.gameOver.setVisible(true);
    }
  }
}
