
public class Starter implements Runnable{

  private Thread thread;
  private final double UPDATE_CAP = 1 / 60;
  
  @Override
  public void run() {
    boolean render = false;
    double lastTime = System.nanoTime() / 1000000000;
    double firstTime = 0;
    double passedTime = 0;
    double unprocessedTime = 0;

    while(Game.running) {
      firstTime = System.nanoTime() / 1000000000;
      passedTime = firstTime - lastTime;
      lastTime = firstTime;
      unprocessedTime += passedTime;

      while (unprocessedTime >= UPDATE_CAP) {
          unprocessedTime -= UPDATE_CAP;
          render = true;
          //todo: update game
      }
      if(render) {
        //todo: render game
      } else { 
        try {
          thread.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
    dispose();
  }

  private void dispose() {
    // TODO Auto-generated method stub
    
  }

  public void start() {
    thread = new Thread(this);
    thread.run();
  }
  
}
