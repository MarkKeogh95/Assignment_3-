import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Fruit {
		
	private int x,y, Svalue;
	private Snake s;
	
	public void Fruit(Snake a)
	{
		Random gen = new Random();
		x = gen.nextInt(396);
		y = gen.nextInt(396);
		s = a;
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
		a.fillRect(x, y, 4, 4);
	}
	
	public boolean FruitEaten()
	{
		int playerX = s.getX() + 2;
		int playerY = s.getY() + 2;
		if(playerX >= x-1 && playerY <= (x+7))
			if(playerX >= y-1 && playerY <= (y+7))
			{
				position();
				Svalue++;
				return true;
			}
		return false;
	}
}
