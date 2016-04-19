import java.util.List;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {

	List<Point> Body;
	int xDirection, yDirection;
	boolean Movement, Longer;
	final int SSIZE = 20, BEGINX = 150, BEGINY = 150;
	
	
	
	public Snake(){
		Body = new ArrayList<Point>();
		xDirection = 0;
		yDirection = 0;
		Movement = false;
		Longer = false;
		Body.add(new Point(BEGINX, BEGINY));
		for( int i = 1; i < SSIZE; i++){
			Body.add(new Point(BEGINX - (i * 4), BEGINY));
		}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.white);
		for(Point p : Body){
			g.fillRect(p.getX(), p.getY(), 4, 4);
		}
	}
	
	public void move(){
		if(Movement == true){
		Point temp = Body.get(0);
		Point last = Body.get(Body.size() - 1);
		Point newStart = new Point(temp.getX() + xDirection * 4, temp.getY() + yDirection * 4);
		for(int i = Body.size() - 1; i >= 1; i--){
			Body.set(i,  Body.get(i - 1));
		}
		Body.set(0, newStart);
		}
	
	}
	
	public boolean HitSelf()
	{
		int x = this.getX();
		int y = this.getY();
		
		for(int i = 1; i <Body.size(); i++)
		{
			if(Body.get(i).getX() == x && Body.get(i).getY() == y)
			
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
	
	public int getXDirection(){
		return xDirection;
	}
	
	public int getYDirection(){
		return yDirection;
	}
	
	public void setXDirection(int x){
		xDirection = x;
	}
	
	public void setYDirection(int y){
		yDirection = y;
	}
	
	//This gets the x position which is
	//the head of the snake
	public int getX(){
		return Body.get(0).getX();
	}
	
	public int getY(){
		return Body.get(0).getY();
	}
}
