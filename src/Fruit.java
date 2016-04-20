import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Fruit {
		
	private int x,y, Svalue, HighestValue = 0;
	private Snake a;
	
	public Fruit(Snake b)
	{
		//Generates a random number between 0 and 396
		Random gen = new Random();
		x = gen.nextInt(396);
		y = gen.nextInt(396);
		a = b;
	}
	public void position()
	{
		//Generates a random number between 0 and 396 to get the coordinates of fruit
		//When a fruit is eaten this method runs
		Random gen = new Random();
		x = gen.nextInt(396);
		y = gen.nextInt(396);
	}
	
	public int Score()
	{
		//Sets the score every time a fruit is eaten
		return Svalue;
	}
	
	public int HighScore()
	{
		//Sets the highscore
		int a = 0;
		if(Svalue > HighestValue)
		{
			a = Svalue;
			HighestValue = a;
		}
		return HighestValue;
	}
	
	public void draw(Graphics a)
	{
		//Draws the fruit
		a.setColor(Color.ORANGE);
		a.fillRect(x, y, 5, 5);
	}
	
	public boolean FruitEaten()
	{
		//Runs when the snake and fruit come into contact
		//Shows x and y position of the head of the snake
		//the + 2 finds the center of the head rectangle
		int playerX = a.getX() + 2;
		int playerY = a.getY() + 2;
		//compares snake to the fruit
		if(playerX >= x-1 && playerX <= (x+6))
			if(playerY >= y-1 && playerY <= (y+6))
			{
				//When hit changes position
				position();
				//increments score
				Svalue++;
				a.Length(true);
				return true;
			}
		return false;
	}
}
