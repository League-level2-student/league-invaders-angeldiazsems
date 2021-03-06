import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject{

	Rocketship(int x, int y, int height, int width) {
		super(x, y, height, width);
		// TODO Auto-generated constructor stub
		speed = 10;
		if (needImage) {
		    loadImage ("rocket.png");
		}
	}
	
	
	
public static BufferedImage image;
public static boolean needImage = true;
public static boolean gotImage = false;


void loadImage(String imageFile) {
    if (needImage) {
        try {
            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
	    gotImage = true;
        } catch (Exception e) {
            
        }
        needImage = false;
    }
}

public Projectile getProjectile() {
	
	return new Projectile(x+width/2,y,10,10);
}

void update() {
	super.update();
	
}


void draw(Graphics g) {
	if (gotImage) {
		g.drawImage(image, x, y, width, height, null);
		
	} else {
		g.setColor(Color.BLUE);
		g.fillRect(collisionBox.x, collisionBox.y, width, height);
	}
}	


public void right() {
	x+=speed;
}
public void left() {
	x-=speed;
}
public void up() {
	y-=speed;
}
public void down() {
	y+=speed;
}
}
