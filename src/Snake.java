import java.util.List;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {

	List<Point> snakePoints;
	int xDirection, yDirection;
	boolean Movement, Longer;
	final int SSIZE = 20, BEGINX = 150, BEGINY = 150;
	
	
	
	public Snake(){
		snakePoints = new ArrayList<Point>();
		xDirection = 0;
		yDirection = 0;
		Movement = false;
		Longer = false;
		snakePoints.add(new Point(BEGINX, BEGINY));
		for( int i = 1; i < SSIZE; i++){
			snakePoints.add(new Point(BEGINX - (i * 4), BEGINY));
		}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.white);
		for(Point p : snakePoints){
			g.fillRect(p.getX(), p.getY(), 4, 4);
		}
	}
	
	public void move(){
		if(Movement == true){
		Point temp = snakePoints.get(0);
		Point last = snakePoints.get(snakePoints.size() - 1);
		Point newStart = new Point(temp.getX() + xDirection * 4, temp.getY() + yDirection * 4);
		for(int i = snakePoints.size() - 1; i >= 1; i--){
			snakePoints.set(i,  snakePoints.get(i - 1));
		}
		snakePoints.set(0, newStart);
		}
	
	}
	
	public boolean HitSelf()
	{
		int x = this.getX();
		int y = this.getY();
		
		for(int i = 1; i <snakePoints.size(); i++)
		{
			if(snakePoints.get(i).getX() == x && snakePoints.get(i).getY() == y)
			
				return true;
		}
		return false;
	}
	
	public boolean Movement(){
		return Movement;
	}
	
	public void setMovement(boolean b){
		Movement = b;
	}
	
	public int getXDir(){
		return xDirection;
	}
	
	public int getYDir(){
		return yDirection;
	}
	
	public void setXDir(int x){
		xDirection = x;
	}
	
	public void setYDir(int y){
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
