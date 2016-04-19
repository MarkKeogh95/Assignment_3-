import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


@SuppressWarnings("serial")
public class Game extends Applet implements Runnable, KeyListener{

	Graphics gfx;
	Image img;
	Thread thread;
	Snake snake;
	
	public void init(){
		this.resize(400, 400);
		img = createImage(400, 400);
		gfx = img.getGraphics();
		snake = new Snake();
		thread = new Thread(this);
		thread.start();
	}
	
	public void paint(Graphics g){
		gfx.setColor(Color.black);
		gfx.fillRect(0, 0, 400, 400);
		snake.draw(gfx);
		
		
		g.drawImage(img, 0, 0, null);
	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	public void repaint(Graphics g){
		paint(g);
	}

	
	public void run() {
		while(true){
			
			snake.move();
			
			this.repaint();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			if(snake.getYDir() != 1){
				snake.setYDir(-1);
				snake.setXDir(0);
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			if(snake.getXDir() != -1){
				snake.setXDir(1);
				snake.setYDir(0);
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			if(snake.getYDir() != -1){
				snake.setYDir(1);
				snake.setXDir(0);
			}
		}
	
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			if(snake.getXDir() != 1){
				snake.setXDir(-1);
				snake.setYDir(0);
		}
	
		}
		
	}

	
	public void keyReleased(KeyEvent e) {
		
		
	}
	
	public void keyTyped(KeyEvent e) {

	}

}
