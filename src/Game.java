import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends Applet implements Runnable, KeyListener{

	Graphics gfx;
	Image img;
	Thread thread;
	
	public void init(){
		this.resize(400, 400);
		img = createImage(400,400);
		gfx = img.getGraphics();
		thread = new Thread(this);
		thread.start();
	}
	
	public void paint(Graphics g){
		gfx.setColor(Color.black);
		gfx.fillRect(0, 0, 400, 400);
		
		g.drawImage(img, 0, 0, null);
	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	public void repaint(Graphics g){
		paint(g);
	}

	
	public void run() {
		
	}

	public void keyTyped(KeyEvent e) {

	}

	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_UP){
			
		}
		if(e.getKeyCode()== KeyEvent.VK_RIGHT){
			
		}
		if(e.getKeyCode()== KeyEvent.VK_DOWN){
	
		}
		if(e.getKeyCode()== KeyEvent.VK_LEFT){
	
		}
		
	}

	
	public void keyReleased(KeyEvent e) {
		
		
	}
}
