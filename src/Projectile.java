import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{

	Projectile(int x, int y, int height, int width) {
		super(x, y, height, width);
		// TODO Auto-generated constructor stub
		speed = 10;
	}

	void update() {
		y-=speed;	
	}
	
	void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}
	
	
	
	
}