import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


@SuppressWarnings("serial")
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
		player = new Snake();
		fruit = new Fruit(player);
		thread = new Thread(this);
		thread.start();
	}
	
	public void paint(Graphics a){
		graphs.setColor(Color.black);
		graphs.fillRect(0, 0, 400, 400);
		if(!EndGame)
		{
		player.draw(graphs);
		fruit.draw(graphs);
		}
		else
		{
			graphs.setColor(Color.YELLOW);
			graphs.drawString("GAME OVER", 100, 100);
		}
		
		
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
		while(true)
		{
			
			if(!EndGame)
			{
			player.move();
			this.EndGameCheck();
			fruit.FruitEaten();
			}
			this.repaint();
			try 
			{
				
				Thread.sleep(40);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}
	}
	
	public void EndGameCheck()
	{
		if(player.getX() < 0 || player.getX() > 400)
		{
			EndGame = true;
		}
		if(player.getY() < 0 || player.getY() > 400)
		{
			EndGame = true;
		}
		if(player.HitSelf())
		{
			EndGame = true;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		
		if(!player.Movement()){
			if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_RIGHT 
				|| e.getKeyCode() ==KeyEvent.VK_DOWN) {
				player.setMovement(true);
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			if(player.getYDirection() != 1){
				player.setYDirection(-1);
				player.setXDirection(0);
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			if(player.getXDirection() != -1){
				player.setXDirection(1);
				player.setYDirection(0);
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			if(player.getYDirection() != -1){
				player.setYDirection(1);
				player.setXDirection(0);
			}
		}
	
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
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
