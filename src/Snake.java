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
		//Make snake body
		Body = new ArrayList<Point>();
		
		xDirection = 0;
		yDirection = 0;
		
		Movement = false;
		Longer = false;
		//Setting length and start position of the snake
		Body.add(new Point(BEGINX, BEGINY));
		for( int i = 1; i < SSIZE; i++){
			//offsets by 4 for each rectangle and minus it to push the snake out left
			Body.add(new Point(BEGINX - (i * 4), BEGINY));
		}
	}
	
	public void draw(Graphics a){
		//Making snake white
		a.setColor(Color.white);
		//Drawing body of snake 
		for(Point b : Body){
			a.fillRect(b.getX(), b.getY(), 5, 5);
		}
	}
	
	
	public void move(){
		if(Movement == true){
		//Gets the head of the snake
		Point temp = Body.get(0);
		//Gets the end point of the snake
		Point last = Body.get(Body.size() - 1);
		//Adding in a new rectangle
		Point newStart = new Point(temp.getX() + xDirection * 4, temp.getY() + yDirection * 4);
		//Starts at end of snake
		//every point becomes the point that was before it
		for(int i = Body.size() - 1; i >= 1; i--){
			//updates body 
			Body.set(i,  Body.get(i - 1));
		}
		Body.set(0, newStart);
		
		if(Longer)
		{
			//Adding an extra rectangle
			Body.add(last);
			Longer = false;
		}
		}
	
	}
	
	public boolean HitSelf()
	{
		//track the head position to see if it is the same as any other point of snake
		int x = this.getX();
		int y = this.getY();
		
		//Starts after the head position
		for(int i = 1; i <Body.size(); i++)
		{
			//checks if positions match
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
	
	
	public void Length(boolean a)
	{
		Longer = a;
	}
}
