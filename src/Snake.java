import java.util.List;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {

	List<Point> snakePoints;
	int xDirection, yDirection;
	
	
	public Snake(){
		snakePoints = new ArrayList<Point>();
		xDirection = 0;
		yDirection = 0;
		
		
	}
	
	public void draw(Graphics g){
		g.setColor(Color.white);
		for(Point p : snakePoints){
			g.fillRect(p.getX(), p.getY(), 4, 4);
		}
	}
}
