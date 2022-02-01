import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Alien extends GameObject{

	Alien(int x, int y, int height, int width) {
		super(x, y, height, width);
		// TODO Auto-generated constructor stub
		speed = 1;
		if (needImage) {
		    loadImage ("alien.png");
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
	
	
	
	void update() {
		y+=speed;
		super.update();
		
	}
	void draw(Graphics g) {
		
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.yellow);
			g.fillRect(x, y, width, height);
		}
		
		
		
		
		
		
	}
	
	
	
	
	
}

