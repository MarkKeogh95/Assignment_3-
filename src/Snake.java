import java.util.List;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {

	List<Point> snakePoints;
	int xDirection, yDirection;
	boolean isMoving, elongate;
	final int SSIZE = 20, StartX = 150, StartY = 150;
	
	
	
	public Snake(){
		snakePoints = new ArrayList<Point>();
		xDirection = 0;
		yDirection = 0;
		isMoving = false;
		elongate = false;
		snakePoints.add(new Point(StartX, StartY));
		for( int i = 1; i < SSIZE; i++){
			snakePoints.add(new Point(StartX - i * 4, StartY));
		}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.white);
		for(Point p : snakePoints){
			g.fillRect(p.getX(), p.getY(), 4, 4);
		}
	}
	
	public int getxDirection(){
		return xDirection;
	}
	
	public int getyDirection(){
		return yDirection;
	}
	
	public void setxDirection(int x){
		xDirection = x;
	}
	
	public void setyDirection(int y){
		yDirection = y;
	}
	
	//This gets the x position which is
	//the head of the snake
	public int getX(){
		return snakePoints.get(0).getX();
	}
	
	public int getY(){
		return snakePoints.get(0).getY();
	}
}
