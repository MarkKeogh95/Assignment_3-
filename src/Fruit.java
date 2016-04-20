import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Fruit {
		
	private int x,y, Svalue;
	private Snake a;
	
	public Fruit(Snake b)
	{
		Random gen = new Random();
		x = gen.nextInt(396);
		y = gen.nextInt(396);
		a = b;
	}
	public void position()
	{
		Random gen = new Random();
		x = gen.nextInt(396);
		y = gen.nextInt(396);
	}
	
	public int Score()
	{
		return Svalue;
	}
	
	public void draw(Graphics a)
	{
		a.setColor(Color.ORANGE);
		a.fillRect(x, y, 5, 5);
	}
	
	public boolean FruitEaten()
	{
		int playerX = a.getX() + 2;
		int playerY = a.getY() + 2;
		if(playerX >= x-1 && playerX <= (x+7))
			if(playerY >= y-1 && playerY <= (y+7))
			{
				position();
				Svalue++;
				return true;
			}
		return false;
	}
}
