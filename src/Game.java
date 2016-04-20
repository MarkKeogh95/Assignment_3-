import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


@SuppressWarnings("serial")
//Runanable applet with keylistener , to get info from the keyboard
public class Game extends Applet implements Runnable, KeyListener{

	boolean EndGame;
	Graphics graphs;
	Image img;
	Snake player;
	Thread thread;
	Fruit fruit;
	
	public void init(){
		this.resize(400, 400);
		img = createImage(400, 400);
		graphs = img.getGraphics();
		this.addKeyListener(this);
		//Create new instances of classes
		player = new Snake();
		fruit = new Fruit(player);
		thread = new Thread(this);
		thread.start();
	}
	
	public void paint(Graphics a){
		//Colour in the whole background
		graphs.setColor(Color.black);
		graphs.fillRect(0, 0, 400, 400);
		//if the endgame boolean is not true draws snake and fruit
		if(!EndGame)
		{
		//Draws objects
		player.draw(graphs);
		fruit.draw(graphs);
		//Shows score in top left corner
		graphs.drawString("Score: " + fruit.Score(), 10, 10);
		}
		//If endgame boolean is true display messages
		else
		{
			//Displays game over and highscore when games over
			graphs.setColor(Color.YELLOW);
			graphs.drawString("GAME OVER", 100, 100);
			graphs.drawString("HighScore: " + fruit.HighScore(), 100, 120);
		}
		
		//draws the background
		a.drawImage(img, 0, 0, null);
	}
	
	public void update(Graphics a){
		paint(a);
	}
	
	public void repaint(Graphics a){
		paint(a);
	}

	
	public void run() 
	{
		//Infinite while loop
		while(true)
		{
			
			if(!EndGame)
			{
			//Moves player
			player.move();
			//Checks if game is over
			this.EndGameCheck();
			//Checks if fruit is eaten
			fruit.FruitEaten();
			}
			this.repaint();
			try 
			{
				//Time delay, sets speed, lower the number the faster the snake
				Thread.sleep(30);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}
	}
	
	public void EndGameCheck()
	{
		//Checks if the snake has hit a wall
		if(player.getX() < 0 || player.getX() > 400)
		{
			EndGame = true;
		}
		//Checks if the snake has hit a wall
		if(player.getY() < 0 || player.getY() > 400)
		{
			EndGame = true;
		}
		//Checks if the snake has hit its own body
		if(player.HitSelf())
		{
			EndGame = true;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		//Check input from the keyboard is UP,Down or RIGHT to start movement
		if(!player.Movement()){
			if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_RIGHT 
				|| e.getKeyCode() ==KeyEvent.VK_DOWN) {
				player.setMovement(true);
			}
		}
		//Changes the direction for the snake when UP is pressed
		if(e.getKeyCode() == KeyEvent.VK_UP){
			//if y direction is not equal 1, so it can't double back on itself
			if(player.getYDirection() != 1){
				player.setYDirection(-1);
				player.setXDirection(0);
			}
		}
		//Changes the direction for the snake when RIGHT is pressed
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			//If not going LEFT
			if(player.getXDirection() != -1){
				player.setXDirection(1);
				player.setYDirection(0);
			}
			
		}
		//Changes the direction for the snake when DOWN is pressed
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			//If not going UP
			if(player.getYDirection() != -1){
				player.setYDirection(1);
				player.setXDirection(0);
			}
		}
		//Changes the direction for the snake when LEFT is pressed
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			//If not going RIGHT
			if(player.getXDirection() != 1){
				player.setXDirection(-1);
				player.setYDirection(0);
		}
	
		}
		
	}

	
	public void keyReleased(KeyEvent e) {
		
		
	}
	
	public void keyTyped(KeyEvent e) {

	}

}
